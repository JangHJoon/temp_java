/*	
	보통 부분적으로 함수가 비슷하게 구현되는 경우
	인터페이스로 따로 빼서 implements를 한다.	

	완전 공통이면 상위클래스에
	완전 다르면 추상메소드로 하위클래스에 구현하면 되지만

	부분 공통이면 하위클래스 일부에 공통적으로 쓰는 메소드가 생기게 된다.
	문제는 함수가 조금 달라지면 그 부분 공통인 클래스의 함수를 모두 수정해야한다.
	코드의 재사용과 효율성을 위해 부분공통인 메소드를 따로 떼어내서 구현해보자. 

*/
/*
	인터페이스를 직접 하위 클래스에 구현하지 말고 
	상위클래스의 멤버변수로 받고
	상위클래스에 멤버변수를 실행하는 함수를 따로 만든다. 캡슐화

	Strategy Patten
	
	디자인 패턴 - 언제, 경험습득
	안티 패턴 - 추천

	G.O.F
	gang of four

	

*/
interface IQuackBehavior{
	void quack();
}
class Quack implements IQuackBehavior{
	@Override
	public void quack(){ /* 꽉꽉 */}
}
class Squeak implements IQuackBehavior{
	@Override
	public void quack(){ /* 삑삑 */}
}
class MuteQuack implements IQuackBehavior{
	@Override
	public void quack(){ /* .. */}
}

interface IFlyBehavior{
	void Fly();
}

class FlyWithWing implements IFlyBehavior{
	@Override
	public void Fly(){/* 난다 */ }
}
class FlyNoWay implements IFlyBehavior{
	@Override
	public void Fly(){/* 날 지 못한다. */}
}

// 나는 방식 추가 가능
class FlyWithRocket implements IFlyBehavior{
	@Override
	public void Fly(){/* 로켓 */}
}

abstract class Duck{
	private IFlyBehavior flyBehavior;
	private IQuackBehavior quackBehavior;

	public Duck(IFlyBehavior flyBehavior, IQuackBehavior quackBehavior){
		setFlyBehavior(flyBehavior);
		setQuackBehavior(quackBehavior);
	}

	public void performQuack(){
		quackBehavior.quack();
	}
	public void performFly(){
		flyBehavior.Fly();
	}
	public void swim(){ } 
	// 모두다 일치할때는 여기서 구현.

	abstract void display();
	// 모두다 다를때는 추상클래스로 구현

	public void setFlyBehavior(IFlyBehavior flyBehavior){
		this.flyBehavior = flyBehavior;
	}
	public IFlyBehavior getFlyBehavior(){
		return flyBehavior;
	}
	public void setQuackBehavior(IQuackBehavior quackBehavior){
		this.quackBehavior = quackBehavior;
	}
}

class RedHeadDuck extends Duck{
	
	public RedHeadDuck(){
		super((IFlyBehavior)new FlyWithWing(), (IQuackBehavior)new Quack());
	}
	@Override
	void display(){}
}

class GomuDuck extends Duck{

	public GomuDuck(){
		super((IFlyBehavior)new FlyNoWay(), (IQuackBehavior)new Squeak());
	}
	@Override
	void display(){}


}



public class DuckTest{
	public static void main(String[] args) {
		RedHeadDuck rD = new RedHeadDuck();

		IFlyBehavior Fb = rD.getFlyBehavior();
		Fb.Fly();
		// 이거 대신 아래 처럼 만든다. 내부 구성을 몰라도 수행 된다.
		// 인터페이스의 목적을 잘 보여준다.

		rD.performFly();

		// 날개 다침
		rD.setFlyBehavior(new FlyNoWay());
		rD.performFly();
		// 못 난다.

		// 코드 실행때 메소드를 바꿔치기도 가능하다.

	}
}
