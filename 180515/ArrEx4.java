class ArrEx4 {

	public static void printSum(int[] arr) {
		int sum = 0;
		for(int n : arr) {
			sum += n;
		}
		System.out.println(sum);
	}
	
	// variable length arguments ���� ���� �μ�
	// VALAGE
	// jdk1.5
	// 1. �޼��� �� 1���� ��밡��
	// 2. �ٸ� �Ķ���Ϳ� ȥ�밡��
	// 3. ������ �Ķ���ͷθ� ����

	// ���� ��Ÿ �δ�����
	// public Unit[] selectUnits(Unit... units); 
	public static void todo(int... some) {
		//some�� �迭�� ó���ȴ�.
		printSum(some);
	}
	public static void doit(String str, int... nums){
	}

	public static void main(String[] args) { //(Sting... args)�� ����
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
