class ServerTest {
	public static void main(String[] args) {
		
		Server s = new Server();

		Tv tv = new Tv();
		Audio audio = new Audio();
		Video v = new Video();

		s.performTurnOn(tv);
		s.performTurnOff(tv);

		s.performTurnOn(audio);
		s.performTurnOff(audio);

		s.performTurnOn(v);
		s.performTurnOff(v);
	}
}
