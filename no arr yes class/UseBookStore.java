class Book {
	private String title;
	private String writer;
	private int price;

	public Book(String title, String writer, int price) {
		setTitle(title);
		setWriter(writer);
		setPrice(price);
	}

	public String getTitle() {
		return title;
	}
	public String getWriter() {
		return writer;
	}
	public int getPrice() {
		return price;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return title + "(" + writer + ", " + price + ")";
	}
}
class BookCase {
	private String category;
	private Book[] books;

	public BookCase(String category, Book... books) {
		setCategory(category);
		setBooks(books);
	}
	public String getCategory() {
		return category;
	}
	public Book[] getBooks() {
		return books;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public void setBooks(Book... books) {
		if(books.length <= 100) {
			this.books = books;
		}
	}
	@Override
	public String toString() {
		String info = "-> " + category + "\n";
		for(Book temp : books) {
			info += temp.toString() + "\n";
		}
		return info;
	}
}
class BookStore {
	private String name;
	private String tel;
	private BookCase[] cases;

	public BookStore(String name, String tel, BookCase... cases) {
		setName(name);
		setTel(tel);
		setCases(cases);
	}
	public String getName() {
		return name;
	}
	public String getTel() {
		return tel;
	}
	public BookCase[] getCases() {
		return cases;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public void setCases(BookCase... cases) {
		if(cases.length <= 8) {
			this.cases = cases;
		}
	}
	@Override
	public String toString() {
		String info = "<< " + name + " information >>\n";
		info += "1. tel : " + tel + "\n";
		info += "2. books\n";
		for(BookCase temp : cases) {
			info += temp.toString() + "\n";
		}
		return info;
	}
}
class UseBookStore {
	public static void main(String[] args) {
		Book b1 = new Book("�Ŀ��ڹ�", "õ�α�", 29000);	
		Book b2 = new Book("��Ʈ���ڹ�", "���α�", 31000);	
		Book b3 = new Book("�����ڹ�", "õ�ȱ�", 25000);	

		BookCase case1 = new BookCase("IT", b1, b2, b3);

		BookCase case2 = new BookCase(
			"novel",
			new Book("�Ź�", "��������", 1000),
			new Book("���� �� �ǻ��� ġ����?", "��α�", 2000),
			new Book("�л����� ħ��", "����", 8000)
		);

		BookStore store = new BookStore(
			"�׸�����", "051-912-1000", case1, case2
		);

		System.out.println(store);
	}
}
