interface IA {
	void doSomething();
}
interface IB {
	void doSomething();
}
class Dummy implements IA, IB {
	@Override
	public void doSomething() {
		System.out.println("����~");
	}
}
class InterfaceEx2 {
	public static void main(String[] args) {

	}
}
