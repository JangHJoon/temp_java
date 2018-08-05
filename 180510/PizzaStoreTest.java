abstract class JavaPizzaCenter {
	private final void hello(){
		System.out.println("�ȳ��ϼ���~ �ڹ������Դϴ�.");
	}
	private final void goodBye() {
		System.out.println("���ְ� �弼��~");
	}
	// ������ ������ �λ� �����Ұ�

	abstract public void makePizza();
	// �� �븮�� ���� ����� ���� �ٸ��� ����

	public final void process() {
		hello();
		makePizza();
		goodBye();
	}
	// ������ ���μ����� ���� �Ұ�
}
class JavaPizzaBusan extends JavaPizzaCenter {
	@Override
	public void makePizza() {
		System.out.println("���˵���~");
	}
}
class JavaPizzaSeoul extends JavaPizzaCenter {
	@Override
	public void makePizza() {
		System.out.println("��ӳ�~������~");
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
