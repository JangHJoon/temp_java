class StringVSStringBuffer {
	public static void doString() {
		String str = "";
		long time = System.currentTimeMillis();
		for(int i=0; i<1000000; i++) {
			str += "a";
		}
		time = System.currentTimeMillis() - time;

		System.out.println(time);
	}
	public static void doStringBuffer() {
		StringBuffer buf = new StringBuffer();
		long time = System.currentTimeMillis();
		for(int i=0; i<10000000; i++) {
			buf.append("a");
		}
		time = System.currentTimeMillis() - time;
		System.out.println(time);
	}
	public static void main(String[] args) {
		//doString();
		doStringBuffer();
	}
}
