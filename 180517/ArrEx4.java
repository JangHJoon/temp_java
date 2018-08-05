import java.util.Arrays;
class Human implements Comparable<Human>{
	private String name;
	private int age;

	public Human(String name, int age) {
		setName(name);
		setAge(age);
	}

	public String getName() {
		return name;
	}
	public int getAge(){
		return age;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return name + "(" + age + ")";
	}
	// 1. �̸����� ����(��������)
	//		��, �̸��� ������� ���̷� ��������
	@Override
	public int compareTo(Human other) {

		// Comparable�θ� implements���� �� 
		// ���ڴ� object�� �ް� Human���� ����ȯ�ؾ���
		// Human���� �ٸ� ���� �ü� �ִ�. ����  

		String otherName = other.getName();
		int result = name.compareTo(otherName);
		
		// �̸��� ���� ��� ó�� ���
		if(result == 0) {
			result = (age - other.getAge()) * -1;
		}

		return result;
	}
}
class ArrEx4 {
	public static void main(String[] args) {
		Human[] list = {
			new Human("ȫ����", 30),
			new Human("���ϸ�", 28),
			new Human("������", 21),
			new Human("����", 28),
			new Human("������", 47),
			new Human("������", 30),
		};
		Arrays.sort(list);
		System.out.println(Arrays.toString(list));

	}
}
