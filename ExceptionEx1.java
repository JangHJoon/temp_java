class ExceptionEx3 {

	public static void doManything(int num1, int num2) {
		try {
			// ArithmeticException
			System.out.println(num1 / num2); 
			// NegativeArraySizeException
			int[] arr = new int[num1]; 
		} catch(ArithmeticException e) {
			System.out.println("0���� ������ �����~");
		} catch(NegativeArraySizeException e) {
			System.out.println("�迭�� ���̴� ������ �� �� �����ϴ�.");
		} catch(Exception e) {
			System.out.println("���� �߻�");
		} 
	}

	public static void main(String[] args) {
		doManything(-1, 4);		
	}
}
