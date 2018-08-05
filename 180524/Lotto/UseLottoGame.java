import java.util.*;

class MyNums {
	// 번호 배열
	private Integer[] nums;	
	// 자동
	public MyNums() {
		nums = autoSelect(6);
	}
	public MyNums(Integer... nums) {
		Arrays.sort(nums);
		this.nums = nums;
	}
	// 번호 자동선택(상속메소드)
	protected Integer[] autoSelect(int count) {
		
		Random r = new Random();
		// 랜덤 객체
		HashSet<Integer> set = new HashSet<Integer>();

		while(set.size() < count) {
			set.add(r.nextInt(45) + 1);
			// 랜덤 객체 이용(0~44 + 1)
		}
		Integer[] nums = set.toArray(new Integer[0]);
		Arrays.sort(nums, 0, 6);
		// Arrays의 부분 정렬 
		// 당첨번호와 보너스 번호를 분리하여 정렬시킴
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
		// Arrays.toString(배열);
	}	
}

class LottoNums extends MyNums {
	// MyNums 클래스를 상속받아 
	// 숫자를 7개를 생성해서 마지막에 나온 수를 보너스 숫자로 정한다.
	
	// Bonus 번호 INDEX
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
		return super.toString() + "\n*마지막 번호가 보너스 번호입니다.";
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
		System.out.print("몇개를 살까요? : ");
		int count = scan.nextInt();
		nums = new MyNums[count];
		for(int idx=0; idx<count; idx++) {
			nums[idx] = new MyNums(); //자동생성 후 출력
			System.out.println(idx+1 + "회 번호 : " + nums[idx]);
		}
	}
	private void getGoal() {
		goal = new LottoNums();
		System.out.println("당첨번호를 추첨 합니다.");
		System.out.println("당첨번호 : " + goal);
	}
	private void showResult() {	
		Integer[] excBonus = Arrays.copyOfRange(
			goal.getNums(), 0, LottoNums.BONUS
		);
		// 보너스 번호 빼고 6개의 숫자를 추출
		
		//System.out.println(excBonus);
		//System.out.println(Arrays.asList(excBonus));
		List<Integer> goalList = new Vector<Integer>(
			Arrays.asList(excBonus)
		);
		// 배열을 리스트에 넣는 방법
		
		int no = 1;
		for(MyNums temp : nums) {
			// 로또 번호 루프

			List<Integer> myList = 
				new Vector<Integer>(Arrays.asList(temp.getNums()));
			// 로또 번호(배열)를 리스트에 저장

			myList.retainAll(goalList);
			// 로또 번호와 당첨 번호 비교 뒤 저장

			int count = myList.size();
			int rank = 0;
				switch(count) {
				case 6 : 
					rank = 1;
					break;
				case 5 :				
					// 5개 맞을경우 보너스 번호 비교
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
				result = "꽝";
			} else {
				result = rank + "등";
			}
			System.out.print(no + "회 게임 결과 : " + result);
			System.out.println("\t일치번호 -> " + myList);
			no++;			
		}		
	}
}

class UseLottoGame {
	public static void main(String[] args) {
		new LottoGame();
	}
}
