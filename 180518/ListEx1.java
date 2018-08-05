/*
	Collection : 객체, 가변길이
	|
	List : 인덱스
		
*/
import java.util.*;
class ListEx1 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
	
		list.add("abc");		// 0
		list.add("def");		// 1
		list.add("hij");		// 2
		list.add("zzz");		// 3
		// 원소 삽입
		list.add(2, "ooo");

		// 원소 변경
		list.set(2, "xxx");
		
		// 고정길이가 아니므로 모든 원소를 순회할 수 없다.
		for(int idx=0; idx<list.size(); idx++) {
			list.remove(idx);			
		}

		System.out.println("after : " + list);
	
		// 원소 삭제(인덱스)
		list.remove(2);

		System.out.println(list);
		// 원소 접근
		System.out.println(list.get(2));
	}
}
