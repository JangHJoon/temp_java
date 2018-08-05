interface IConstants {
	int NUM = 4;
}
class ClassConstants {
	public static final int OTHER = 4;
}
class InterfaceEx4 {
	
	public static void main(String[] args) {
		System.out.println(IConstants.NUM);
		System.out.println(OTHER);
	}
}
