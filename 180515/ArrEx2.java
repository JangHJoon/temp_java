class ArrEx2 {

	public static void add(int n, int m) {
		System.out.println(n + m);
	}
		
	public static void add(int[] arr) {
		int sum = 0;
		for(int n : arr) {
			sum += n;
		}
		System.out.println(sum);
	}
	public static void main(String[] args) {
		// main void�� �ü���� �ƴ� ����ӽ������� ����Ǵµ�
		// ���α׷��� ������ ����ӽŵ� ������ ������ return�� ���� ����� ����.
		// ���� Ÿ ���� �޸� �ڹٴ� main�Լ��� void�� ����Ѵ�.
		add(new int[] {1,2,3});
		add(new int[] {1,2,3,4,5,6,7});
	}
}
