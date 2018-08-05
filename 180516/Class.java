abstract class Subject{
	private int score;

	public Subject(int score){
		setScore(score);
	}
	public void setScore(int score){
		this.score = score;
	}
	public int getScore(){
		return score;
	}
}

class Math extends Subject{

	public Math(int score){
		super(score);
	}

}
class English extends Subject{

	public English(int score){
		super(score);
	}		
}

class Korean extends Subject{

	public Korean(int score){
		super(score);
	}
}

interface ConstSubject{
	int SUBJECT_KOREAN  = 0;
	int SUBJECT_ENGLISH = 1;
	int SUBJECT_MATH    = 2;
}


class Student implements ConstSubject{
	
	private Subject[] subjects = new Subject[3];

	public Student(Subject... subjects){
		setSubjects(subjects);	
	}

	public void setSubjects(Subject... subjects){
		
		//this.subjects = subjects;

		for(Subject subject : subjects){
			
			if(subject instanceof Math){
				this.subjects[SUBJECT_MATH] = subject;				
			}
			if(subject instanceof Korean){				
				this.subjects[SUBJECT_KOREAN] = subject;
			}
			if(subject instanceof English){				
				this.subjects[SUBJECT_ENGLISH] = subject;
			}
		}		
	}
	public Subject getSubject(int CONST_SUBJECT){
		return subjects[CONST_SUBJECT];
	}
	public int getSumScore(){
		int sum = 0;	

		for(Subject subject : subjects){
			sum += subject.getScore();
		}
		return sum;		
	}

	public double getAvgScore(){
		return ((double)getSumScore()) / subjects.length;
	}
}



public class Class implements ConstSubject{

	private Student[] students ;//= new Student[5];

	public Class(Student... students){

		setStudents(students);		
	}

	public void setStudents(Student... students){
		this.students = students;	
		
	}

	public double getAvgScoreClassifiedByStudent(int student_index){

		if(students.length >= student_index)		
			return students[student_index].getAvgScore();
		else
			return 0.0;

	}

	public int getSumScoreClassifiedByStudent(int student_index){
		
		if(students.length >= student_index){			
			
			return students[student_index].getSumScore();
		}
		else{
			return 0;
		}
		
	}

	public double getAvgScoreClassifiedBySubject(int CONST_SUBJECT){
		
		return ((double)getSumScoreClassifiedBySubject(CONST_SUBJECT)) / students.length;
	}

	public int getSumScoreClassifiedBySubject(int CONST_SUBJECT){


		int sum = 0;

		for(Student student : students){

			sum += student.getSubject(CONST_SUBJECT).getScore();
		}

		return sum;
	}

	public static void main(String[] args) {
		
		Student A = new Student( new Korean(70), new English(80), new Math(100));
		Student B = new Student( new Korean(90), new English(80), new Math(80));
		Student C = new Student( new Korean(70), new English(100), new Math(100));
				
		Class c = new Class(A,B,C);

		System.out.println(c.getSumScoreClassifiedByStudent(0));
		System.out.println(c.getSumScoreClassifiedByStudent(1));
		System.out.println(c.getSumScoreClassifiedByStudent(2));
		System.out.println(c.getAvgScoreClassifiedByStudent(0));
		System.out.println(c.getAvgScoreClassifiedByStudent(1));
		System.out.println(c.getAvgScoreClassifiedByStudent(2));
		System.out.println(c.getSumScoreClassifiedBySubject(SUBJECT_MATH));
		System.out.println(c.getSumScoreClassifiedBySubject(SUBJECT_KOREAN));
		System.out.println(c.getSumScoreClassifiedBySubject(SUBJECT_ENGLISH));
		System.out.println(c.getAvgScoreClassifiedBySubject(SUBJECT_MATH));
		System.out.println(c.getAvgScoreClassifiedBySubject(SUBJECT_KOREAN));
		System.out.println(c.getAvgScoreClassifiedBySubject(SUBJECT_ENGLISH));

	}
}
