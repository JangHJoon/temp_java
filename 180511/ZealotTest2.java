import java.util.Scanner;
//gamer has units -> unit
// race 상수선언
// unit playerNum 추가
// unit commend 추상 메소드 
// class Zealot extends Unit implement IActtackable, IGround{}

abstract class Const{
	//종족
	public static final int RANDOM  = 0;
	public static final int TERRAN  = 1;
	public static final int PROTOSS = 2;
	public static final int ZERG    = 3;
}

class Gamer{

	private String id;
	private String race;
	private Map_ map;
	private int playerNum;

	private int mineral=0;
	private int gas=0;
	private int resource=5;
	
	// b
	public void setMineral(int mineral){
		this.mineral = mineral;
	}
	public int getMineral(){
		return mineral;
	}
	public void setGas(int gas){
		this.gas = gas;
	}
	public int getGas(){
		return gas;
	}
	public int getPlayerNum(){
		return playerNum;
	}

	// c
	public Gamer(Room room, String id, String race){
		this.loadMap(room);
		this.race = race;
		this.id = id;

		this.playerNum = (int)(Math.random()*map.getLimitNumber())+1;
		setBaseObject(race);
	}
	private void loadMap(Room room){
		this.map = room.getMap();
	}

	private void setPlyaerNum(){
		// 
	}
	private void setBaseObject(String race){

		if(race=="Protoss"){
			for (int i = 5 ; i > 0 ; i-- ){
				Probe p = new Probe();			
			}
			Nexus n = new Nexus();
		}

		if(race=="Terran"){

		}

		if(race=="Zerg"){
		
		}



	}
	public void chat(String string){
		if(string=="show me the money"){
			setMineral(getMineral()+100000);
			setGas(getGas()+100000);
		}
		System.out.println(id + " : " + string);
	}


	public void commend(Unit unit, String commend){
		unit.commend(commend);
	}

	
	public void commend(Unit unit, String commend1, String commend2){
		unit.commend(commend1, commend2);
	}

	public void commend(Building building, String commend){
		building.commend(commend);
	}

	
	public void leaveGame(){
	}

}
//////////////////////////////////////////////////////////////////////////////////////
class Map_{
	private String name;	
	private int limitNumber;

	public Map_(String name){
		loadMap(name);
	}

	public void loadMap(String name){
		
		if(name=="lost_temple"){
			setName(name);
			setLimitNumber(4);			
		} 
		else{
			System.out.println("해당하는 맵이 없습니다");
			// error
		}
	}

	public void setName(String name){
		this.name = name;
	}
	public void setLimitNumber(int limitNumber){
		this.limitNumber = limitNumber;		
	}
	public int getLimitNumber(){
		return limitNumber;
	}
}

class Visitor extends User{

	private String race;

	public Visitor(User user){
		super(user.getId());
	}
	public void selectRace(String race){
		setRace(race);	
	}
	public User leaveRoom(){
		return (User)this;
	}
	public void setRace(String race){
		this.race = race;
	}
}

class Manager extends User{
	
	private String race;
	private Room room;

	public Manager(User user,Room room){
		super(user.getId());
		setRoom(room);		
	}
	public void selectRace(String race){
		setRace(race);	
	}

	public void addComputer(int comNumber){
		room.addComNumber(comNumber);
	}
	public void addBlock(int blockNumber){
		room.addBlockNumber(blockNumber);
	}
	public Gamer start(){
		Gamer gamer = new Gamer(getRoom(),getId(),getRace());
		return gamer;
	}
	public void kickUser(int userNum){
		//
	}
	public User delRoom(){
		return (User)this;
	}
	
	public void setRace(String race){
		this.race = race;
	}
	
	public String getRace(){
		return race;
	}

	public void setRoom(Room room){
		this.room = room;
	}
	public Room getRoom(){
		return room;
	}

}



class Visitors{
	
	private int max;
	Visitor[] user = new Visitor[7];
	

	public Visitors(int max){
		setMax(max);
	}
	
	public void addVisitors(Visitor user){		
		for(int i = 0 ; i < max ; i++){
			if(this.user[i]==null){
				this.user[i]=user;
				break;
			}
		}	
	}

	public int getVisitorNum(){
		for(int i = 0 ; i < max ; i++){
			if(user[i]==null){
				return i;
			}
		}		
		return max;
	}

	public void setMax(int max){
		this.max = max;
	}

}



class Room{

	private Map_ map;
	private String title;
	private String password;

	
	Visitors visitors;
	private int blockNumber = 0;	
	

	//
	private int userNumber  = 1;
	private int comNumber   = 0;
	

	public void addVisitor(Visitor visitor){
		visitors.addVisitors(visitor);
		//System.out.println("visitors : "+visitors);

	}

	public Room(Map_ map, String title, String password){
		setMap(map);
		setTitle(title);
		setPassword(password);
		visitors = new Visitors(map.getLimitNumber()-1);
		//System.out.println("visitors: "+visitors);
	}	
	

	public void addComNumber(int comNumber){
		int limit = map.getLimitNumber();
		int occupy = getOccupyNum();
		
		if( limit >= comNumber + occupy){
			setComNumber(comNumber);
		} 
		else if(comNumber + getComNumber() < 0){
			setComNumber(0);
		}
		else{
			setComNumber(limit - occupy);
		}	 
	}
	public void addBlockNumber(int blockNumber){
		int limit = map.getLimitNumber();
		int occupy = getOccupyNum();
		
		if( limit >= blockNumber + occupy){
			setBlockNumber(comNumber);
		} 
		else if(blockNumber + getBlockNumber() < 0){
			setBlockNumber(0);
		}
		else{
			setBlockNumber(limit - occupy);
		}
		
	}



	public void setMap(Map_ map){
		this.map = map;
	}
	public boolean isFull(){
		return getOccupyNum() == map.getLimitNumber(); 
	}
	public void setTitle(String title){
		this.title = title;
	}
	public boolean checkPassword(String password){
		return this.password == password;
	}
	public void setPassword(String password){
		this.password = password;
	}
	public int getOccupyNum(){
		return getBlockNumber() + getComNumber() + getUserNumber();
	}
	public void setBlockNumber(int blockNumber){
		this.blockNumber = blockNumber;
	}
	public int getBlockNumber(){
		return blockNumber;
	}
	public int getComNumber(){
		return comNumber;
	}
	public int getUserNumber(){
		return userNumber;
	}
	public void setComNumber(int comNumber){
		this.comNumber = comNumber;
	}
	public Map_ getMap(){
		return map;
	}

}


class User{

	private String id;
	private String pw;
	private String server;
	private boolean isOnline = false;	
	

	public User(String id){
		setId(id);
	}
	public User(String id, String pw, String server){
		login(id,pw,server);
	}
	public void login(String id,String pw,String server){
	}

	
	// 방장
	public Manager createRoom(Map_ map, String title){
		 return createRoom(map,title,"");
	}
	public Manager createRoom(Map_ map, String title, String password){
		 return new Manager(this, new Room(map,title,password));
	}
	

	//참가자
	public Visitor joinRoom(Room room){

		if(room.isFull()){
			System.out.println("방이 가득 찼습니다.");
		}
		else{

			if(room.checkPassword("")){ //입장

				Visitor visitor= new Visitor(this);
				room.addVisitor(visitor);
				return visitor;		
			
			}
			else{
				System.out.println("비밀번호 : ");
				Scanner input = new Scanner(System.in);
				String password = input.nextLine();

				if(room.checkPassword(password)){ //입장

					Visitor visitor= new Visitor(this);
					room.addVisitor(visitor);
					return visitor;

				} 
				else {
					System.out.println("비밀번호가 틀렸습니다.");
				}
			}						
		}

		return null;
	}


	public void logout(){
		this.id = "";
		this.pw = "";
		this.server ="";
	}	




	public String getId(){
		return id;
	}
	public void setId(String id){
		this.id=id;
	}
}


///////////////////////////////////////////////////////////////////////////////////////////////////
class Building{
	private int hp;
	private int def;
	public Building(int hp,int def){
		this.hp = hp;
		this.def = def;
	}

	public void commend(String commend){

	}
}
class Nexus extends Building{
	private int shield;
	
	public Nexus(){
		super(750,1);
		shield = 750;
	}	
	public void commend(String commend){
		if(commend == "p"){
			Probe p = new Probe();
		}
	}
	
}
class GateWay extends Building{
	private Building building;
	private int shield;

	public GateWay(){
		super(500,1);
		shield = 500;
	}
	
	public void commend(String commend){
		if(commend == "z"){
			Zealot z = new Zealot();
		}
	}
}

abstract class Unit{ //추상클래스로 변경
	private int owner; //playerNum

	private int hp;
	private int atk;
	private int def;
	private String race;
	private boolean isGround;
	

	public Unit(int hp, int atk, int def, boolean isGround){
		this.hp = hp;
		this.atk = atk;
		this.def = def;
		this.isGround = isGround;

		//임시
		this.owner = 0;
	}	

	public int getOwner(){
		return owner;
	}
	

	// 후 추상 메소드로 변경하자
	public void commend(Unit unit){
	}
	public void commend(Unit unit, String commend1, String commend2){
	}
	
	public void commend(Building building){

	}

	//작업중
	public void commend(String commend1, String commend2){ 	
	}

	public void commend(String commend){
	}
	public void commend(String commend, Unit unit){
		if(commend == "a"){

			//
		}
		

	}
	public void commend(String commend, Building building){

	}
	
}

class Probe extends Unit{
	private int shield;

	public Probe(){
		super(20,5,0,true);
		shield = 60;
	}
	public void commend(String commend1, String commend2){
		
		//boolean build_mode = false;
		
		if(commend1=="b"){
			//build_mode = true;
			if(commend2=="g"){
				GateWay g = new GateWay();
				//System.out.println(super.getOwner());

			}


		}


	}
	
	/*
	public void commend(String commend){
		if(commend == "bg"){
			GateWay g = new GateWay();
		}
	}
	*/
}
class Zealot extends Unit{
	private int shield;	

	public Zealot(){
		super(100,8*2,1,true);
		shield = 60;
		System.out.println("My life for Aiur!");
	}
}
class Mutal extends Unit{
	
	public Mutal(){
		super(120,9,0,false);	
	}	
}
class Medic extends Unit{

	public Medic(){
		super(60, 0, 1, true);
	}

}

public class ZealotTest2{
	public static void main(String[] args){

		User user1 = new User("boxer");
		Manager manager = user1.createRoom(new Map_("lost_temple"),"초보방");
		manager.selectRace("Protoss");
		manager.addComputer(1);
		Room room = manager.getRoom();		

		
		
		
		User user2 = new User("YellOw");
		Visitor visitor = user2.joinRoom(room);
		if(visitor != null){ // 입장 완료
			visitor.selectRace("Zerg");
		}

		User user3 = new User("CHO_BO");
		Visitor visitor2 = user3.joinRoom(room);
		if(visitor2 != null){ // 입장 완료
			visitor2.selectRace("Zerg");
		}

	

		System.out.println(room.visitors.getVisitorNum());
		
		Gamer gamer = manager.start();

		gamer.chat("show me the money");
		gamer.commend(new Probe(),"b","g");
		gamer.commend(new GateWay(),"z");
		gamer.chat("gg");
		gamer.leaveGame();

		user1.logout();
		//user2.logout();
		
	}
}
