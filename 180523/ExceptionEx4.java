class ExceptionEx4 {
	public static void main(String[] args) {
		int[] arr = null;
		// ������ ���忩��
		try {
			// ���� ���� ����.
			int length = arr.length;
			System.out.println(length);
		} catch(ArithmeticException e) {
			// ���� ���� ����.
			System.out.println("�ٽ� ������~");
		} finally {
			// ������ 100% ����
			// ���ܰ� �߻��� ���α׷��� �׾ ������ �߻�
			// ���� ���� �۾��� �ܺ��ڿ��� ������ �� �����
			
			System.out.println("����~");
		}

		System.out.println("����~");
		// ������ ���� ����� ó���� ���� ���ܸ� ������ 
		// ���α׷��� ������ ���� ����
	}
}
