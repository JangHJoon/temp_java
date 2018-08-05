interface ISky{
}
class KingUnit{
}
class Unit extends KingUnit{
}
interface Itest{
}
interface IAttackable extends Itest{
}


class Mutal extends Unit implements ISky, IAttackable{
}

class User{


	public void commend(Unit unit){
		System.out.println("Unit");
	}
	public void commend(KingUnit unit){
		System.out.println("KingUnit");
	}
	


}
class PriorityTest{
	public static void main(String[] args) {
		Mutal m = new Mutal();
		User u = new User();
		u.commend(m);

		/*
		PriorityTest.java:32: error: reference to commend is ambiguous, both method commend(Unit) in
		User and method commend(IAttackable) in User match
                u.commend(m);
                 ^
		1 error
		계속하려면 아무 키나 누르십시오 . . .
		*/

	}
}
