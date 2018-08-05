abstract class Const{
	public static final boolean OURS = true;
	public static final boolean ENERMY = false;
}
abstract class Direction{
	public static final int[][] FOUR= {{1,1},{1,-1},{-1,-1},{1,-1}};	
}

abstract class Object_{	
	
	private int hp;
	private int now_hp;
	private int def;
	private int atk;
	private int playerNum;
	Position position;
	
	public Object_(Position position, int playerNum,int hp, int def, int atk){
		Position out_position = MapTile.setObject(this, position);
		setPosition(out_position);
		setPlayerNum(playerNum);
		setHp(hp);
		setNow_hp(hp);
		setDef(def);
		setAtk(atk);	
		
		String str = (this instanceof Unit)?"유닛 ":"건물 ";
		str += this + "가 " + this.getPosition().toString() + "에 생성 되었습니다.";				
		System.out.println(str);		
	}	
	
	public int getDistance(Object_ object){
		return (int)Math.sqrt(Math.pow(this.getPositionX()-object.getPositionX(),2)
							  +Math.pow(this.getPositionX()-object.getPositionX(),2));
	}
	
	public void damaged(int damage){
		
		if(damage<0){ //Heal
			return;
		}
		
		if(damage >= this.getNow_hp()){
			// 사망 구현			
		}
		else{
			this.setNow_hp(this.getNow_hp()-damage);
		}
	}
	
	public int getPlayerNum() {
		return playerNum;
	}
	public void setPlayerNum(int playerNum) {
		this.playerNum = playerNum;
	}
	public Position getPosition() {
		return position;
	}
	public int getPositionX(){
		return position.getX();
	}
	public int getPositionY(){
		return position.getY();
	}
	public void setPosition(int x, int y){
		this.position = new Position(x,y);
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getNow_hp() {
		return now_hp;
	}

	public void setNow_hp(int now_hp) {
		this.now_hp = now_hp;
	}

	public int getDef() {
		return def;
	}
	public void setDef(int def) {
		this.def = def;
	}
	public int getAtk() {
		return atk;
	}
	public void setAtk(int atk) {
		this.atk = atk;
	}		
}

interface Skill{
	void execute(Object_ object);

}

interface IAttackable{
}
interface IGroundAttack extends IAttackable{
}
interface ISkyAttack extends IAttackable{
}
interface IUnAttackable{	
}

interface IMovable{
}
interface ISkyMove extends IMovable{
}
interface IGroundMove extends IMovable{
}
interface IUnMovable{
}

class Position{
	private int x;
	private int y;	
	
	public Position(int x, int y){
		setX(x);
		setY(y);
	}
	public Position(Position position){		
		setX(position.getX());
		setY(position.getY());
	}	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	@Override
	public String toString(){
		return "("+ x + "," + y + ")";
	}
}

abstract class MapTile{	
	

	public static Object_[][] object = new Object_[100][100];
	/* 100x100 size Map Tiles
	 * Only positive position
	 * All Object size fixed 1x1  
	 */	
	
	public static boolean isHereObject(int x, int y){
		return MapTile.object[x][y] != null;
	}
	public static boolean isHereOject(Position position){		
		return MapTile.object[position.getX()][position.getY()] != null;
	}
	
	public static Object_ getObject(int x, int y){
		return MapTile.object[x][y];
	}
	public static Object_ getObject(Position position){
		return MapTile.object[position.getX()][position.getY()];
	}	
	public static void DeleteObject(int x, int y){
		MapTile.object[x][y] = null;		
	}
	
	public static Position setObject(Object_ object, Position position){ 
		/* Unit, Buliding don't come out same position */
		
		int x = position.getX();
		int y = position.getY();
		
		if(MapTile.isHereOject(position)){			
			int i = 1;
			Loop : while(true){
				 for(int j=0 ; j<4 ; j++){
					
					x = position.getX()+i*Direction.FOUR[j][0];
					y = position.getY()+i*Direction.FOUR[j][1];
					if(x>=0 && y>=0 && MapTile.object[x][y]==null){
						MapTile.object[x][y]=object;
								break Loop;
					}					
				}				
				i++;
			}		
		}
		else {
		
			MapTile.object[position.getX()][position.getY()] = object;
		}
		
		return new Position(x, y);		
	}	
}

abstract class Building extends Object_{
	public Building(Position position, int playerNum, int hp, int def, int atk){
		super(position, playerNum, hp, def, atk);
	}
}

abstract class Unit extends Object_{ 
	
	
	
	public Unit(Position position,int playerNum, int hp, int def, int atk){
		super(position, playerNum,hp,def,atk);	
		setNow_hp(hp);
	}
	
	public Object_ senser(int senser_range, boolean ally){
		
		int x;
		int y;		
		
		Object_ object;
		
		for(int i=0 ; i<=senser_range ; i++){
			for(int x1=0 ; x1<=i ; x1++){
				for(int y1=(int)Math.sqrt(Math.pow(i,2)-Math.pow(x1,2)); y1>=i-x1 ; y1--){
					
					if(x1==0 && y1==0) continue;
					
					for(int k=0 ; k<4 ; k++){ 
						
						x = this.getPositionX() + x1*Direction.FOUR[k][0];
						y = this.getPositionY() + y1*Direction.FOUR[k][1];

						//System.out.println("( " + x1*Direction.FOUR[k][0] + ", " + y1*Direction.FOUR[k][1] +" )" );

						if(x>=0 && y>=0 && MapTile.isHereObject(x, y)){
							
							object = MapTile.getObject(x,y);
							
							if( (object instanceof ISkyMove && !(this instanceof ISkyAttack))
								|| (object instanceof IGroundMove && (!(this instanceof IGroundAttack)&&(this instanceof ISkyMove)))
								|| (object == this))								
								continue;
							
							if(ally == Const.OURS && object.getPlayerNum() == this.getPlayerNum()){
								
								String str = this + this.getPosition().toString() + ((this instanceof Unit)?"유닛이 ":"건물이 ");
								str += object + object.getPosition().toString() + "아군" + ((object instanceof Unit)?"유닛을 ":"건물을 ");
								str += "감지했습니다";								
								System.out.println(str);
								
								return object;
							}	

							if(ally == Const.ENERMY && object.getPlayerNum() != this.getPlayerNum()){
								
								String str = this + this.getPosition().toString() + ((this instanceof Unit)?"유닛이 ":"건물이 ");
								str += object + object.getPosition().toString() + "적군" + ((object instanceof Unit)?"유닛을 ":"건물을 ");
								str += "감지했습니다";								
								System.out.println(str);
								
								return object;
							}
						}
					}
				}
			}
		}	
		return null;		
	}
	
	abstract void Move(int senser_range, Position position);
	

	public void skillPosition(int skill_range, Position position, Skill skill){
		
	}
	public void skillTarget(int skill_range, Object_ object, Skill skill){
		
		int start_x = this.getPositionX();
		int start_y = this.getPositionY();
		
		int x = start_x;
		int y = start_y;
		
		int end_x = object.getPositionX();
		int end_y = object.getPositionY();
		
		int i;
		
		do{
			
			if(start_x != end_x){	
				
				i = x + ((start_x > end_x)?-1:+1);	
				
				x = i;
				y = (int)((double)(end_y - start_y)/(end_x - start_x)*(x-start_x))+start_y;	
				
			}
			else{ // parallel y-axis
				
				
				 i = y + ((start_y>end_y)?-1:+1);
				 
				 x = start_x;
				 y = i;				
			}
			
			this.setPosition(x, y);
			
			String str = this + "유닛이 " + object + "으로 향해 ";
			str += this.getPosition().toString();
			str += "로 이동했습니다.";
			System.out.println(str);	
			
			if(skill_range > this.getDistance(object)){
				
				skill.execute(object);
				return;				
			}
			
			end_x = object.getPositionX();
			end_y = object.getPositionY();			
			
			
		}while(!(x == end_x && y == end_y));		
	}

	
	/*
	public void commended(String commend){}
	public void commended(String commend, Object_ object){}
	public void commended(String commend, Position position){}
	 */
}
	

abstract class TerranUnit extends Unit{

	public TerranUnit(Position position, int playerNum, int hp, int def, int atk) {
		super(position, playerNum, hp, def, atk);		
	}
}

abstract class ProtossUnit extends Unit{
	
	private int shield;	

	public ProtossUnit(Position position, int playerNum,int hp, int def, int atk, int shield){
		super(position, playerNum,hp,def,atk);
		setShield(shield);
	}
	
	public int getShield() {
		return shield;	
	}
	public void setShield(int shield) {
		this.shield = shield;
	}
}
abstract class ZergUnit extends Unit{

	public ZergUnit(Position position, int playerNum, int hp, int def, int atk) {
		super(position, playerNum, hp, def, atk);		
	}	
}

class Mutal extends ZergUnit implements ISkyMove, ISkyAttack, IGroundAttack {

	public Mutal(Position position, int playerNum, int hp, int def, int atk) {
		super(position, playerNum, hp, def, atk);		
	}
	
	@Override
	public void Move(int senser_range, Position position){
		
		int start_x = this.getPositionX();
		int start_y = this.getPositionY();
		
		int x = start_x;
		int y = start_y;
		
		int end_x = position.getX();
		int end_y = position.getY();
		
		int i;
		
		do{
			
			if(start_x != end_x){ // + 조건을 기울기 값으로 바꾸기	
				
				i = x + ((start_x > end_x)?-1:+1);	
				
				x = i;
				y = (int)((double)(end_y - start_y)/(end_x - start_x)*(x-start_x))+start_y;	
				
			}
			else{ // parallel y-axis
				
				
				 i = y + ((start_y>end_y)?-1:+1);
				 
				 x = start_x;
				 y = i;				
			}
			
			this.setPosition(x, y);
			
			String str = this + "유닛이 " + this.getPosition().toString();
			str += "로 이동했습니다.";
			System.out.println(str);					
			
			Object_ object = this.senser(senser_range, Const.ENERMY);
			
			if(object!=null){
				
				str = this + "유닛이 현재경로에서 ";
				str += object + object.getPosition().toString() + "로 가는 중간경로가 추가됩니다.";					
				System.out.println(str);
				
				
				this.skillTarget(2, object, new Default());	
				
				// route reset
				start_x = this.getPositionX();
				start_y = this.getPositionY();
				x = start_x;
				y = start_y;
						
			}			
			
			
		}while(!(x == end_x && y == end_y));			
	}	

	 private class Default implements Skill{
	        public void execute(Object_ object){
	        	
	        	String str = this + "유닛이 " + object + ((object instanceof Unit)?"유닛을":"건물를");
	    		str += " 공격해서 없앱니다.";
	    		System.out.println(str);
	    		
	    		int x = object.getPositionX();
	    		int y = object.getPositionY();
	    		
	    		//object = null;
	    		MapTile.DeleteObject(x,y);
	    		//System.out.println(MapTile.isHereObject(x, y));  		
	    		
	        }    
	  }
	
	
}

class Medic extends TerranUnit implements IGroundMove, IUnAttackable{

	public Medic(Position position, int PlayerNum, int hp, int def, int atk) {
		super(position, PlayerNum, hp, def, atk);		
	}
	
	@Override
	public void Move(int senser_range, Position position){
		
		int start_x = this.getPositionX();
		int start_y = this.getPositionY();
		
		int x = start_x;
		int y = start_y;
		
		int end_x = position.getX();
		int end_y = position.getY();
		
		int i;
		
		do{
			
			if(start_x != end_x){ // + 조건을 기울기 값으로 바꾸기	
				
				i = x + ((start_x > end_x)?-1:+1);	
				
				x = i;
				y = (int)((double)(end_y - start_y)/(end_x - start_x)*(x-start_x))+start_y;	
				
			}
			else{ // parallel y-axis
				
				
				 i = y + ((start_y>end_y)?-1:+1);
				 
				 x = start_x;
				 y = i;				
			}
			
			this.setPosition(x, y);
			
			String str = this + "유닛이 " + this.getPosition().toString();
			str += "로 이동했습니다.";
			System.out.println(str);					
			
			// Medic에서만 수정
			Object_ object = this.senser(senser_range, Const.OURS); 
			
			// Medic에서만 수정
			if(object!=null && object instanceof Unit && object.getHp() != object.getNow_hp() ){
				
				str = this + "유닛이 현재경로에서 ";
				str += object + object.getPosition().toString() + "로 가는 중간경로가 추가됩니다.";					
				System.out.println(str);
				
				
				this.skillTarget(2, object, new Default());	
				
				// route reset
				start_x = this.getPositionX();
				start_y = this.getPositionY();
				x = start_x;
				y = start_y;
						
			}			
			
			
		}while(!(x == end_x && y == end_y));			
	}	

	 private class Default implements Skill{
	        public void execute(Object_ object){
	        	
	        	String str = this + "유닛이 " + object + "유닛을";
	    		str += "회복 시킵니다.";
	    		System.out.println(str);
	    		
	    		object.setNow_hp(object.getHp());
	    		
	    		//int x = object.getPositionX();
	    		//int y = object.getPositionY();
	    		//object = null;
	    		//MapTile.DeleteObject(x,y);
	    		//System.out.println(MapTile.isHereObject(x, y));  		
	    		
	        }    
	  }
}
class Zealot extends ProtossUnit implements IGroundMove, IGroundAttack{	
	
	
	public Zealot(Position position,int playerNum,int hp, int def, int atk, int shield){		
		super(position, playerNum,hp,def,atk,shield);		
	}	
	
	@Override
	public void Move(int senser_range, Position position){
		
		int start_x = this.getPositionX();
		int start_y = this.getPositionY();
		
		int x = start_x;
		int y = start_y;
		
		int end_x = position.getX();
		int end_y = position.getY();
		
		int i;
		
		do{
			
			if(start_x != end_x){ // + 조건을 기울기 값으로 바꾸기 , 속도 고려 x	
				
				i = x + ((start_x > end_x)?-1:+1);	
				
				x = i;
				y = (int)((double)(end_y - start_y)/(end_x - start_x)*(x-start_x))+start_y;	
				
			}
			else{ // parallel y-axis
				
				
				 i = y + ((start_y>end_y)?-1:+1);
				 
				 x = start_x;
				 y = i;				
			}
			
			this.setPosition(x, y);
			
			String str = this + "유닛이 " + this.getPosition().toString();
			str += "로 이동했습니다.";
			System.out.println(str);					
			
			Object_ object = this.senser(senser_range, Const.ENERMY);
			
			if(object!=null){
				
				str = this + "유닛이 현재경로에서 ";
				str += object + object.getPosition().toString() + "로 가는 중간경로가 추가됩니다.";					
				System.out.println(str);
				
				
				this.skillTarget(2, object, new Default());	
				
				// route reset
				start_x = this.getPositionX();
				start_y = this.getPositionY();
				x = start_x;
				y = start_y;
						
			}			
			
			
		}while(!(x == end_x && y == end_y));			
	}	

	private class Default implements Skill{
        public void execute(Object_ object){
        	
        	String str = this + "유닛이 " + object + ((object instanceof Unit)?"유닛을":"건물를");
    		str += " 공격해서 없앱니다.";
    		System.out.println(str);
    		
    		int x = object.getPositionX();
    		int y = object.getPositionY();
    		
    		//object = null;
    		MapTile.DeleteObject(x,y);
    		//System.out.println(MapTile.isHereObject(x, y));  		
    		
        }    
	}
 }







public class ZealotTest3{
	public static void main(String[] args){		
		
		Zealot z1 = new Zealot(new Position(0,0),2,100,1,8,10);
		Zealot z2 = new Zealot(new Position(4,5),1,100,1,8,10);
		Mutal m = new Mutal(new Position(40,20),2,100,1,8);
		Medic md1 = new Medic(new Position(58,18),3,100,1,0);
		Medic md2 = new Medic(new Position(58,18),3,100,1,0);	
		System.out.println();
				
		System.out.println("좌표 (0,0)에는 " + MapTile.getObject(0,0));
		System.out.println("좌표 (1,0)에는 " + MapTile.getObject(1,0));
		System.out.println("좌표 (58,18)에는 " +  MapTile.getObject(58,18));		
		System.out.println();
		
		int senser_range = 10;
		Object_ object1 = z1.senser(senser_range, Const.ENERMY);
		System.out.println(object1);
		Object_ object2 = md1.senser(senser_range, Const.OURS);
		System.out.println(object2);
		System.out.println();	
		
		senser_range = 5;
		z1.Move(senser_range, new Position(10,5));	
		System.out.println();
		
		senser_range = 10;
		m.Move(senser_range, new Position(60,20));
		System.out.println();
		
		
		Medic md3 = new Medic(new Position(30,10),5,100,1,0);
		md3.damaged(80);
		System.out.println(md3 + "유닛의 현재 hp는 (" +md3.getNow_hp() + "/" + md3.getHp() + ") 입니다.");
		System.out.println();
				
		Medic md4 = new Medic(new Position(35,15),5,100,1,0);
		md4.Move(4, new Position(25,10));		
		System.out.println(md3 + "유닛의 hp는 (" +md3.getNow_hp() + "/" + md3.getHp() + ") 입니다.");		

		
	}
}

