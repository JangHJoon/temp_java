/*
		Wrapper Class

		byte			Byte
		short			Short
		int				Integer
		long			Long
		flaot			Float
		double			Double
		char			Character
		boolean			Boolean

*/
class WrapperClassEx {
	public static void main(String[] args) {
		// JDK1.5~
		int num = 100;
		// int -> Integer ( auto-boxing )
		Integer intObj = num;
		// Integer -> int ( auto-unboxing )
		int otherNum = intObj;
		System.out.println(otherNum);

		// ~JDK1.4
		int n = 3;
		// int -> Integer
		Integer i = new Integer(n);
		// Integer -> int
		int result = i.intValue();
		System.out.println(result);
	}
}
