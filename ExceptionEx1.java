class ExceptionEx3 {

	public static void doManything(int num1, int num2) {
		try {
			// ArithmeticException
			System.out.println(num1 / num2); 
			// NegativeArraySizeException
			int[] arr = new int[num1]; 
		} catch(ArithmeticException e) {
			System.out.println("0으로 나눌수 없어요~");
		} catch(NegativeArraySizeException e) {
			System.out.println("배열의 길이는 음수가 될 수 없습니다.");
		} catch(Exception e) {
			System.out.println("문제 발생");
		} 
	}

	public static void main(String[] args) {
		doManything(-1, 4);		
	}
}
