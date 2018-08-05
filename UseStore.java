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
		String info = "<< ��ǰ ���� >>\n";
		info += "�̸� : " + name + "\n";
		info += "���� : " + price + "\n";
		info += "����� : " + registDate + "\n";
		info += "��ǰ�� : " + review + "\n";
		
		return info;
	}
	@Override
	public int compareTo(Item other) {
		return price - other.getPrice();
	}
}
interface StoreConstants {
	int PRICE_ASC = 0;		// �������ݼ�
	int PRICE_DESC = 1;		// �������ݼ�
	int NAME_ASC = 2;		// �̸�(��������)
	int REGIST_DATE_DESC = 3;	// �ֽŵ���ϼ�
	int REVIEW_DESC = 4;		// ���丹����

	String[] MSG = {
		"�������ݼ�",
		"�������ݼ�",
		"�̸����� ����",
		"����ϼ�",
		"�����"
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
			new Item("������ �� ���� �⺻ ���� Ƽ����", 6900, "2018.02", 24),
			new Item("����� ���� ��ɼ� ��� ���� Ƽ���� (�������, ���, ��ȸ��, ����)", 5900, "2018.02", 3561),
			new Item("���Ż� 8color ���ϸ� ������ ������", 15800, "2015.08", 23),
			new Item("���� ���� ������ ����Ƽ", 7900, "2018.04", 7),
			new Item("ƫ���Ҹ����� �����÷����͹���Ƽ", 9600, "2018.04", 651),
			new Item("��� ������ Ƽ����", 14500, "2018.05", 4135)	
		);

		s.sort(100);
	}
}
