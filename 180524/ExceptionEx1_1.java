/*
	public class FileInputStream ... {
		public FileInputStream(String path) throws FileNotFoundException {
		}
	}

*/
import java.io.*;
class ExceptionEx1_1 {

	public static void makeException() throws IOException {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("a.txt");
			fis.read();
		} finally {
			try {
				fis.close();// 자원해제
			} catch(IOException e) {}
		}
	}

	public static void main(String[] args) {
		try {
			makeException();
		} catch(IOException e) {
		}
	}
}
























