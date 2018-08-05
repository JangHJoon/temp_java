class StringSwitch {
	public static void main(String[] args) {
		

		String code = "INSERT";
		code = new String("DELETE");
		switch (code) {  //jdk1.7~
			case "INSERT":  
				System.out.println("insert");
				break;  
			case "DELETE":  
				System.out.println("delete");
				break;  
			default:  
				throw new IllegalArgumentException();  
		}

	}
}
