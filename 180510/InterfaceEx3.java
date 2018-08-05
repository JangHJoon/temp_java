interface IAa {
	void methodA();
}
interface IBb {
	void methodB();
}
interface ICc extends IAa, IBb { // 인터페이스 끼리는 다중상속 가능
} 
class SomeImple implements ICc, IAa, IBb { //권장사항
	@Override
	public void methodA() {
	}
	@Override
	public void methodB() {
	}
}
class InterfaceEx3 {
	public static void main(String[] args) {

	}
}
