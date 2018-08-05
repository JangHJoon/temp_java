interface IAllSkill{
}

interface ISkill extends IAllSkill{
	void skill(Objects object);
}
class DefaultAttack implements ISkill{
	@Override
	public void skill(Objects object){
		System.out.println("때린다");
	}
}
class DefaultMove implements ISkill{
	@Override
	public void skill(Objects object){
		System.out.println("강제 이동합니다");
	}
}
class SenseMove implements ISkill{
	@Override
	public void skill(Objects object){
		System.out.println("공격 이동합니다");
	}
}
class Hold implements ISkill{
	@Override
	public void skill(Objects object) {
		
	}
}


interface IManaSkill extends IAllSkill{
	void manaSkill(Objects object);
}
class HealHP implements IManaSkill{
	@Override
	public void manaSkill(Objects object){
		System.out.println("HP를 회복시킨다");
	}
}



 

class Position{
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


class Objects{
	private int playerNum;
	private int hp_max;
	private int hp_now;
	private int atk;
	private int def;
	private int speed;
	private IAllSkill[] skill = new IAllSkill[9];
	private Position position;

	public Objects(Position position, int playerNum, int atk, int hp_max, int def, int speed){		
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
		return skill;
	}

	public void setSkill(IAllSkill[] skill) {
		this.skill = skill;
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
class Building extends Objects{

	public Building(Position position, int playerNum, int atk, int hp_max, int def, int speed){
		super(position, playerNum, hp_max, atk, def, speed);
	}

}

class TerranBuilding extends Building{

	public TerranBuilding(Position position, int playerNum, int atk,  int hp_max, int def, int speed){
		super(position, playerNum, hp_max, atk, def, speed);
	}
	
	void recovered(){
	}
}

class Barrack extends TerranBuilding implements IUpable{

	public Barrack(Position position, int playerNum, int hp_max, int atk, int def, int speed){
		super(position, playerNum, hp_max, -1, def, -1);
	}

	public void changeUpEntity(){
	}
}

class SkyBarrack extends TerranBuilding implements ISkyMove, IDownable{
	public SkyBarrack(Position position, int playerNum, int hp_max, int atk, int def, int speed){
		super(position, playerNum, hp_max, -1, def, speed);
	}
	public void changeDownEntity(){

	}
}

abstract class Unit extends Objects{

	public Unit(Position position, int playerNum, int hp_max, int atk,  int def, int speed){
		super(position, playerNum, hp_max, atk, def, speed);
	}	

	abstract void commended(String commend, Object object);
	
	
}

abstract class TerranUnit extends Unit{

	public TerranUnit(Position position, int playerNum, int hp_max, int atk, int def, int speed){
		super(position, playerNum, hp_max, atk, def, speed);
	}
}
abstract class ProtossUnit extends Unit{


	private int shield;

	public ProtossUnit(Position position, int playerNum, int hp_max, int atk,  int def, int speed, int shield){
		super(position, playerNum, hp_max, atk, def, speed);
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

	public ZergUnit(Position position, int playerNum, int hp_max, int atk,  int def, int speed){
		super(position, playerNum, hp_max, atk, def, speed);
	}
	
	public void recover(){
	}
}


class Medic extends TerranUnit implements IGroundMove, IUnAttackable{

	private int mana_max;
	private int mana_now;
	
	
	public Medic(Position position, int playerNum, int hp_max, int atk,  int def, int speed, int mana_max){
		super(position, playerNum, hp_max, -1, def, speed);
		this.setMana_max(mana_max);
	}



	@Override
	public void commended(String commend, Object object){
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

	public Zealot(Position position, int playerNum, int hp_max, int atk, int def, int speed, int shield){
		super(position, playerNum, hp_max, atk, def, speed, shield);
	}
	
	

	@Override
	public void commended(String commend, Object object){
	}
	public void setSkill(ISkill[] skill){
	}
	
	
}
class Mutal extends ZergUnit implements ISkyMove, IGroundAttack, ISkyAttack{

	public Mutal(Position position, int playerNum, int hp_max, int atk,  int def, int speed){
		super(position, playerNum, hp_max, atk, def, speed);
	}

	@Override
	public void commended(String commend, Object object){
	}
	
}

 
public class ZealotTest4{
	public static void main(String[] args) {
		
		




	}	
}
