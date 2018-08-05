import java.util.*;
public class VaragrgsEx {
	public static void main(String[] args) {

	Map<String, Object> foo = new HashMap<String, Object>();  
	Map<String, Object> bar = new HashMap<String, Object>(); 
	Map<String, Object> bar2 = new HashMap<String, Object>(); 
	List<Map <String,Object>> result = Arrays.asList(foo, bar, bar2); //jdk1.7~ 

	System.out.println(result);

	}
}
