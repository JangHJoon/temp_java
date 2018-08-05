/*	
	���� �κ������� �Լ��� ����ϰ� �����Ǵ� ���
	�������̽��� ���� ���� implements�� �Ѵ�.	

	���� �����̸� ����Ŭ������
	���� �ٸ��� �߻�޼ҵ�� ����Ŭ������ �����ϸ� ������

	�κ� �����̸� ����Ŭ���� �Ϻο� ���������� ���� �޼ҵ尡 ����� �ȴ�.
	������ �Լ��� ���� �޶����� �� �κ� ������ Ŭ������ �Լ��� ��� �����ؾ��Ѵ�.
	�ڵ��� ����� ȿ������ ���� �κа����� �޼ҵ带 ���� ����� �����غ���. 

*/
/*
	�������̽��� ���� ���� Ŭ������ �������� ���� 
	����Ŭ������ ��������� �ް�
	����Ŭ������ ��������� �����ϴ� �Լ��� ���� �����. ĸ��ȭ

	Strategy Patten
	
	������ ���� - ����, �������
	��Ƽ ���� - ��õ

	G.O.F
	gang of four

	

*/
interface IQuackBehavior{
	void quack();
}
class Quack implements IQuackBehavior{
	@Override
	public void quack(){ /* �˲� */}
}
class Squeak implements IQuackBehavior{
	@Override
	public void quack(){ /* ��� */}
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
	public void Fly(){/* ���� */ }
}
class FlyNoWay implements IFlyBehavior{
	@Override
	public void Fly(){/* �� �� ���Ѵ�. */}
}

// ���� ��� �߰� ����
class FlyWithRocket implements IFlyBehavior{
	@Override
	public void Fly(){/* ���� */}
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
	// ��δ� ��ġ�Ҷ��� ���⼭ ����.

	abstract void display();
	// ��δ� �ٸ����� �߻�Ŭ������ ����

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
		// �̰� ��� �Ʒ� ó�� �����. ���� ������ ���� ���� �ȴ�.
		// �������̽��� ������ �� �����ش�.

		rD.performFly();

		// ���� ��ħ
		rD.setFlyBehavior(new FlyNoWay());
		rD.performFly();
		// �� ����.

		// �ڵ� ���ට �޼ҵ带 �ٲ�ġ�⵵ �����ϴ�.

	}
}
