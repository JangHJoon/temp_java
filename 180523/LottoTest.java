import java.util.*;

class Lotto{
	private Set<Integer> nums;

	public Lotto(){		
		nums = new TreeSet<Integer>();
		setNums();
	}

	public void setNums(){
		while(nums.size()<6){
			nums.add((int)(Math.random()*45) + 1);
		}
	}

	@Override
	public String toString(){
		return nums.toString();
	}	

	public Set<Integer> getNums(){
		return nums;
	}

}

class Human{
	public ArrayList<Lotto> lottos;


	public Human(){
		lottos = new ArrayList<Lotto>();
	}

	public void buy(int count){			
		for(int i=0 ; i<count ; i++){
			Lotto lotto = new Lotto();
			lottos.add(lotto);			
		}
	}

	public void printLottos(){
			String str = "";
		for(int i=0; i<lottos.size() ; i++){
			str = (i+1) + "ȸ ��ȣ : " + lottos.get(i) + "\n";
			System.out.print(str);		
		}
	}

	public ArrayList<Lotto> getLottos(){
		return lottos;
	}
}


class Lottery{

	private Set<Integer> winning;
	private Integer bonus;
	
	public Lottery(){
		winning = new TreeSet<Integer>();
	}

	public void run(){
		System.out.println("��÷��ȣ�� ��÷�մϴ�");
		setWinning();
		setBonus();

		Collection<Integer> temp = winning;
		ArrayList<Integer> temp2 = new ArrayList<Integer>();
		temp2.addAll(winning);
		temp2.add(bonus);

		System.out.println("��÷��ȣ : " + temp2);
		System.out.println("*������ ��ȣ�� ���ʽ� ��ȣ�Դϴ�.");
	}

	public void setWinning(){
		
		while(winning.size()<6){
			winning.add((int)(Math.random()*45) + 1);
		}
	}

	public void setBonus(){
		Integer temp;
		do{
			temp = ((int)(Math.random()*45) + 1);
			
		}while(winning.contains(temp));
		bonus = temp;
	}
	
	
	public void resultPrint(Human h){


		String str = "";
		List<Lotto> lottos = h.getLottos();
		for(int i=0 ; i<lottos.size() ; i++){
			
			Lotto lotto = lottos.get(i);
			Set<Integer> nums = lotto.getNums();

			nums.retainAll(winning);


			System.out.println((i+1)+"ȸ ���� ��� : " + "result" + " ��ġ��ȣ -> " + nums);
		}


	}
	


}

public class LottoTest {
	public static void main(String[] args) {

		Human h = new Human();
		h.buy(100);
		h.printLottos();

		Lottery l = new Lottery();

		l.run();
		l.resultPrint(h);
		

	



	}
}
