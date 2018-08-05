class ArrEx4 {

	public static void printSum(int[] arr) {
		int sum = 0;
		for(int n : arr) {
			sum += n;
		}
		System.out.println(sum);
	}
	
	// variable length arguments 가변 길이 인수
	// VALAGE
	// jdk1.5
	// 1. 메서드 당 1개만 사용가능
	// 2. 다른 파라미터와 혼용가능
	// 3. 마지막 파라미터로만 가능

	// 응용 스타 부대지정
	// public Unit[] selectUnits(Unit... units); 
	public static void todo(int... some) {
		//some이 배열로 처리된다.
		printSum(some);
	}
	public static void doit(String str, int... nums){
	}

	public static void main(String[] args) { //(Sting... args)도 가능
		todo();
		todo(1, 2);
		todo(1,2,3,4,5,6,7,8);

		doit("a");
		doit("cbd", 1,2,3,4);
		doit("array", new int[]{1,2,3});


		/*
		int num1 = 10;
		int num2 = 5;
		int num3 = 7;

		int[] nums = {num1, num2, num3};
		printSum(nums);
		*/
	}
}
