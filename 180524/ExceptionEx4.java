class LolitaComplexException extends RuntimeException { // 예외처리 강제 Exception , 예외처리 선택 RuntimeException 
	public LolitaComplexException() {
		super("은팔찌를 찰 수 있어요.");
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
				name + " ♡ " + h.getName()	
			);		
		} else {
			// else문을 호출자에서 결정할 수 있다.
			throw new LolitaComplexException();
		}
	}
}
class ExceptionEx4 {
	public static void main(String[] args) {
		Human h1 = new Human("소미", 17);
		Human h2 = new Human("X영욱", 43);
		
		try {
			h2.love(h1);
		} catch(LolitaComplexException e) {
			System.out.println(e.getMessage());
		}


		Human h3 = new Human("윤모씨", 41);
		try {
			h3.love(h1);
		} catch(LolitaComplexException e) {
			System.out.println("행복해요~");
		}
		// 상황에 따라 호출자에게 선택권을 부여


		Human h4 = new Human("이모씨", 31);
		// 나이를 입력받는다면 경우의 수가 생기므로 
		// Exception을 상속받아서 예외처리를 강제로 해야한다.

		h3.love(h4);
	}
}
