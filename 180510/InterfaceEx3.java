interface IAa {
	void methodA();
}
interface IBb {
	void methodB();
}
interface ICc extends IAa, IBb { // �������̽� ������ ���߻�� ����
} 
class SomeImple implements ICc, IAa, IBb { //�������
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
