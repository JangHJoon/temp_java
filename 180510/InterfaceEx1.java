/*
					�Ϲ�Ŭ����		�߻�Ŭ����		�������̽�
	
	1. �������			o				o				x
	2. �޼���			o				o				x
	3. ������			o				o				x
	4. �߻�޼���		x				o				o
	5. ��ü����			o				x				x
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
// ����(implements : is-a)
// ���������� �����ϴ�.
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
