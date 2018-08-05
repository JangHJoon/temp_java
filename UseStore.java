import java.util.Arrays;
import java.util.Comparator;

class Item implements Comparable<Item> {
	private String name;
	private int price;
	private String registDate;
	private int review;
	
	public Item(String name, int price, String registDate, int review) {
		setName(name);
		setPrice(price);
		setRegistDate(registDate);
		setReview(review);
	}
	public String getName() {
		return name;
	}
	public int getPrice() {
		return price;
	}
	public String getRegistDate() {
		return registDate;
	}
	public int getReview() {
		return review;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setRegistDate(String registDate) {
		this.registDate = registDate;
	}
	public void setReview(int review) {
		this.review = review;
	}
	@Override
	public String toString() {
		String info = "<< 상품 정보 >>\n";
		info += "이름 : " + name + "\n";
		info += "가격 : " + price + "\n";
		info += "등록일 : " + registDate + "\n";
		info += "상품평 : " + review + "\n";
		
		return info;
	}
	@Override
	public int compareTo(Item other) {
		return price - other.getPrice();
	}
}
interface StoreConstants {
	int PRICE_ASC = 0;		// 낮은가격순
	int PRICE_DESC = 1;		// 높은가격순
	int NAME_ASC = 2;		// 이름(오름차순)
	int REGIST_DATE_DESC = 3;	// 최신등록일순
	int REVIEW_DESC = 4;		// 리뷰많은순

	String[] MSG = {
		"낮은가격순",
		"높은가격순",
		"이름으로 정렬",
		"등록일순",
		"리뷰순"
	};
}
class Store implements Comparator<Item>, StoreConstants{
	private Item[] itemList;
	private int mode = PRICE_ASC;

	public Store(Item... itemList) {
		setItemList(itemList);
	}

	public Item[] getItemList() {
		return itemList;
	}
	public void setItemList(Item... itemList) {
		this.itemList = itemList;
	}
	public int getMode() {
		return mode;
	}
	public void setMode(int mode) {
		this.mode = mode;
	}
	public void sort(int mode) {
		if(mode < 1 || mode > 4) {
			mode = PRICE_ASC;
		}
		setMode(mode);
		Arrays.sort(itemList, this);
		printList();
	}
	@Override
	public int compare(Item item1, Item item2) {
		int result;
		if(mode == PRICE_DESC) {
			result = (item1.getPrice() - item2.getPrice()) * -1;
		} else if(mode == NAME_ASC) {
			result = item1.getName().compareTo(item2.getName());
		} else if(mode == REGIST_DATE_DESC) {
			result = item1.getRegistDate().compareTo(item2.getRegistDate());
		} else if(mode == REVIEW_DESC) {
			result = (item1.getReview() - item2.getReview()) * -1;	
		} else {
			result = item1.compareTo(item2);			
		}
		return result;
	}
	@Override
	public String toString() {
		String info = MSG[mode] + "\n";
		for(Item temp : itemList) {
			info += temp.toString() + "\n";
		}
		return info;
	}
	private void printList() {
		System.out.println(this);
	}
}
class UseStore {
	public static void main(String[] args) {
		Store s = new Store(
			new Item("오버핏 봄 라운드 기본 무지 티셔츠", 6900, "2018.02", 24),
			new Item("드라이 무지 기능성 쿨론 반팔 티셔츠 (남녀공용, 흰색, 진회색, 검정)", 5900, "2018.02", 3561),
			new Item("봄신상 8color 데일리 오버핏 맨투맨", 15800, "2015.08", 23),
			new Item("포켓 라운드 오버핏 반팔티", 7900, "2018.04", 7),
			new Item("튤립소매프릴 프린팅루즈핏반팔티", 9600, "2018.04", 651),
			new Item("대박 루즈핏 티셔츠", 14500, "2018.05", 4135)	
		);

		s.sort(100);
	}
}
