/*	
	public Class FileInputStream ...{
		public FileInputStream(String name)
					throws FileNotFoundException{
		}
	}
*/


import java.io.*;
class ExceptionEx1 {

	public static void makeException() throws FileNotFoundException {
		
		/*
		 예외처리에 대한 책임을 이 메소드를 호출자에게 넘긴다.
		 호출자는 예외처리를 해야한다.

		 호출자는 예외가 발생한 사실을 알수 있으며
		 호출자에게 문제해결에 대한 방법의 선택권을 준다.
				
		ex)		  
		 FileNotFoundException에 대한 예외가 발생했을때 
		 호출자(객체 사용자)는 상황에 따라 적당한 예외처리를 할 수 있다.
		 -> 무시하거나, 빈 파일을 생성하거나, 다른 파일을 찾거나 

		 => public 하거나 생성자일 때 throws를 고려해봐야한다.
		*/

		FileInputStream fis = new FileInputStream("a.txt");
	}

	public static void main(String[] args) {
		/*
		 throws FileNotFoundException
		 main의 thorows는 가상메신에 예외처리에 대한 책임을 넘긴다.
		 예외처리를 하지 않겠다는 뜻
		*/

		try {
			makeException();
		} catch(FileNotFoundException e) {

		}
	}
}
