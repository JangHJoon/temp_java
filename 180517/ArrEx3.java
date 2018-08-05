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
		
		// �񱳱��� : num, ��������, ��������(-1)
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
		// sort �޼ҵ� �ȿ��� comparable�� cast �� ���� -> is-a ���迩�߸� ��
		// comparable<T> �� interface�� java.lang ��Ű���� ���� �� -> implements �ؾ��Ѵ�.

		// int compareTo(T o)
		// this object  >  specified object => ���
		// this object  <  specified object => ����
		// this object  == specified object =>  0
		

		
		System.out.println(Arrays.toString(arr));
		// this�� ���� -> toString() �޼ҵ带 override  
	}
}
