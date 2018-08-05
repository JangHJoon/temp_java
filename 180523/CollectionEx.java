class ExceptionEx3 {

	public static void doManything(int num1, int num2) {
		try {
			System.out.println(num1 / num2); //
			int[] arr = new int[num1]; //
		} catch(ArithmeticException e) {
			System.out.println("0으로 나눌수 없어요~");
		} catch(NegativeArraySizeException e) {
			System.out.println("배열의 길이는 음수가 될 수 없습니다.");
		} catch(Exception e) {
			// 앞에서 Exception를 쓸수 없다. 
			// 하위클래스부터 차례도록 넣어야한다.
			System.out.println("문제 발생");
		} 
	}

	public static void main(String[] args) {
		doManything(-1, 4);		
	}
}
