interface IEatable {
}
abstract class Fruit {
}
class Apple extends Fruit implements IEatable{
}
class Banana extends Fruit implements IEatable, ILikeIt{
}
class Meat  implements IEatable, ILikeIt{
}
interface ILikeIt {
	// Mark Interface
}
class Boy {
	public void eat(IEatable food) {
		// �Դ´�
		// ������ �Դ°�?
		// ���� Ŭ���� ���� �˻�����
		if(food instanceof Fruit) {
			System.out.println("?????");
		} else if(food instanceof Apple) {
			System.out.println("����� �Ծ��~");
		} else if(food instanceof Banana) {
			System.out.println("�ٳ����� �Ծ��~");
		} else if(food instanceof Meat) {
			System.out.println("��⸦ �Ծ��~");
		}
	}
}














class Girl {
	public void eat(ILikeIt some) {
	}
}
class UseBoy2 {
	public static void main(String[] args) {
		Boy b = new Boy();
		IEatable f1 = new Apple();
		IEatable f2 = new Banana();
		b.eat(f1);
		b.eat(f2);
		b.eat(new Meat());
	}
}
