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
	// �������.
	public void buy(Pants p) {
		System.out.println("pansts type");
	}
	// Ƽ ���.
	public void buy(Tshirts t) {
		System.out.println("tshirts type");
	}
	//�켱�� �ο�


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
