class ArrEx9 {
	public static void main(String[] args) {
		int[][][] arr2 = new int[3][][];
		// 배열 선언때 배열을 저장하는 
		// 첫번째 배열의 크기만 강제 나머지는 생략 가능함
		// 첫번째 배열의 크기는 다음 배열을 저장할 배열의 주소값이 들어감
		// 배열은 다른주소에서 따로 저장됨
		int[][] arr = new int[3][2];
		/*
		2번째 배열 크기 선언시와 비워놨을때
		{{0,0,0},{0,0,0}}
		{null,null}

		비워놨을 때 각각의 들어갈 배열의 크기는 달라도 가능하다.
		int[][] arr = new int[3][];
		arr[0] = new int[]{1,2,3};
		arr[1] = new int[]{1,2};

		*/

		arr[0][1] = 100;
		// 2번째 배열 크기를 비워놨을때는 Nullpointerexception 오류가 생성
		System.out.print(arr[1][1]);
		// 2번째 배열 크기를 비워놨을때는 Nullpointerexception 오류가 생성

		arr[0] = new int[] {1,2,3,4,5,6,7};
		// 길이가 4지만 다른 길이의 배열은 넣어도 무방


		
		

	}
}
