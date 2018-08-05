interface IAllSkill{
}


abstract class ManaCostSkill implements ICostSkill{
	
	private int mana_cost;

	public ManaCostSkill(int mana_cost){
		setMana_cost(mana_cost);
	}
	public void setMana_cost(int mana_cost){
		this.mana_cost = mana_cost;
	}

	abstract void manaSkill(ISkillTarget target);
}
interface ICostSkill extends IAllSkill{
	
}

interface INonCostSkill extends IAllSkill{
	void skill(ISkillTarget target);
}
class DefaultAttack implements INonCostSkill{
	@Override
	public void skill(ISkillTarget target){

		System.out.println("때린다");
	}
}
class DefaultMove implements INonCostSkill{

	@Override
	public void skill(ISkillTarget target){
		System.out.println("강제 이동합니다");
	}
}
class SenseMove implements INonCostSkill{

	@Override
	public void skill(ISkillTarget target){
		System.out.println("공격 이동합니다");
	}
}
class Hold implements INonCostSkill{

	@Override
	public void skill(ISkillTarget target){		
	}
}

class HealHP extends ManaCostSkill{

	public HealHP(int mana_cost){
		super(mana_cost);
	}	

	@Override
	public void manaSkill(ISkillTarget target){
		System.out.println("HP를 회복시킨다");
	}
}


class Map{

	String name;
	private int width;
	private int height;
	private int player_max;
	
	public Map(String name, int width, int height, int player_max){
		setName(name);
		setWidth(width);
		setHeight(height);
		setPlayer_max(player_max);
	}
	
	public int getWidth(){
		return width;
	}
	public int getHeight(){
		return height;
	}
	public void setPlayer_max(int player_max){
		this.player_max = player_max;
	}
	public void setWidth(int width){
		this.width = width;
	}
	public void setHeight(int height){
		this.height = height;
	}
	public void setName(String name){
		this.name = name;
	}


}

interface ISkillTarget{
}

interface IDirection{
	int[][] FOUR = {{1,1}, {1,-1}, {-1,1}, {-1,-1}};
}

class Tile{
	private Object object;
	
	public void setObject(Object object){
		this.object = object;
	}
	public Object getObject(){
		return null;
	}
}

abstract class MapTile{

	public static Tile[][] tiles;

	public static void loadingMap(Map map){
		int width = map.getWidth();
		int height = map.getHeight();
		setMapTile(width,height);
	}

	public static void setMapTile(int width, int height){
		tiles = new Tile[width][height];
	}
	public static boolean isHereObject(Position position){
		return false;
	}
	public static Objects getObject(Position position){
		return null;	
	}
	public static void setObject(Objects object, Position position){
	}
	



}

class Position implements ISkillTarget{
	private int x;
	private int y;

	public Position(int x,int y){
		setX(x);
		setY(y);
	}

	public void setX(int x){
		this.x = x;
	}
	public void setY(int y){
		this.y = y;
	}
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
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
interface IGroundMove extends IMovable{
}
interface ISkyMove extends IMovable{
}
interface IUnMovable{
}

interface IDownable{
	void changeDownEntity();

}
interface IUpable{
	void changeUpEntity();

}


abstract class Objects implements ISkillTarget{ 
	private int playerNum;
	private int hp_max;
	private int hp_now;
	private int atk;
	private int def;
	private int speed;
	private IAllSkill[] skills;
	private Position position;


	abstract void commended(String commend, ISkillTarget object);

	public Objects(Position position, int playerNum, int atk, int hp_max, int def, int speed ,IAllSkill... skills){		
	}

	public int getPlayerNum() {
		return playerNum;
	}

	public void setPlayerNum(int playerNum) {
		this.playerNum = playerNum;
	}

	public int getHp_max() {
		return hp_max;
	}

	public void setHp_max(int hp_max) {
		this.hp_max = hp_max;
	}

	public int getHp_now() {
		return hp_now;
	}

	public void setHp_now(int hp_now) {
		this.hp_now = hp_now;
	}

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = def;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public IAllSkill[] getSkill() {
		return skills;
	}

	public void setSkill(IAllSkill... skills) {
		this.skills = skills;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public int getAtk() {
		return atk;
	}

	public void setAtk(int atk) {
		this.atk = atk;
	}

}
abstract class Building extends Objects{

	public Building(Position position, int playerNum, int atk, int hp_max, int def, int speed ,IAllSkill... skills){
		super(position, playerNum, hp_max, atk, def, speed, skills);
	}

}

abstract class TerranBuilding extends Building{

	public TerranBuilding(Position position, int playerNum, int atk,  int hp_max, int def, int speed ,IAllSkill... skills){
		super(position, playerNum, hp_max, atk, def, speed, skills);
	}
	



	void recovered(){
	}
}

class Barrack extends TerranBuilding implements IUpable{

	public Barrack(Position position, int playerNum, int hp_max, int atk, int def, int speed, IAllSkill... skills){
		super(position, playerNum, hp_max, -1, def, -1, skills);
	}
	
	@Override
	public void commended(String commend, ISkillTarget object){
	}
	@Override
	public void changeUpEntity(){
	}
}

class SkyBarrack extends TerranBuilding implements ISkyMove, IDownable{
	public SkyBarrack(Position position, int playerNum, int hp_max, int atk, int def, int speed, IAllSkill... skills){
		super(position, playerNum, hp_max, -1, def, speed, skills);
	}
	@Override
	public void commended(String commend, ISkillTarget object){
	}
	@Override
	public void changeDownEntity(){

	}
}

abstract class Unit extends Objects{

	public Unit(Position position, int playerNum, int hp_max, int atk,  int def, int speed ,IAllSkill... skills){
		super(position, playerNum, hp_max, atk, def, speed, skills);
	}	

	
	
	
}

abstract class TerranUnit extends Unit{

	public TerranUnit(Position position, int playerNum, int hp_max, int atk, int def, int speed ,IAllSkill... skills){
		super(position, playerNum, hp_max, atk, def, speed, skills);
	}
}
abstract class ProtossUnit extends Unit{


	private int shield;

	public ProtossUnit(Position position, int playerNum, int hp_max, int atk,  int def, int speed, int shield, IAllSkill... skills){
		super(position, playerNum, hp_max, atk, def, speed, skills);
		setShield(shield);
	}

	public void setShield(int shield){
		this.shield = shield;
	}

	public void recover(){
	}

	public int getShield() {
		return shield;
	}
}
abstract class ZergUnit extends Unit{

	public ZergUnit(Position position, int playerNum, int hp_max, int atk,  int def, int speed, IAllSkill... skills){
		super(position, playerNum, hp_max, atk, def, speed, skills);
	}
	
	public void recover(){
	}
}


class Medic extends TerranUnit implements IGroundMove, IUnAttackable{

	private int mana_max;
	private int mana_now;
	
	
	public Medic(Position position, int playerNum, int hp_max, int atk,  int def, int speed, int mana_max, IAllSkill... skills){
		super(position, playerNum, hp_max, -1, def, speed, skills);
		this.setMana_max(mana_max);
	}


	@Override
	public void commended(String commend, ISkillTarget object){
	}



	public int getMana_max() {
		return mana_max;
	}



	public void setMana_max(int mana_max) {
		this.mana_max = mana_max;
	}



	public int getMana_now() {
		return mana_now;
	}



	public void setMana_now(int mana_now) {
		this.mana_now = mana_now;
	}
	 

}
class Zealot extends ProtossUnit implements IGroundMove, IGroundAttack{

	public Zealot(Position position, int playerNum, int hp_max, int atk, int def, int speed, int shield, IAllSkill... skills){
		super(position, playerNum, hp_max, atk, def, speed, shield, skills);
	}
	
	

	@Override
	public void commended(String commend, ISkillTarget object){
	}

	
	
}
class Mutal extends ZergUnit implements ISkyMove, IGroundAttack, ISkyAttack{

	public Mutal(Position position, int playerNum, int hp_max, int atk,  int def, int speed, IAllSkill... skills){
		super(position, playerNum, hp_max, atk, def, speed, skills);
	}

	@Override
	public void commended(String commend, ISkillTarget object){
	}
	
}

 
public class ZealotTest5{
	public static void main(String[] args) {

	}	
}
