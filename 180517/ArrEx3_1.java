import java.util.Arrays;

class Ball implements Comparable<Ball>{

	private String num;
	
	public Ball(String num) {
		setNum(num);
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	
	@Override
	public String toString() {
		return "Ball(" + num + ")";
	}


	@Override 
	public int compareTo(Ball b){
		return this.getNum().compareTo(b.getNum());
		// 내부에서 compareTo를 다시 쓸수 있다.!!!
	}
	
}
class ArrEx3_1 {
	public static void main(String[] args) {
		Ball[] arr = {
			new Ball("4"),
			new Ball("1"),
			new Ball("3"),
			new Ball("7"),
			new Ball("6"),
			new Ball("9")
		};

		Arrays.sort(arr);		
		System.out.println(Arrays.toString(arr));

	}
}
