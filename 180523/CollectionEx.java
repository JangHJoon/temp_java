class ExceptionEx3 {

	public static void doManything(int num1, int num2) {
		try {
			System.out.println(num1 / num2); //
			int[] arr = new int[num1]; //
		} catch(ArithmeticException e) {
			System.out.println("0���� ������ �����~");
		} catch(NegativeArraySizeException e) {
			System.out.println("�迭�� ���̴� ������ �� �� �����ϴ�.");
		} catch(Exception e) {
			// �տ��� Exception�� ���� ����. 
			// ����Ŭ�������� ���ʵ��� �־���Ѵ�.
			System.out.println("���� �߻�");
		} 
	}

	public static void main(String[] args) {
		doManything(-1, 4);		
	}
}
