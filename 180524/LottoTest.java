import java.util.*;


class Lotto{
	private Set<Integer> nums;

	public Lotto(){		
		nums = new TreeSet<Integer>();
		setNums();
	}

	private void setNums(){
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

		ArrayList<Integer> temp = new ArrayList<Integer>();
		temp.addAll(winning);
		temp.add(bonus);

		System.out.println("��÷��ȣ : " + temp);
		System.out.println("*������ ��ȣ�� ���ʽ� ��ȣ�Դϴ�.");
	}

	private void setWinning(){
		
		while(winning.size()<6){
			winning.add((int)(Math.random()*45) + 1);
		}
	}

	private void setBonus(){
		Integer temp;
		do{
			temp = ((int)(Math.random()*45) + 1);
			
		}while(winning.contains(temp));
		bonus = temp;
	}	
	
	public void resultPrint(Human h){

		int[] result = new int[6];
		int rank=0;

		List<Lotto> lottos = h.getLottos();
		for(int i=0 ; i<lottos.size() ; i++){
			
			Lotto lotto = lottos.get(i);
			Set<Integer> nums = lotto.getNums();			
			nums.retainAll(winning);			
			
			int count = nums.size();
			
			switch(count){				
				case 0:
				case 1:
			    case 2:
					rank = 0;
					break;
				case 3:
					rank = 5;
					break;
				case 4:
					rank = 4;
				    break;
				case 5:
					Set<Integer> temp = lotto.getNums();					
					if(temp.contains(bonus)){
						rank = 2;
					} else {
						rank = 3;
					}
					break;
				case 6:
					rank = 1;
			}
			result[rank]++;

			System.out.println((i+1)+"ȸ ���� ��� : " + (rank==0?"�� ":rank+"��") + "   ��ġ��ȣ -> " + nums);
		}

		System.out.println("�ζ� ��� : 1��(" + result[1] + ") 2��(" + result[2] + ") 3��(" + result[3] + ") 4��(" + result[4] + ") 5��(" + result[5] + ") ��(" +result[0] + ")");


	}	


}

public class LottoTest {
	public static void main(String[] args) {

		Human h = new Human();

		System.out.print("��� �찡��?");
		Scanner input = new Scanner(System.in);
		int count = Integer.parseInt(input.nextLine());
		
		h.buy(count);
		h.printLottos();

		Lottery l = new Lottery();
		l.run();
		l.resultPrint(h);

	}
}
