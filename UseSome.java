/*
	Generics : JDK1.5~
*/
interface IDummy<T> {
	T returnInfo();
}

class Some<E> implements IDummy<String> {
	public E e;

	public void change(E e) {
		this.e = e;
	}

	@Override
	public String returnInfo() {
		return "";
	}
}
class UseSome {
	public static void main(String[] args) {
		Some<String> s = new Some<String>();
		s.e = "abc";
		Some<Ball> s2 = new Some<Ball>();
		s2.e = new Ball(100);
	}
}
