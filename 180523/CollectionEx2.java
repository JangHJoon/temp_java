import java.util.*;
class CollectionEx2 {
	public static void main(String[] args) {
		// a,b,c,d,e
		Set<String> list1 = new HashSet<String>();
		list1.add("a");
		list1.add("b");
		list1.add("c");
		list1.add("d");
		list1.add("e");
		// a,b,c,h,i
		Set<String> list2 = new HashSet<String>();
		list2.add("a");
		list2.add("b");
		list2.add("c");
		list2.add("h");
		list2.add("i");

		list1.retainAll(list2);

		System.out.println(list1);
	}
}



















