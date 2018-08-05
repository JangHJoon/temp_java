
interface BinaryCONST{
		long TIMEOUT = 3600_000;  
		int BINARY_VALUE = 0b1001_0110_1100_0011;  // jdk1.7~
}

class BinaryAndunderscores implements BinaryCONST{
	public static void main(String[] args) {

		System.out.println(TIMEOUT);
		System.out.println(BINARY_VALUE);




	}
}
