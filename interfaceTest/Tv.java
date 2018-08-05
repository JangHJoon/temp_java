class Tv implements IMachine {
	@Override
	public void turnOn() {
		System.out.println("TV : turn on");
	}
	@Override
	public void turnOff() {
		System.out.println("TV : turn off");
	}
}
