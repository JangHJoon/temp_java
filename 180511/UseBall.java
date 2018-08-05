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
	// ��ȣ�� ������ ���� ���̴�.
	// b1.equals(new Car());	
	// b1.equals(b2)
	@Override
	public boolean equals(Object o) {
		// num�� �����ϱ� ���� ����ȯ �Ѵ�.
		// ����� ���� Ŭ������ eqauls�� �������̵�����
		// �������̴ϱ� null�� ��츦 ����ؾ��Ѵ�.
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
