class Video implements IMachine {
	@Override
	public void turnOn() {
		System.out.println("video on");
	}
	@Override
	public void turnOff() {
		System.out.println("video off");
	}
}
