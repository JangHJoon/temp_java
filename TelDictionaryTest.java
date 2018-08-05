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
	// 이름 정렬, 중복처리

	public void put(String name, Info info){

		if(existName(name)){ 
			HashSet<Info> i = dic.get(name);
			i.add(info);
		}
		else{
			HashSet<Info> i = new HashSet<Info>();
			i.add(info);
			dic.put(name, i);
		}
	}

	public void addNum(int count){
		num+= num;
	}

	public void search(String name){
		
		Set<String> keys = dic.keySet();
		Iterator<String> itr = keys.iterator();

		ArrayList<String> temps = new ArrayList<String>();
		while(itr.hasNext()){
			String key = itr.next();
			if(key.startsWith(name)){
				temps.add(key);								
			}		
		}		
		///
		System.out.println(name + "의 검색결과(" + temps.size() + "명)");
		///

		for(String temp : temps){
			viewInfo(temp);
		}
	}

	public void display(){
		String title = "전화번호부 (등록인수 : " + dic.size() + " )\n";
		title += "=========================================";
		System.out.println(title);		

		Set<String> keys = dic.keySet();
		Iterator<String> itr = keys.iterator();
		while(itr.hasNext()){
			String key = itr.next();
			viewInfo(key);
		}
	}
	

	private void viewInfo(String name){

		HashSet<Info> is = dic.get(name);

		String str = "";
		for(Info i : is){
			str += name + " : " + i ;
		}

		System.out.println(str);		
	}
	
	private boolean existName(String name){
		return dic.containsKey(name);
	}
	

}


public class TelDictionaryTest{
	public static void main(String[] args) {

		TelDictionary t = new TelDictionary();
		t.put("티모", new Info("920802", "010-6240-XXXX", "teemo@naver.com"));
		t.put("야스오", new Info("900218", "010-7687-XXXX", "yasuo@naver.com"));
		t.put("문도", new Info("910130","010-2736-XXXX","drmundo@naver.com"));
		t.put("이즈리얼", new Info("890103","010-3029-XXXX","ez@naver.com"));
		t.put("아리", new Info("930120","010-2092-XXXX","ari@naver.com"));
		t.put("아리", new Info("930120","010-2092-XXXX","ari@naver.com"));
		t.put("아리", new Info("930100","010-2000-XXXX","ari2@naver.com"));
		t.put("이블린", new Info("880808","010-9490-XXXX","unvisi@naver.com"));
		t.display();

		System.out.println();
		
		t.search("문도박사");
		t.search("이");
		t.search("아리");
	}

}
