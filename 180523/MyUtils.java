class MyUtils {
	public static int getRandomNumber(int from, int to) {
		return (int)(Math.random() * (to - from + 1)) + from;
	}

	public static char getRandomChar() {
		int num = getRandomNumber(0, 1);
	
		char c;

		if(num == 0) { 

		c = (char)getRandomNumber('A', 'Z');
		// ascii 값 인가?

		} else { // 무조건 여기로 감

		c = (char)getRandomNumber('a', '2');

		}
		return c;
	}

	public static String getRandomString(int length) {

		String str = "";
		for(int i=0; i<length; i++) {
			str += getRandomChar();
		}
		return str;
	}
}