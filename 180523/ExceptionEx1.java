class ExceptionEx1 {

	public static void divide(int num1, int num2) {
		try{
			//���ܰ� ���ü� �ִ� ����
			int result = num1 / num2;
			// ��Ǯ� ������ �ƴ϶� 
			// ��Ǭ�� �޾����� ������ ���� ����
			System.out.println(result);
			
		} catch(ArithmeticException e) {
			// ArithmeticException �߻� �� ���ܰ�ü e�� �߻�

			System.out.println("0���� ���� �� �����~ : ");
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {

		divide(8, 0);
		divide(8, 2);
		System.out.println("end of main");

		/*
		Exception in thread "main" java.lang.ArithmeticException: / by zero
		Exception Ŭ���� : ����
        
		at ExceptionEx1.divide(ExceptionEx1.java:4)
		������ �� �޼ҵ� : ���° ��
        
		at ExceptionEx1.main(ExceptionEx1.java:8)
		������ �� �޼ҵ� : ���° ��

		Call Stack ������ ������ ��� �ѷ���
		���ܰ� �߻����� �� ������ ���� Ȯ��
		
		���α׷� ���� == Call Stack�� �� �������
		*/

	}
}
