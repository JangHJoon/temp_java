interface IFlying {
	void fly();
}
class Car {
	public int speed;
	public int gear;
	public String color;
}
class SportsCar extends Car implements IFlying {
	public boolean turbo;
	@Override
	public void fly() {
	}
}
class UseCar {
	public static void main(String[] args) {
		SportsCar c = new SportsCar();
		c.turbo = false;
		c.speed = 100;
		c.gear = 4;
		c.color = "white";

		Car c2 = c;
		c2.color = "red";
		c2.gear = 4;
		c2.speed = 120;
		//c2.turbo = true;

		IFlying c3 = c;
		c3.fly();
		c3.speed = 100;
	}
}
