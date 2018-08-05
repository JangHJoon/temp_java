/* 책이 8개의 서가에 저장되어 있는 서점을 가정하자. 
 * 각 서가는 최대 100권의 책을 가지고 있다. 
 * 이 서점의 책들을 저장할 수 있는 2차원 배열을 생성하라
 *
 *
 * 객체지향으로 설계하면 다차원 배열은 나오기 힘들다.
 * 객체를 이미지를 하고 특성과 메소드로 고려한다.
 * 행과 열을 따로 객체로 생성되서 2차원 배열은 has-a 관계로 표현된다. 
 * 배열.length가 실제값이 들어있는 길이는 나타내는가? 정해진 배열의 길이를 나타내는가?
 * 정해진 배열의 길이를 나타낸다!
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
		
	인자로 들어오는 books의 배열의 크기가 200이고 
	배열 안에 들어있는 실제 값이 100개 이하 일때 
	걸러지게 된다.

	따로 else를 써서
	null검사로 넣어지게 만들자.

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
		String str = name + "의 서가, 책 목록 ";
		str += "\n==================================";
		
		for(BookStack stack : stacks){
			str += "\n" + stack.toString();
		}
		return str;
	}



	


}
public class CheckUp234{
	public static void main(String[] args) {
		Book b1 = new Book("파워자바","천인국",25000);
		//System.out.println(b1);
		Book b2 = new Book("오리그림책","윤종두",20000);
		//System.out.println(b2);
		
		BookStack BS1 = new BookStack("프로그래밍",b1,b2);
		//System.out.println(BS1);


		BookStore BSt1 = new BookStore("교보문고","119",BS1);
		System.out.println(BSt1);



	}
}
