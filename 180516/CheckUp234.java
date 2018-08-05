/* å�� 8���� ������ ����Ǿ� �ִ� ������ ��������. 
 * �� ������ �ִ� 100���� å�� ������ �ִ�. 
 * �� ������ å���� ������ �� �ִ� 2���� �迭�� �����϶�
 *
 *
 * ��ü�������� �����ϸ� ������ �迭�� ������ �����.
 * ��ü�� �̹����� �ϰ� Ư���� �޼ҵ�� ����Ѵ�.
 * ��� ���� ���� ��ü�� �����Ǽ� 2���� �迭�� has-a ����� ǥ���ȴ�. 
 * �迭.length�� �������� ����ִ� ���̴� ��Ÿ���°�? ������ �迭�� ���̸� ��Ÿ���°�?
 * ������ �迭�� ���̸� ��Ÿ����!
 */
interface Const{
	int STACK_MAX = 8;
	int BOOK_MAX_PER_STACK = 100;
}

class Book{
	private String title;
	private String writer;
	private int price;

	public Book(String title, String writer, int price){
		this.title = title;
		this.writer = writer;
		this.price = price;
	}

	@Override
	public String toString(){
		return "title : \"" + title + "\", writer : \"" + writer + "\" , price : " + price ;
	}
}

class BookStack{
	private String category;
	private Book[] books = new Book[Const.BOOK_MAX_PER_STACK];
	
	public BookStack(String category, Book... books){

		this.category = category;
		setBooks(books);
	}
	
	/*
	public void setBooks(Book... books) {
		if(books.length <= 100) { 
			this.books = books;
		}
	}
		
	���ڷ� ������ books�� �迭�� ũ�Ⱑ 200�̰� 
	�迭 �ȿ� ����ִ� ���� ���� 100�� ���� �϶� 
	�ɷ����� �ȴ�.

	���� else�� �Ἥ
	null�˻�� �־����� ������.

	*/
	public void setBooks(Book... books){
		if(books.length <= Const.BOOK_MAX_PER_STACK){
			this.books = books;
		}
		else {
			addBooks(books);
		}
	}

	public void addBooks(Book... books){		

		int i;
		int BOOK_MAX = Const.BOOK_MAX_PER_STACK;

		for( i=0 ; i<BOOK_MAX ; i++){			
			if(this.books[i] == null){
				break;
			}
		}
		for(int j=i; j<BOOK_MAX && j-i<books.length; j++){
			
			this.books[j] = books[j-i];			
		}
	}

	@Override
	public String toString(){
		
		String str = "category : " + category + "\n";
		str += "---------------------------------";
		
		for( Book book : books){
			if(book == null) break;			
			str += "\n" + book.toString();
			
			
		}

		return str;
		
	}
}


class BookStore{

	String name;
	String tel;
	BookStack[] stacks = new BookStack[Const.STACK_MAX];
	
	public BookStore(String name, String tel, BookStack... stacks){

		this.name = name;
		this.tel = tel;
		this.stacks = stacks;
	}


	@Override
	public String toString(){
		String str = name + "�� ����, å ��� ";
		str += "\n==================================";
		
		for(BookStack stack : stacks){
			str += "\n" + stack.toString();
		}
		return str;
	}



	


}
public class CheckUp234{
	public static void main(String[] args) {
		Book b1 = new Book("�Ŀ��ڹ�","õ�α�",25000);
		//System.out.println(b1);
		Book b2 = new Book("�����׸�å","������",20000);
		//System.out.println(b2);
		
		BookStack BS1 = new BookStack("���α׷���",b1,b2);
		//System.out.println(BS1);


		BookStore BSt1 = new BookStore("��������","119",BS1);
		System.out.println(BSt1);



	}
}
