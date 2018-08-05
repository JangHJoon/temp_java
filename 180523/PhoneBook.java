import java.util.*;
class PhoneBook implements HumanManager {

	private Hashtable<String, Vector<Human>> book;

	public PhoneBook() {
		//�����ڿ��� new ����
		book = new Hashtable<String, Vector<Human>>();
	}

	public void add(Human h) {
		
		String name = h.getName();
		Vector<Human> list;

		if(book.containsKey(name)) {
			list = book.get(name);
		} else {
			list = new Vector<Human>();	
			book.put(name, list);
		}

		list.add(h);
	}

	public Human[] search(String name) {
		Vector<Human> list = book.get(name);
		Human[] arr;
		if(list == null) {
			arr = new Human[0];
		} else {
			arr = list.toArray(new Human[0]);
			// Vector<Human> -> Human[]
		}

		return arr;
	}

	public boolean delete(String name) {
		// �ߺ�ó��, ������ �ߴ��� Ȯ��

		Vector<Human> list = book.get(name);
		if(list == null || list.size() == 0) {
			return false;

		} else {

			for(int idx=0; idx<list.size(); idx++) { 
				// �ߺ��� ����� ������
				System.out.println((idx + 1) + ". " + list.get(idx));
			}

			System.out.print("������ ��ȣ�� �����ϼ��� : ");
			Scanner scan = new Scanner(System.in);
			
			int idx = Integer.parseInt(scan.nextLine()) - 1;
			// ���� �ޱ�

			list.remove(idx);
			return true;
		}
	}

	
	@Override
	public String toString(){

		Collection<Vector<Human>> values = book.values();
		// key�� ���� value���� ����

		String info = "";

		for(Vector<Human> list : values) { 
			for(Human temp : list) {
				info += temp + "\n";
			}
		
		}
		return info;
	}
}
