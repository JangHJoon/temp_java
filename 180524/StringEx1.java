class StringEx1 {
	public static void main(String[] args) {
		String str1 = "abc";
		String str2 = "abc";
		// String��ü�� constant
		// ���� String �޼ҵ���� String ��ü�� �������� �ʴ´�. 
		// ���ο� String�� �����ؼ� return���� �Ѱ��ش�.

		String str3 = new String("abc");
		
		System.out.println(str1 == str2);
		System.out.println(str1 == str3);
		System.out.println(str2 == str3);

	}
}
