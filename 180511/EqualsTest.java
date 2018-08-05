class Human{
	private String name;
	private int age;

	public Human(String name, int age){
		this.name = name;
		this.age = age;
	}

	@Override
	public boolean equals(Object o){

		if( o == null || !(o instanceof Human)){
			return false;
		}

		Human h = (Human)o;

		// String�� �⺻ Ŭ�����̰� �������̶� equals �޼ҵ�� ��
		// int�� �⺻ �ڷ����̶� ==�� ����
		return (this.name.equals(h.name) && this.age == h.age);


	}
}
class EqualsTest{
	public static void main(String[] args) {
		Human h1 = new Human("��",20);
		Human h2 = new Human("��",20);
		Human h3 = new Human("��",20);


		System.out.println(h3.equals(h2));
		System.out.println(h3.equals(h1));

	}
}
