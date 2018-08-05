class LolitaComplexException extends RuntimeException { // ����ó�� ���� Exception , ����ó�� ���� RuntimeException 
	public LolitaComplexException() {
		super("����� �� �� �־��.");
	}
}
class Human {
	private String name;
	private int age;

	public Human(String name, int age) {
		setName(name);
		setAge(age);
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

	public void love(Human h) throws LolitaComplexException {
		if(h.getAge() > 19) {
			System.out.println(
				name + " �� " + h.getName()	
			);		
		} else {
			// else���� ȣ���ڿ��� ������ �� �ִ�.
			throw new LolitaComplexException();
		}
	}
}
class ExceptionEx4 {
	public static void main(String[] args) {
		Human h1 = new Human("�ҹ�", 17);
		Human h2 = new Human("X����", 43);
		
		try {
			h2.love(h1);
		} catch(LolitaComplexException e) {
			System.out.println(e.getMessage());
		}


		Human h3 = new Human("����", 41);
		try {
			h3.love(h1);
		} catch(LolitaComplexException e) {
			System.out.println("�ູ�ؿ�~");
		}
		// ��Ȳ�� ���� ȣ���ڿ��� ���ñ��� �ο�


		Human h4 = new Human("�̸�", 31);
		// ���̸� �Է¹޴´ٸ� ����� ���� ����Ƿ� 
		// Exception�� ��ӹ޾Ƽ� ����ó���� ������ �ؾ��Ѵ�.

		h3.love(h4);
	}
}
