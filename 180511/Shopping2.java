class Clothes {
	public void wear() {
		System.out.println(toString() + "��(��) �Ծ��");
	}
}
class Pants extends Clothes{
	@Override
	public String toString() {
		return "����";
	}
}
class Tshirts extends Clothes{
	@Override
	public String toString() {
		return "Ƽ";
	}
}
class Hat extends Clothes {
	@Override
	public String toString() {
		return "����";
	}
}
class Human {
	/*
	// �������.
	public void buy(Pants p) {
	}
	// Ƽ ���.
	public void buy(Tshirts t) {
	}
	*/
	// 1. Clothes c = new Pants();
	// 2. Clothes c = new Tshirts();
	// 3. Clothes c = new Hat();
	public void buy(Clothes c) {
		c.wear();
	}
}
class Shopping2 {
	public static void main(String[] args) {
		Human h = new Human();
		Pants pants = new Pants();
		h.buy(pants);
		Tshirts t = new Tshirts();
		h.buy(t);
		h.buy(new Hat());
	}
}
