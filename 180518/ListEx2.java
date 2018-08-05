/*
	List
	1. Vector(safe) ������ 
	2. ArrayList(not safe) ������
*/
import java.util.*;
class ListEx2 {
	public static void main(String[] args) {
		Vector<String> vec = new Vector<String>();

		vec.add("a");	// 0
		vec.add("b");	// 1
		vec.add("c");	// 2
		vec.add("a");	// 3
		vec.add("a");	// 4
		vec.add("d");	// 5
		vec.add("a");	// 6
		vec.add("e");	// 7
		vec.add("a");	// 8

			// ���� ã�� : �������� �ʴ� ��� ���� -> -1
	
		int idx = 0;
		while(true){
			idx= vec.indexOf("a", idx);
			if(idx<0)
				break;
			System.out.println(idx++);

		}
		
		/*		
		idx++;
		// "a"�� idx ���� �˻�
		idx = vec.indexOf("a", idx);
		System.out.println(idx);
		idx++;

		idx = vec.indexOf("a", idx);
		System.out.println(idx);
		idx++;

		idx = vec.indexOf("a", idx);
		System.out.println(idx);
		idx++;

		idx = vec.indexOf("a", idx);
		System.out.println(idx);
		idx++;

		idx = vec.indexOf("a", idx);
		System.out.println(idx);
		idx++;
		*/
	}
}
