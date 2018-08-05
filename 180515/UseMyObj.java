
// 인터페이스로 특정한 맴버변수를 저장해야할때 이런식으로 사용함

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
	//추상 클래스를 상속하여 추상 클래스의 생성자를 사용한다.
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
		// 인터페이스로 멤버변수를 구현하고 
		// 하위 클래스로 객체를 생성한다.
		MyObj obj = new MyObj(new RealSome(100));
		System.out.println(obj.useNum());
	}
}
