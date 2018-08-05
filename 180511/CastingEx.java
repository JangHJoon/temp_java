class Foo {
	public void methodA() {
	}
}
class Bar extends Foo{
	public void methodB() {
	}
}
class CastingEx {
	public static void main(String[] args) {
		// Foo > Bar
		Bar b = new Bar();
		b.methodB();
		b.methodA();
		Foo f = b;
		f.methodA();
		// f.methodB();
		Bar b2 = (Bar)f;		// Foo -> Bar
		b2.methodA();
		b2.methodB();

		Foo f2 = new Foo();
		Bar b3 = (Bar)f2;		// Foo -> Bar 
		// instanceof 연산자로 상위 클래스가 하위 클래스로 캐스트가 되는지 미리 확인
		// 참조 변수 instanceof type
	}
}
