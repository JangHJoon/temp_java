import java.util.*;

class MyNums {
	// ��ȣ �迭
	private Integer[] nums;	
	// �ڵ�
	public MyNums() {
		nums = autoSelect(6);
	}
	public MyNums(Integer... nums) {
		Arrays.sort(nums);
		this.nums = nums;
	}
	// ��ȣ �ڵ�����(��Ӹ޼ҵ�)
	protected Integer[] autoSelect(int count) {
		
		Random r = new Random();
		// ���� ��ü
		HashSet<Integer> set = new HashSet<Integer>();

		while(set.size() < count) {
			set.add(r.nextInt(45) + 1);
			// ���� ��ü �̿�(0~44 + 1)
		}
		Integer[] nums = set.toArray(new Integer[0]);
		Arrays.sort(nums, 0, 6);
		// Arrays�� �κ� ���� 
		// ��÷��ȣ�� ���ʽ� ��ȣ�� �и��Ͽ� ���Ľ�Ŵ
		return nums;
	}
	public Integer[] getNums() {
		return nums;
	}
	public void setNums(Integer... nums) {
		this.nums = nums;
	}
	@Override
	public String toString() {
		return Arrays.toString(nums);
		// Arrays.toString(�迭);
	}	
}

class LottoNums extends MyNums {
	// MyNums Ŭ������ ��ӹ޾� 
	// ���ڸ� 7���� �����ؼ� �������� ���� ���� ���ʽ� ���ڷ� ���Ѵ�.
	
	// Bonus ��ȣ INDEX
	public static final int BONUS = 6;
	
	public LottoNums() {
		setNums(autoSelect(7));
	}
	public LottoNums(Integer... nums) {
		super(nums);
	}	
	public Integer getBonusNum() {		
		return getNums()[BONUS];
	}	
	@Override
	public String toString() {
		return super.toString() + "\n*������ ��ȣ�� ���ʽ� ��ȣ�Դϴ�.";
	}
}

class LottoGame {
	private Scanner scan;	
	private MyNums[] nums;
	private LottoNums goal;

	public LottoGame() {
		scan = new Scanner(System.in);
		howManyPlay();
		getGoal();
		showResult();
	}
	private void howManyPlay() {
		System.out.print("��� ����? : ");
		int count = scan.nextInt();
		nums = new MyNums[count];
		for(int idx=0; idx<count; idx++) {
			nums[idx] = new MyNums(); //�ڵ����� �� ���
			System.out.println(idx+1 + "ȸ ��ȣ : " + nums[idx]);
		}
	}
	private void getGoal() {
		goal = new LottoNums();
		System.out.println("��÷��ȣ�� ��÷ �մϴ�.");
		System.out.println("��÷��ȣ : " + goal);
	}
	private void showResult() {	
		Integer[] excBonus = Arrays.copyOfRange(
			goal.getNums(), 0, LottoNums.BONUS
		);
		// ���ʽ� ��ȣ ���� 6���� ���ڸ� ����
		
		//System.out.println(excBonus);
		//System.out.println(Arrays.asList(excBonus));
		List<Integer> goalList = new Vector<Integer>(
			Arrays.asList(excBonus)
		);
		// �迭�� ����Ʈ�� �ִ� ���
		
		int no = 1;
		for(MyNums temp : nums) {
			// �ζ� ��ȣ ����

			List<Integer> myList = 
				new Vector<Integer>(Arrays.asList(temp.getNums()));
			// �ζ� ��ȣ(�迭)�� ����Ʈ�� ����

			myList.retainAll(goalList);
			// �ζ� ��ȣ�� ��÷ ��ȣ �� �� ����

			int count = myList.size();
			int rank = 0;
				switch(count) {
				case 6 : 
					rank = 1;
					break;
				case 5 :				
					// 5�� ������� ���ʽ� ��ȣ ��
					int indexOfBonus = Arrays.binarySearch(
						temp.getNums(), goal.getBonusNum()
					);
					if(indexOfBonus >= 0) {
						rank = 2;
					} else {
						rank = 3;
					}
					break;
				case 4 :
					rank = 4;
					break;
				case 3 : 
					rank = 5;
					break;
			}
			String result;
			if(rank == 0) {
				result = "��";
			} else {
				result = rank + "��";
			}
			System.out.print(no + "ȸ ���� ��� : " + result);
			System.out.println("\t��ġ��ȣ -> " + myList);
			no++;			
		}		
	}
}

class UseLottoGame {
	public static void main(String[] args) {
		new LottoGame();
	}
}
