class StringEx {
	public static void main(String[] args) {
		String str1 = "abc";
		String str2 = new String("abc");
		
		// equals -> 문자열의 내용비교
		// 참조형은 ==로 비교하면 주소값이 비교됨
		// 참조형은 equals메소드로 비교하자
		System.out.println(str1.equals(str2));
	}
}
