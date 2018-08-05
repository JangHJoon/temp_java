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
		// main void가 운영체제가 아닌 가상머신위에서 실행되는데
		// 프로그램이 끝나면 가상머신도 끝나기 때문에 return을 받을 대상이 없다.
		// 따라서 타 언어와 달리 자바는 main함수에 void를 사용한다.
		add(new int[] {1,2,3});
		add(new int[] {1,2,3,4,5,6,7});
	}
}
