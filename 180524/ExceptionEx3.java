/*
	1. Exception(RuntimeException) 상속받는다.
	2. 생성자 정의(message 정의)

	* 클래스 이름정의에 신경쓸것!
		-> 발생이유를 알 수 있도록 만들어 낸다.
*/
class CustomException extends Exception {
	public CustomException() {
		super("예제용 예외입니다.");
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
				// break; 대신 사용
			}
		} finally {
			System.out.println("루프 탈출~");
		}
	}
	public static void main(String[] args) {
		/*
			루프 탈출~
			예제용 예외입니다.
		*/


		try {
			todo();
		} catch(CustomException e) {
			System.out.println(e.getMessage());
		}
	}
}
