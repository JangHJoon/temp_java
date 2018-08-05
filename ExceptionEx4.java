class LolitaComplexException extends Exception {
	public LolitaComplexException() {
		super("ÀºÆÈÂî¸¦ Âû ¼ö ÀÖ¾î¿ä.");
	}
}
class Human {
	private String name;
	private int age;

	public Human(String name, int age) {
		setName(name);
		setAge(age);
	}

	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public void love(Human h) throws LolitaComplexException {
		if(h.getAge() > 19) {
			System.out.println(
				name + " ¢½ " + h.getName()	
			);		
		} else {
			throw new LolitaComplexException();
		}
	}
}
class ExceptionEx4 {
	public static void main(String[] args) {
		Human h1 = new Human("¼Ò¹Ì", 17);
		Human h2 = new Human("X¿µ¿í", 43);
		
		try {
			h2.love(h1);
		} catch(LolitaComplexException e) {
			System.out.println(e.getMessage());
		}

		Human h3 = new Human("±è¸ð¾¾", 41);
		try {
			h3.love(h1);
		} catch(LolitaComplexException e) {
			System.out.println("Çàº¹ÇØ¿ä~");
		}

		Human h4 = new Human("¹Ú¸ð¾¾", 31);
		
		try {
			h3.love(h4);
		} catch(LolitaComplexException e) {}
	}
}
