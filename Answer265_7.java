/*
		Student
	==============================================
		- name : String
		- no : String
		- major : String
		- grade : int
		- credit : int
	==============================================
		+ Student(name, no, major, grade, credit)
		+ getter / setter
		+ toString() : String

		UnderGraduate
	==============================================
		- club : String
	==============================================
		+ UnderGraduate(name, no, major, grade, credit, club)
		+ getter / setter
		+ toString() : String

		Graduate
	==============================================
		- assType : int
		- rate : double
	==============================================
		+ Graduate(name, no, major, grade, credit, assType, rate)
		+ getter / setter
		+ toString() : String
*/
class Student {
	private String name;
	private String no;
	private String major;
	private int grade;
	private int credit;
	
	public Student(String name, 
					String no, 
					String major, 
					int grade, 
					int credit) {
		setName(name);
		setNo(no);
		setMajor(major);
		setGrade(grade);
		setCredit(credit);
	}

	public String getName() {
		return name;
	}
	public String getNo() {
		return no;
	}
	public String getMajor() {
		return major;
	}
	public int getGrade() {
		return grade;
	}
	public int getCredit() {
		return credit;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	@Override
	public String toString() {
		String info = "name : " + name + "\n";
		info += "no : " + no + "\n";
		info += "major : " + major + "\n";
		info += "grade : " + grade + "\n";
		info += "credit : " + credit;

		return info;
	} 
}
class UnderGraduate extends Student {
	private String club;

	public UnderGraduate(String name, 
					String no, 
					String major, 
					int grade, 
					int credit,
					String club) {
		super(name, no, major, grade, credit);
		setClub(club);
	}

	public String getClub() {
		return club;
	}
	public void setClub(String club) {
		this.club = club;
	}
	@Override
	public String toString() {
		String info = super.toString() + "\n";
		info += "club : " + club;
		return info;
	}
}
class Graduate extends Student {

	public static final int EDU_TYPE = 0;
	public static final int RND_TYPE = 1;

	private double rate;
	private int assType;

	public Graduate(String name, 
					String no, 
					String major, 
					int grade, 
					int credit,
					double rate,
					int assType) {
		super(name, no, major, grade, credit);
		setRate(rate);
		setAssType(assType);
	}

	public double getRate() {
		return rate;
	}
	public int getAssType() {
		return assType;
	}
	public void setRate(double rate) {
		if(rate >= 0 && rate <= 1) {
			this.rate = rate;
		}
	}
	public void setAssType(int assType) {
		if(assType != EDU_TYPE) {
			assType = RND_TYPE;
		}
		this.assType = assType;
	}
	@Override
	public String toString() {
		String info = super.toString() + "\n";
		info += "rate : " + rate + "\n";
		String type = 
			(assType == EDU_TYPE) ? "±³À°Á¶±³" : "¿¬±¸Á¶±³";
		info += "assType : " + type;

		return info;
	}
}
class Answer265_7 {
	public static void main(String[] args) {
		System.out.println(
			new Graduate(
				"È«±æµ¿", "97101147", "computer", 
				4, 120, 0.5, Graduate.RND_TYPE
			)	
		);
		/*
		System.out.println(
			new Student("È«±æµ¿", "97101147", "computer", 4, 120)
		);
		System.out.println(
			new UnderGraduate(
				"È«±æµ¿", "97101147", "computer", 4, 120, "none"
			)	
		);
		*/
	}
}
