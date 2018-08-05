class Clothes {
}
class Pants extends Clothes{
}
class Tshirts extends Clothes{
}
class Hat extends Clothes {
}
class Human {

	public void buy(Clothes c) {
		System.out.println("clothes type");
	}	
	// 바지산다.
	public void buy(Pants p) {
		System.out.println("pansts type");
	}
	// 티 산다.
	public void buy(Tshirts t) {
		System.out.println("tshirts type");
	}
	//우선권 부여


}
class Shopping {
	public static void main(String[] args) {
		Human h = new Human();
		Pants pants = new Pants();
		h.buy(pants);
		Tshirts t = new Tshirts();
		h.buy(t);
		h.buy(new Hat());
	}
}
