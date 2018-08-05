import java.util.*;

class MyKey {
	private int num;

	public MyKey(int num) {
		setNum(num);
	}

	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}

	@Override
	public String toString() {
		// int -> String : String.valueOf(num)
		// String -> int : Integer.parseInt("4");

		return String.valueOf(num);
	}

	@Override
	public boolean equals(Object o) {
		if(o == null || !(o instanceof MyKey)) {
			return false;
		}
		MyKey temp = (MyKey)o;
		return num == temp.getNum();
	}

	@Override
	public int hashCode() {
		return String.valueOf(num).hashCode();
	}
}

class MapEx2 {
	public static void main(String[] args) {
		HashMap<MyKey, String> map = 
			new HashMap<MyKey, String>();
		
		// n % 2
		map.put(new MyKey(1), "abc"); // 1 
		map.put(new MyKey(2), "sad"); // 0
		map.put(new MyKey(3), "rey"); // 1
		map.put(new MyKey(4), "sdf"); // 0
		map.put(new MyKey(5), "xxz"); // 1

		String value = map.get(new MyKey(5)); // 1
		System.out.println(value);
	}
}
























