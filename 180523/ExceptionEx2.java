import java.io.*;
class ExceptionEx2 {
	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("a.txt");
			// 예외처리를 무조건 해야함

		} catch(ArithmeticException e) {
			
		} catch(FileNotFoundException e) { 
			//catch(Exception e) -> e?, 예외를 발생하면 무시하는 경우
		}
		System.out.println("end of main");
	}
}
