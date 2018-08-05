import java.util.Arrays;
import java.util.Comparator;

class HumanOrderByAge implements Comparator<Human> {
	/*
		o.compare(h1, h2);
		h1 > h2 : ���
		h1 < h2 : ����
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
			new Human("ȫ����", 30),
			new Human("���ϸ�", 28),
			new Human("������", 21),
			new Human("����", 28),
			new Human("������", 47)			
		};

		// ���� ������ �������� ��������.
		Arrays.sort(list, new HumanOrderByAge());


		System.out.println(Arrays.toString(list));
	}
}
