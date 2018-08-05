interface IA {
	void doSomething();
}
interface IB {
	void doSomething();
}
// 같은 이름을 가진 메소드를 가지지만
// 메소드의 바디가 없기 때문에
// 클래스에서 바디를 구현하기 때문에
// 다중구현을 해도 문제가 없다.
class Dummy implements IA, IB {

}
class InterfaceEx2 {
	public static void main(String[] args) {

	}
}
