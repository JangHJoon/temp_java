import java.util.Arrays;
class Ball implements Comparable<Ball>{
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
	@Override
	public String toString() {
		return "Ball(" + num + ")";
	}
	// a.compareTo(b);
	/*
		a < b : 음수
		a > b : 양수
		a == b : 0
	*/
	@Override
	public int compareTo(Ball other) {
		// 비교기준 : num, 내림차순
		return num - other.getNum();
		/*
		int otherNum = other.getNum();
		if(num > otherNum) {
			return 1;
		} else if(num < otherNum) {
			return -1;
		} else {
			return 0;
		}
		*/
	}
}
class ArrEx3 {


	public static void main(String[] args) {
		Ball[] arr = {
			new Ball(4),
			new Ball(1),
			new Ball(3),
			new Ball(7),
			new Ball(6),
			new Ball(9)
		};

		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));

		int idx = Arrays.binarySearch(arr, new Ball(3));
		System.out.println(idx);
	}
}




























