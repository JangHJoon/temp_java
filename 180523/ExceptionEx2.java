import java.io.*;
class ExceptionEx2 {
	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("a.txt");
			// ����ó���� ������ �ؾ���

		} catch(ArithmeticException e) {
			
		} catch(FileNotFoundException e) { 
			//catch(Exception e) -> e?, ���ܸ� �߻��ϸ� �����ϴ� ���
		}
		System.out.println("end of main");
	}
}
