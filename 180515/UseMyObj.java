
// �������̽��� Ư���� �ɹ������� �����ؾ��Ҷ� �̷������� �����

interface ISome {
	int getNum();
}
abstract class SomeImple implements ISome {
	private int num;

	public SomeImple(int num) {
		this.num = num;
	}

	@Override
	public int getNum() {
		return num;
	}
}

class RealSome extends SomeImple { 
	//�߻� Ŭ������ ����Ͽ� �߻� Ŭ������ �����ڸ� ����Ѵ�.
	public RealSome(int num) {
		super(num);
	}
}
class MyObj {
	private ISome some;
	
	public MyObj(ISome some) {
		this.some = some;
	}
	public int useNum() {
		return some.getNum();
	}
}
class UseMyObj {
	public static void main(String[] args) {
		// �������̽��� ��������� �����ϰ� 
		// ���� Ŭ������ ��ü�� �����Ѵ�.
		MyObj obj = new MyObj(new RealSome(100));
		System.out.println(obj.useNum());
	}
}
