interface FlyBehavior {
	void fly();
}
interface QuackBehavior {
	void quack();
}
class FlyWithWing implements FlyBehavior {
	@Override
	public void fly() {
		System.out.println("³¯°³·Î ³¯¾Æ¿ä~");
	}
}
class FlyNoWay implements FlyBehavior {
	@Override
	public void fly() {
		System.out.println("¸ø³¯¾Æ¿ä~¤Ì.¤Ì");
	}
}
class FlyWithRocket implements FlyBehavior {
	@Override
	public void fly() {
		System.out.println("½´¿ì¿õ~~~");
	}
}
class Quack implements QuackBehavior {
	@Override
	public void quack() {
		System.out.println("²Ð²Ð");
	}
}
class Squeak implements QuackBehavior {
	@Override
	public void quack() {
		System.out.println("»à»à");
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
		// ¼ö¿µ
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
		// »¡°£¸Ó¸® ¿À¸®
	}
}
class DecoyDuck extends Duck {
	public DecoyDuck() {
		super(new FlyNoWay(), new MuteQuack());
	}
	@Override
	public void display() {
		// ³ª¹«¿À¸®
	}
}
class DuckTest {
	public static void main(String[] args) {
		RedHeadDuck d = new RedHeadDuck();
		FlyBehavior fb = d.getFb();
		fb.fly();
		d.performFly();
		// ³¯°³¸¦ ´ÙÃÆÀ½...
		d.setFb(new FlyNoWay());
		d.performFly();

		DecoyDuck d2 = new DecoyDuck();
		d2.performFly();
		d2.setFb(new FlyWithRocket());
		d2.performFly();
	}
}
