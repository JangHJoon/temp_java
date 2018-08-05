abstract class JavaPizzaCenter {
	private final void hello(){
		System.out.println("안녕하세요~ 자바피자입니다.");
	}
	private final void goodBye() {
		System.out.println("맛있게 드세요~");
	}
	// 본점의 정해진 인사 수정불가

	abstract public void makePizza();
	// 각 대리점 피자 만드는 법은 다르게 가능

	public final void process() {
		hello();
		makePizza();
		goodBye();
	}
	// 본점의 프로세스도 수정 불가
}
class JavaPizzaBusan extends JavaPizzaCenter {
	@Override
	public void makePizza() {
		System.out.println("마싯데이~");
	}
}
class JavaPizzaSeoul extends JavaPizzaCenter {
	@Override
	public void makePizza() {
		System.out.println("어머나~맛나요~");
	}
}
class PizzaStoreTest {
	public static void main(String[] args) {
		JavaPizzaBusan p1 = new JavaPizzaBusan();
		p1.process();

		JavaPizzaSeoul p2 = new JavaPizzaSeoul();
		p2.process();
	}
}
