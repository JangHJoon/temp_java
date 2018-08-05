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
	// 1. 이름으로 정렬(오름차순)
	//		단, 이름이 같은경우 나이로 내림차순
	@Override
	public int compareTo(Human other) {

		// Comparable로만 implements했을 때 
		// 인자는 object로 받고 Human으로 형변환해야함
		// Human말고도 다른 형이 올수 있다. 오류  

		String otherName = other.getName();
		int result = name.compareTo(otherName);
		
		// 이름이 같은 경우 처리 방법
		if(result == 0) {
			result = (age - other.getAge()) * -1;
		}

		return result;
	}
}
class ArrEx4 {
	public static void main(String[] args) {
		Human[] list = {
			new Human("홍진영", 30),
			new Human("에일리", 28),
			new Human("김유정", 21),
			new Human("윤아", 28),
			new Human("김혜수", 47),
			new Human("김유정", 30),
		};
		Arrays.sort(list);
		System.out.println(Arrays.toString(list));

	}
}
