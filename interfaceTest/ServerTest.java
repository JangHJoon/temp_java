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

		// 인터페이스 
		// 서로 장치와 서버 사이의 표준 규격, 통일된 방법, 합의
		// 장치가 인터페이스에 맞는 함수를 구현하면
		// 서버는 그냥 인터페이스에 따라 쓰면 된다.
	}
}
