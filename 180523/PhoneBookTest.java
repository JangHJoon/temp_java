class PhoneBookTest {
	public static void main(String[] args) {

		PhoneBook pb = new PhoneBook();
		
		pb.add(new Human());
		pb.add(new Human());
		pb.add(new Human());
		pb.add(new Human("a", 20, "abc@doo.org", "123-4567"));
		pb.add(new Human("a", 21, "abc@doo.org", "143-4567"));
		pb.add(new Human("a", 22, "abc@doo.org", "153-4567"));
		pb.add(new Human("a", 23, "abc@doo.org", "163-4567"));

		pb.delete("a");

		Human[] arr = pb.search("a");
		
		for(Human h : arr) {
			System.out.println(h) ;
		}
	}
}

