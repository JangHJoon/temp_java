import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

interface ISortMethod{
	boolean DEC = true;
	boolean ASC = false;
}

class Item{
	private String name;
	private int price;
	private String date;
	private String[] comments;

	public Item(String name, int price, String date, String... comments){
		setName(name);
		setPrice(price);
		setDate(date);
		setComment(comments);
	}
	public void setComment(String[] comments){
		this.comments = comments;
	}
	public String[] getComments(){
		return comments;
	}
	public void setName(String name){
		this.name = name;
	}
	public void setPrice(int price){
		this.price = price;
	}
	public void setDate(String date){
		this.date = date;
	}
	public int getPrice(){
		return price;
	}
	public String getDate(){
		return date;
	}

	@Override 
	public String toString(){
		String str = "��ǰ�� : " + name + ", ���� : " + price + ", ����� : " + date + "\n";
		for(String comment : comments){
			str += comment;
		}
		return str;
	}
}

class SortByPrice implements ISortMethod, Comparator<Item>{
		
	boolean method;

	public SortByPrice(boolean method){
		setMethod(method);
	}

	public void setMethod(boolean method){
		this.method = method;
	}

	@Override
	public int compare(Item i1, Item i2){
		return (i1.getPrice()-i2.getPrice())*(method?-1:1);		
	}
}
class SortByDate implements ISortMethod, Comparator<Item>{
	
	boolean method;

	public SortByDate(boolean method){
		setMethod(method);
	}

	public void setMethod(boolean method){
		this.method = method;
	}
	@Override
	public int compare(Item i1, Item i2){
		return (i1.getDate().compareTo(i2.getDate()))*(method?-1:1);		
	}
}

class SortByCommentNum implements ISortMethod, Comparator<Item>{
	
	boolean method;

	public SortByCommentNum(boolean method){
		setMethod(method);
	}

	public void setMethod(boolean method){
		this.method = method;
	}
	@Override
	public int compare(Item i1, Item i2){
		return (i1.getComments().length -i2.getComments().length)*(method?-1:1);		
	}
}

class Store{
	private String name;
	private Item[] items;

	public Store(String name, Item... items){
		setName(name);
		setItems(items);
	}
	public void setName(String name){
		this.name = name;
	}
	public void setItems(Item... items){
		this.items = items;
	}
	public Item[] getItems(){
		return items;
	}
	@Override
	public String toString(){
		String str = name + "�� ��ǰ���";
		str += "\n===================================";
		for(Item item : items){
			str += "\n" + item.toString();
		}
		return str;
	}


}

abstract class DisplaySort{

	public static void run(Store s){

		String info = "0 : ���� \n1 : ���� ���ݼ� \n2 : ���� ���ݼ� \n3 : �ֽŵ���ϼ� \n4 : ��ǰ������";	
		
		boolean sort_method;
		int select;
		do{			
			System.out.println(s);
			System.out.println(info);
			
			sort_method = ISortMethod.DEC;
		
			Scanner input = new Scanner(System.in);
			select = input.nextInt();			
			switch(select){
				case 1:
					sort_method = ISortMethod.ASC;
				case 2:
					Arrays.sort(s.getItems(),new SortByPrice(sort_method));
					break;
				case 3:					
					Arrays.sort(s.getItems(),new SortByDate(sort_method));
					break;
				case 4:
					Arrays.sort(s.getItems(),new SortByCommentNum(sort_method));
					break;
				default:
					//System.out.println("�߸� �Է��ϼ̽��ϴ�.");
					
			}
		}while(select!=0);
	}
}

public class StoreTest{
	public static void main(String[] args) {
		Item i0 = new Item( "����",20, "2010-01-01", "comment1");
		Item i1 = new Item( "��",500, "1990-01-01","comment1","comment2");
		Item i2 = new Item( "������", 1000,"2000-01-01","comment1","comment2");
		Item i3 = new Item( "���̽� �Ƹ޸�ī��",1500, "2015-01-01","comment1","comment2","comment3");
		Item i4 = new Item( "�����۽�", 2000,"2005-01-01","comment4");
		Item i5 = new Item( "���",4500,"2010-01-05");

		Store s = new Store("������",i5,i3,i4,i0,i1,i2);

		DisplaySort.run(s);
	}
}
