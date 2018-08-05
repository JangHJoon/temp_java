interface IEatable {
}
abstract class Fruit { // 추상적인 이미지이므로 abstract 추가
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
		// 먹는다
		// 무엇을 먹는가?
		// 다형성으로 함수 인수 받을때 생성된 객체(new 연산자)를 확인할 때 
		// 연산자 instanceof로 구별한다.
		if(food instanceof Apple) {
			System.out.println("사과를 먹어요~");
		} else if(food instanceof Banana) {
			System.out.println("바나나를 먹어요~");
		} else if(food instanceof Meat) {
			System.out.println("고기를 먹어요~");
		}
	}
}


class Girl {
	public void eat(ILikeIt some) {
	}
}
class UseBoy {
	public static void main(String[] args) {
		Boy b = new Boy();
		IEatable f1 = new Apple();
		IEatable f2 = new Banana();
		b.eat(f1);
		b.eat(f2);
		b.eat(new Meat());
	}
}
