interface FlyBehavior {
	void fly();
}
interface QuackBehavior {
	void quack();
}
class FlyWithWing implements FlyBehavior {
	@Override
	public void fly() {
		System.out.println("������ ���ƿ�~");
	}
}
class FlyNoWay implements FlyBehavior {
	@Override
	public void fly() {
		System.out.println("�����ƿ�~��.��");
	}
}
class FlyWithRocket implements FlyBehavior {
	@Override
	public void fly() {
		System.out.println("�����~~~");
	}
}
class Quack implements QuackBehavior {
	@Override
	public void quack() {
		System.out.println("�в�");
	}
}
class Squeak implements QuackBehavior {
	@Override
	public void quack() {
		System.out.println("���");
	}
}
class MuteQuack implements QuackBehavior {
	@Override
	public void quack() {
		System.out.println("...");
	}
}
abstract class Duck {
	private FlyBehavior fb;
	private QuackBehavior qb;
	
	public Duck(FlyBehavior fb, QuackBehavior qb) {
		setFb(fb);
		setQb(qb);
	}

	public void setFb(FlyBehavior fb) {
		this.fb = fb;
	}
	public void setQb(QuackBehavior qb) {
		this.qb = qb;
	}
	public FlyBehavior getFb() {
		return fb;
	}
	public QuackBehavior getQb() {
		return qb;
	}
	public void swim() {
		// ����
	}
	public void performFly() {
		fb.fly();
	}
	public void performQuack() {
		qb.quack();
	}
	abstract public void display();
}
class RedHeadDuck extends Duck {

	public RedHeadDuck() {
		super(new FlyWithWing(), new Quack());
	}

	@Override
	public void display() {
		// �����Ӹ� ����
	}
}
class DecoyDuck extends Duck {
	public DecoyDuck() {
		super(new FlyNoWay(), new MuteQuack());
	}
	@Override
	public void display() {
		// ��������
	}
}
class DuckTest {
	public static void main(String[] args) {
		RedHeadDuck d = new RedHeadDuck();
		FlyBehavior fb = d.getFb();
		fb.fly();
		d.performFly();
		// ������ ������...
		d.setFb(new FlyNoWay());
		d.performFly();

		DecoyDuck d2 = new DecoyDuck();
		d2.performFly();
		d2.setFb(new FlyWithRocket());
		d2.performFly();
	}
}
