public class Human {
	private String name;
	private int age;
	private String mail;
	private String tel;

	// for test 
	// 아무값도 없으면 랜덤으로 넣는다. 
	// MyUtils class 참조
	public Human() {
		setName(MyUtils.getRandomString(3));
		setAge(MyUtils.getRandomNumber(10, 40));
		int length = MyUtils.getRandomNumber(3, 5);
		setMail(MyUtils.getRandomNumber(10, 40) + "@doo.com");
		setTel(MyUtils.getRandomNumber(100, 9999) + "-" + MyUtils.getRandomNumber(100, 9999));

	}
	public Human(String name, int age, String mail, String tel) {
		setName(name);
		setAge(age);
		setMail(mail);
		setTel(tel);
	}

	public String getName() {
		return name;

	}
	public int getAge() {
		return age;
	}

	public String getMail() {
		return mail;

	}
	public String getTel() {
		return tel;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setMail(String mail) {
		this.mail = mail;

	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	@Override
	public String toString() {
		return name + "(" + tel + ", " + mail + ", " + age + ")";
	}
}

