//package homework0521;

import java.util.*;

class Info{	
	
	private String birth_day;
	private String tel;
	private String email;
	public Info(String birth_day, String tel, String email){		
		setDay(birth_day);
		setTel(tel);
		setEmail(email);
	}
	
	public String getDay(){
		return birth_day;
	}
	public String getTel(){
		return tel;
	}
	public String getEmail(){
		return email;
	}
	public void setDay(String birth_day){
		this.birth_day = birth_day;
	}
	public void setTel(String tel){
		this.tel = tel;
	}
	public void setEmail(String email){
		this.email = email;
	}

	@Override
	public String toString(){
		return "[Birthday : " + birth_day + ", tel : " + tel + ", email : " + email +"]";
	}

	@Override
	public boolean equals(Object o){
		if(o == null || !(o instanceof Info)){
			return false;
		}
		Info i = (Info) o;
		return i.getDay() == birth_day && i.getTel() == tel && i.getEmail() == email;
	}
	
	@Override
	public int hashCode(){		
		return String.valueOf(birth_day).hashCode() + String.valueOf(tel).hashCode()/10 + String.valueOf(email).hashCode()/100 ;
	}
		
}

class TelDictionary{
	
	private int num=0;
	private Map<String, HashSet<Info>> dic = new TreeMap<String, HashSet<Info>>();	
	// �̸� ����(TreeMap), �ߺ� ó��(HashSet)

	public void put(String name, Info info){

		if(existName(name)){ 			
			HashSet<Info> i = dic.get(name);
			int temp = i.size();			
			i.add(info);
			num += (temp != i.size())?1:0;
		}
		else{
			HashSet<Info> i = new HashSet<Info>();
			i.add(info);
			dic.put(name, i);
			num++;
		}
	}
	
	
	public void search(String name){
		
		Set<String> keys = dic.keySet();
		Iterator<String> itr = keys.iterator();
		
		ArrayList<String> temps = new ArrayList<String>();
		
		int count = 0;
		while(itr.hasNext()){
			String key = itr.next();
			if(key.startsWith(name)){
				temps.add(key);
				count += countInfo(key);
				
			}		
		}		
	
		System.out.println("\"" + name + "\"�� �˻����(" + count + "��)");
	
		for(String temp : temps){
			viewInfo(temp);
		}
	}

	public void display(){
		
		String title = "��ȭ��ȣ�� (����μ� : " + num + "�� )\n";
		title += "=========================================";
		System.out.println(title);		

		Set<String> keys = dic.keySet();
		Iterator<String> itr = keys.iterator();
		while(itr.hasNext()){
			String key = itr.next();
			viewInfo(key);
		}
	}
	
	private int countInfo(String name){		
		HashSet<Info> is = dic.get(name);
		return is.size();	
	}
	

	private void viewInfo(String name){

		HashSet<Info> is = dic.get(name);	
		for(Info i : is){
			System.out.println(name + " : " + i);
		}
	}
	
	private boolean existName(String name){
		return dic.containsKey(name);
	}
	

}


public class TelDictionaryTest{
	public static void main(String[] args) {

		TelDictionary t = new TelDictionary();
		t.put("Ƽ��", new Info("920802", "010-6240-XXXX", "teemo@naver.com"));
		t.put("�߽���", new Info("900218", "010-7687-XXXX", "yasuo@naver.com"));
		t.put("����", new Info("910130","010-2736-XXXX","drmundo@naver.com"));
		t.put("�����", new Info("890103","010-3029-XXXX","ez@naver.com"));
		t.put("�Ƹ�", new Info("930120","010-2092-XXXX","ari@naver.com"));
		t.put("�Ƹ�", new Info("930120","010-2092-XXXX","ari@naver.com"));
		t.put("�Ƹ�", new Info("930100","010-2000-XXXX","twinari2@naver.com"));
		t.put("�̺�", new Info("880808","010-9490-XXXX","unvisi@naver.com"));
		t.display();

		System.out.println();
		
		t.search("�����ڻ�");
		t.search("�Ƹ�");
		//t.search("��");
	}

}
