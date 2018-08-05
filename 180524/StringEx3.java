import java.util.*;
class StringEx3 {
	public static void main(String[] args) {
		// a -> 97
		//			  012345678
		String str = "abcdefgab";
		// A -> 65
		String str2 = "ABCDEFG";
		
		// String -> char[]  
		char[] arr = str.toCharArray();
		System.out.println(Arrays.toString(arr));

		// char[] -> String
		String temp = String.valueOf(arr);
		System.out.println(temp);

		System.out.println(str.substring(3));
		System.out.println(str.substring(3, 8));

		System.out.println(str.replace("ab", "xxx"));
		
		System.out.println(str.indexOf("ab", 1));
		System.out.println(str.lastIndexOf("ab", 6));

		System.out.println(str.startsWith("abc"));
		System.out.println(str.endsWith("fg"));

		System.out.println(str.contains("cd"));

		System.out.println(str + str2);
		System.out.println(str.concat(str2));
		// str은 변하지 않는다.
		System.out.println(str);

		System.out.println(str.equals(str2));
		System.out.println(str.equalsIgnoreCase(str2));

		System.out.println(str.compareTo(str2));
		System.out.println(str.compareToIgnoreCase(str2));

		String upperCase = str.toUpperCase();
		System.out.println(upperCase);
		
		String lowerCase = upperCase.toLowerCase();
		System.out.println(lowerCase);

		
	}
}
