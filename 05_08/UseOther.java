class Some {
	public int num = 2;
	public void todo() {
		System.out.println("todo");
	}
}
// Other is-a Some
class Other extends Some {
	public void printName() {
		System.out.println("Other");
	}
}
class UseOther {
	public static void main(String[] args) {
		Other o = new Other();
		System.out.println(o.num);
		o.todo();
		o.printName();
	}
}























