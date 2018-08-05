interface IAa {
	void methodA();
}
interface IBb {
	void methodB();
}
interface ICc extends IAa, IBb {
	int NUM  = 100;
}
class SomeImple implements ICc, IAa, IBb {
	@Override
	public void methodA() {
		System.out.println(NUM);
	}
	@Override
	public void methodB() {
	}
}
class InterfaceEx3 {
	public static void main(String[] args) {

	}
}
