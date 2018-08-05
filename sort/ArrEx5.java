import java.util.Arrays;
import java.util.Comparator;

class HumanOrderByAge implements Comparator<Human> {
	/*
		o.compare(h1, h2);
		h1 > h2 : 양수
		h1 < h2 : 음수
		h1 == h2 : 0
	*/
	@Override
	public int compare(Human h1, Human h2) {
		return h1.getAge() - h2.getAge();
	}
}

class ArrEx5 {
	public static void main(String[] args) {
		Human[] list = {
			new Human("홍진영", 30),
			new Human("에일리", 28),
			new Human("김유정", 21),
			new Human("윤아", 28),
			new Human("김혜수", 47)			
		};

		// 나이 순으로 오름차순 정렬하자.
		Arrays.sort(list, new HumanOrderByAge());


		System.out.println(Arrays.toString(list));
	}
}
