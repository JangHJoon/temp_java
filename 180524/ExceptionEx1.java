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
		 ����ó���� ���� å���� �� �޼ҵ带 ȣ���ڿ��� �ѱ��.
		 ȣ���ڴ� ����ó���� �ؾ��Ѵ�.

		 ȣ���ڴ� ���ܰ� �߻��� ����� �˼� ������
		 ȣ���ڿ��� �����ذῡ ���� ����� ���ñ��� �ش�.
				
		ex)		  
		 FileNotFoundException�� ���� ���ܰ� �߻������� 
		 ȣ����(��ü �����)�� ��Ȳ�� ���� ������ ����ó���� �� �� �ִ�.
		 -> �����ϰų�, �� ������ �����ϰų�, �ٸ� ������ ã�ų� 

		 => public �ϰų� �������� �� throws�� ����غ����Ѵ�.
		*/

		FileInputStream fis = new FileInputStream("a.txt");
	}

	public static void main(String[] args) {
		/*
		 throws FileNotFoundException
		 main�� thorows�� ����޽ſ� ����ó���� ���� å���� �ѱ��.
		 ����ó���� ���� �ʰڴٴ� ��
		*/

		try {
			makeException();
		} catch(FileNotFoundException e) {

		}
	}
}
