class StringEx2 {
	public static void main(String[] args) {
		//			  012345678
		String str = "abcdefghijk      ";
		// �ѱ۵� �׳� 1���ڷ� ó����
		
		int length = str.length();
		System.out.println(length);
		System.out.println(str.trim().length());

		char c = str.charAt(3);
		System.out.println(c);

		for(int idx=0; idx<str.length(); idx++) {
			System.out.println(str.charAt(idx));
		}
	}
}
