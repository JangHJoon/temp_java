class StringEx {
	public static void main(String[] args) {
		String str1 = "abc";
		String str2 = new String("abc");
		
		// equals -> ���ڿ��� �����
		// �������� ==�� ���ϸ� �ּҰ��� �񱳵�
		// �������� equals�޼ҵ�� ������
		System.out.println(str1.equals(str2));
	}
}
