import java.util.*;
/*
	Collections Framework�� ������ ���
	�ݵ�� equals�� �������̵� �� ��!!
	-> equals�� �����ϴ� �޼��� : indexOf, remove, contains, Collections.binarySearch
	equals�� �ش��ϴ� �����ڵ� �����!
*/
class Human implements Comparable<Human> {
	private String name;
	private int age;
	
	public Human(String name) {
		setName(name);
	}
	public Human(int age) {
		setAge(age);
	}

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
	@Override
	public String toString() {
		return name + "(" + age + ")";
	}
	@Override
	public boolean equals(Object o) {
		if(o == null || !(o instanceof Human)) {
			return false;
		}
		Human temp = (Human)o;
		return name.equals(temp.getName());
	}
	@Override
	public int compareTo(Human other){
		return age - other.getAge();
	}
}
class ListEx3 {
	public static void main(String[] args) {
		ArrayList<Human> list = new ArrayList<Human>();
		list.add(new Human("A", 20));
		list.add(new Human("B", 22));
		list.add(new Human("C", 25));
		list.add(new Human("D", 21));
		list.add(new Human("E", 27));
		list.add(new Human("F", 30));
		
		list.remove(new Human("C"));
		// equals()�� ���ؼ� �����Ѵ�.
		// ���� �ּҰ��� �ٸ��Ƿ� ������ �ȵ�
		// equals()�� �������̵� �ؼ� �ٽ� �����.
		// �̸��� ���ϹǷ� �̸��� �޴� �����ڸ� �ϳ��� �����.

		Collections.sort(list);
		
		// �����ϰ� ������������ ���ĵǾ������� binarySeach ��� ����
		int index  = Collections.binarySearch(list, new Human(30));

		System.out.println(index);
		System.out.println(Collections.min(list));
		System.out.println(Collections.max(list));
		//Comparable - compareTo()
		
		System.out.println(list);
		Collections.reverse(list);
		System.out.println(list);


		
	}
}
