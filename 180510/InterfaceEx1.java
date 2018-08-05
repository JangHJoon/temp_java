/*
					일반클래스		추상클래스		인터페이스
	
	1. 멤버변수			o				o				x
	2. 메서드			o				o				x
	3. 생성자			o				o				x
	4. 추상메서드		x				o				o
	5. 객체생성			o				x				x
*/


interface IFoo {
	// public abstract void todo();
	void todo();
}
interface IBar {
	void doit();
}
class Some {
}
// 구현(implements : is-a)
// 복수구현이 가능하다.
class MyObj extends Some implements IFoo, IBar {
	@Override
	public void todo() {
		System.out.println("todo");
	}
	@Override
	public void doit() {
		System.out.println("doit");
	}
}
class InterfaceEx1 {
	public static void main(String[] args) {
		
	}
}
