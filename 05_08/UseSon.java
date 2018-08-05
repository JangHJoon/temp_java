/*
	오버라이드(Override)
	-> 부모에서 정의한 기능에서 목적(what)은 동일하나
		방법(How)이 달라지는 경우 사용
	- 규칙
		1. 이름, 파라미터정보, 리턴 정보 동일
		2. 접근제한자는 더 좁아질 수 없다.(같은경우는 허용)
			(private < 생략 < protected < public)
	
	Annotation(JDK1.5~)
	-> @xxxx
*/

class Father {
	private int age = 60;
	// 밥먹는다.
	void eat() {
		// 오른손 잡이
		System.out.println("오른손으로 밥먹는다.");
	}

	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
class Son extends Father {
	// 여전히 밥은 먹는다.
	// 왼손잡이다.
	public void eat() {
		super.eat();
		System.out.println("왼손으로 밥먹는다.");
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
