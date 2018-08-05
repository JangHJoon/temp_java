class StringEx1 {
	public static void main(String[] args) {
		String str1 = "abc";
		String str2 = "abc";
		// String객체는 constant
		// 따라서 String 메소드들은 String 자체를 변경하지 않는다. 
		// 새로운 String을 생성해서 return으로 넘겨준다.

		String str3 = new String("abc");
		
		System.out.println(str1 == str2);
		System.out.println(str1 == str3);
		System.out.println(str2 == str3);

	}
}
