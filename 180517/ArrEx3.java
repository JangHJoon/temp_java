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
	
	
	@Override
	public boolean equals(Object object){
		Ball b = (Ball) object;		
		return (b==null || b.getNum() != getNum())?false:true;			
	}
	

	@Override 
	public int compareTo(Ball b){
		
		// 비교기준 : num, 오름차순, 내림차순(-1)
		return this.getNum() - b.getNum();



		/*
		if(this.getNum() < b.getNum())
			return -1;
		else if(this.getNum() < b.getNum())
			return 1;
		return 0;
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
		// sort 메소드 안에서 comparable로 cast 중 오류 -> is-a 관계여야만 함
		// comparable<T> 는 interface로 java.lang 패키지에 포함 됨 -> implements 해야한다.

		// int compareTo(T o)
		// this object  >  specified object => 양수
		// this object  <  specified object => 음수
		// this object  == specified object =>  0
		

		
		System.out.println(Arrays.toString(arr));
		// this를 추출 -> toString() 메소드를 override  
	}
}
