class ExceptionEx1 {

	public static void divide(int num1, int num2) {
		try{
			//예외가 나올수 있는 구문
			int result = num1 / num2;
			// 못풀어서 죽은게 아니라 
			// 못푼걸 받았을때 뭘할지 몰라서 죽음
			System.out.println(result);
			
		} catch(ArithmeticException e) {
			// ArithmeticException 발생 시 예외객체 e가 발생

			System.out.println("0으로 나눌 수 없어요~ : ");
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {

		divide(8, 0);
		divide(8, 2);
		System.out.println("end of main");

		/*
		Exception in thread "main" java.lang.ArithmeticException: / by zero
		Exception 클래스 : 설명
        
		at ExceptionEx1.divide(ExceptionEx1.java:4)
		오류가 난 메소드 : 몇번째 줄
        
		at ExceptionEx1.main(ExceptionEx1.java:8)
		오류가 난 메소드 : 몇번째 줄

		Call Stack 내용을 위에서 모두 뿌려줌
		예외가 발생했을 때 위에서 부터 확인
		
		프로그램 종료 == Call Stack이 다 비워질때
		*/

	}
}
