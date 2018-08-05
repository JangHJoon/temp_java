interface IA {
	void doSomething();
}
interface IB {
	void doSomething();
}
class Dummy implements IA, IB {
	@Override
	public void doSomething() {
		System.out.println("¸ô¶ó~");
	}
}
class InterfaceEx2 {
	public static void main(String[] args) {

	}
}
