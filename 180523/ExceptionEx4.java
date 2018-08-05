class ExceptionEx4 {
	public static void main(String[] args) {
		int[] arr = null;
		// 수행의 보장여부
		try {
			// 보장 되지 않음.
			int length = arr.length;
			System.out.println(length);
		} catch(ArithmeticException e) {
			// 보장 되지 않음.
			System.out.println("다시 보세요~");
		} finally {
			// 수행이 100% 보장
			// 예외가 발생해 프로그램이 죽어도 무조건 발생
			// 보통 파일 작업때 외부자원을 해제할 때 사용함
			
			System.out.println("끄읕~");
		}

		System.out.println("끝읏~");
		// 밖으로 따로 만들면 처리를 못한 예외를 만나서 
		// 프로그램이 죽으면 실행 못함
	}
}
