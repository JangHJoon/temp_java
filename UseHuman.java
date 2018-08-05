class Human {
	private String name;
	private int age;

	public Human(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	// �̸��� ���̰� ������ ��������̴�.
	// h1.equals(h2)
	@Override
	public boolean equals(Object o) {
		if(o == null || !(o instanceof Human)) {
			return false;
		}
		// �񱳸� ���� name�� age������ �ʿ��ϴ�.
		// ������ �Ķ���ͷ� ���޵ɶ� Human�� �ƴ� Object ���·�
		// ���޵Ǿ���.
		// ����, �ʿ��� ����(name, age)�� �̾� ��������
		// ����ȯ(Object -> Human)�� �ʿ��ϴ�.
		Human temp = (Human)o;
		

		return name.equals( temp.getName() )
			&&
		age == temp.getAge();
	}
}
class UseHuman {
	public static void main(String[] args) {
		Human h1 = new Human("A", 20);
		Human h2 = new Human("B", 24);
		Human h3 = new Human("C", 20);
		Human h4 = new Human("A", 30);
		Human h5 = new Human("A", 20);
		Human h6 = null;

		System.out.println(h1.equals(h6));

		boolean result = h1.equals(h2);
		System.out.println(result);
		result = h1.equals(h3);
		System.out.println(result);
		result = h1.equals(h4);
		System.out.println(result);
		result = h1.equals(h5);
		System.out.println(result);

		
	}
}
