class Clothes {
	public void wear() {
		System.out.println(toString() + "을(를) 입어요");
	}
}
class Pants extends Clothes{
	@Override
	public String toString() {
		return "바지";
	}
}
class Tshirts extends Clothes{
	@Override
	public String toString() {
		return "티";
	}
}
class Hat extends Clothes {
	@Override
	public String toString() {
		return "모자";
	}
}
class Human {
	/*
	// 바지산다.
	public void buy(Pants p) {
	}
	// 티 산다.
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
