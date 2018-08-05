class ExceptionEx2 {
	public static void throwException() throws Exception{
		
		Exception e = new Exception();
		throw e;		// 예외발생

	}
	public static void main(String[] args) {
		try {
			throwException();
		} catch(Exception e) {
		}
	}
}
