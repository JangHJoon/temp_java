/*
	Collection : ��ü, ��������
	|
	List : �ε���
		
*/
import java.util.*;
class ListEx1 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
	
		list.add("abc");		// 0
		list.add("def");		// 1
		list.add("hij");		// 2
		list.add("zzz");		// 3
		// ���� ����
		list.add(2, "ooo");

		// ���� ����
		list.set(2, "xxx");
		
		// �������̰� �ƴϹǷ� ��� ���Ҹ� ��ȸ�� �� ����.
		for(int idx=0; idx<list.size(); idx++) {
			list.remove(idx);			
		}

		System.out.println("after : " + list);
	
		// ���� ����(�ε���)
		list.remove(2);

		System.out.println(list);
		// ���� ����
		System.out.println(list.get(2));
	}
}
