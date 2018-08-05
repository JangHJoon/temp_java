/*
	StringBuffer, StringBuilder
*/
class StringBufferEx1 {

	public static void main(String[] args) {
		// "abc"
		StringBuffer buf = new StringBuffer("abc");
		
		// StringBuffer -> String
		String str = buf.toString();

		// 문자열 추가
		buf.append("def");

		System.out.println(buf);
		// 012345
		// abcdef
		buf.delete(1, 4);

		System.out.println(buf);
		// 012
		// aef

		buf.insert(1, "banana");
		buf.insert(1, 6);
		buf.insert(1, new char[]{'v', 't'});
		System.out.println(buf);
	}
}
