/*
	�������̵�(Override)
	-> �θ𿡼� ������ ��ɿ��� ����(what)�� �����ϳ�
		���(How)�� �޶����� ��� ���
	- ��Ģ
		1. �̸�, �Ķ��������, ���� ���� ����
		2. ���������ڴ� �� ������ �� ����.(�������� ���)
			(private < ���� < protected < public)
	
	Annotation(JDK1.5~)
	-> @xxxx
*/

class Father {
	private int age = 60;
	// ��Դ´�.
	void eat() {
		// ������ ����
		System.out.println("���������� ��Դ´�.");
	}

	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
class Son extends Father {
	// ������ ���� �Դ´�.
	// �޼����̴�.
	public void eat() {
		super.eat();
		System.out.println("�޼����� ��Դ´�.");
	}
}
class UseSon {
	public static void main(String[] args) {
		Son s = new Son();
		s.eat();
		s.setAge(20);
		System.out.println(s.getAge());
	}
}
