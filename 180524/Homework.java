import java.util.*;
/*
	indexOf, lastIndexOf
	substring
*/
class Homework {
	public static void answer1(String str) {

		str += " ";

		List<Integer> idxs = new ArrayList<Integer>();		
		int i=0;
		while(true){
			i = str.indexOf(" ", i);
			if(i == -1){

				break;
			}
			else {
				idxs.add(i++);				
			}
		}

		String print = "";
		for(int j=0 ; j<idxs.size() ; j++){
							
			print += str.substring(0,idxs.get(j));			
			print += "\n";
		}

		System.out.println(print);

		
		/*
		String[] words = str.split("\\s");

		String print = "";
		for(int i=0 ; i<words.length ; i++){

			for(int j=0 ; j<=i ; j++){				
				print += words[j] + " ";				
			}
			print += "\n";
		}

		System.out.println(print);
		*/
		
		/*
		0
		01
		012
		0123
		01234

			태산이
			태산이 높다하되
			태산이 높다하되 하늘
			태산이 높다하되 하늘 아래
			태산이 높다하되 하늘 아래 뫼이로다.

			
		*/
	}
	public static void answer2(String str) {
		
		String[] words = str.split("\\s");

		String print = "";
		for(int i=words.length-1 ; i>=0 ; i--){

			for(int j=i ; j<words.length ; j++){				
				print += words[j] + " ";				
			}
			print += "\n";
		}
		System.out.println(print);
		
		/*
		4
		34
		234
		1234
		01234
			뫼이로다.
			아래 뫼이로다.
			하늘 아래 뫼이로다.
			높다하되 하늘 아래 뫼이로다.
			태산이 높다하되 하늘 아래 뫼이로다.
		*/
	}
	public static void answer3(String str) {

		String[] words = str.split("\\s");

		for(String word : words){
			System.out.println(word);
		}
		/*
			태산이
			높다하되
			하늘
			아래
			뫼이로다.
		*/
	}
	public static void answer4(String str) {

		String[] words = str.split("\\s");
		for(int i=words.length-1 ; i>=0 ; i--){
			System.out.println(words[i]);
		}

		/*
			뫼이로다
			아래
			하늘
			높다하되
			태산이
		*/
	}


	public static void main(String[] args) {
		String str = "태산이 높다하되 하늘 아래 뫼이로다.";
		answer1(str);
		System.out.println();
		answer2(str);
		System.out.println();
		answer3(str);
		System.out.println();
		answer4(str);

		
	}
}
