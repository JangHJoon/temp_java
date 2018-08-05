class Ball {
	private int num;

	public Ball(int num) {
		setNum(num);
	}

	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	// 번호가 같으면 같은 공이다.
	// b1.equals(new Car());	
	// b1.equals(b2)
	@Override
	public boolean equals(Object o) {
		// num에 접근하기 위해 형변환 한다.
		// 사용자 정의 클래스는 eqauls를 오버라이딩하자
		// 참조형이니깐 null인 경우를 고려해야한다.
		if(o == null || !(o instanceof Ball)) {
			return false;
		}
		Ball temp = (Ball)o;

		return num == temp.getNum();
	}
}
class UseBall {
	public static void main(String[] args) {
		Ball b1 = new Ball(4);
		Ball b2 = new Ball(7);
		Ball b3 = new Ball(4);
		Ball b4 = null;
		System.out.println(b1.equals(b2));
		System.out.println(b1.equals(b3));
	}
}
