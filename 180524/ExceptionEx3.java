/*
	1. Exception(RuntimeException) ��ӹ޴´�.
	2. ������ ����(message ����)

	* Ŭ���� �̸����ǿ� �Ű澵��!
		-> �߻������� �� �� �ֵ��� ����� ����.
*/
class CustomException extends Exception {
	public CustomException() {
		super("������ �����Դϴ�.");
	}
	public CustomException(String msg) {
		super(msg);
	}
}
class ExceptionEx3 {
	public static void todo() throws CustomException {
		try {
			while(true) {
				throw new CustomException();
				// break; ��� ���
			}
		} finally {
			System.out.println("���� Ż��~");
		}
	}
	public static void main(String[] args) {
		/*
			���� Ż��~
			������ �����Դϴ�.
		*/


		try {
			todo();
		} catch(CustomException e) {
			System.out.println(e.getMessage());
		}
	}
}
