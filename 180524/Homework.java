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

			�»���
			�»��� �����ϵ�
			�»��� �����ϵ� �ϴ�
			�»��� �����ϵ� �ϴ� �Ʒ�
			�»��� �����ϵ� �ϴ� �Ʒ� ���̷δ�.

			
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
			���̷δ�.
			�Ʒ� ���̷δ�.
			�ϴ� �Ʒ� ���̷δ�.
			�����ϵ� �ϴ� �Ʒ� ���̷δ�.
			�»��� �����ϵ� �ϴ� �Ʒ� ���̷δ�.
		*/
	}
	public static void answer3(String str) {

		String[] words = str.split("\\s");

		for(String word : words){
			System.out.println(word);
		}
		/*
			�»���
			�����ϵ�
			�ϴ�
			�Ʒ�
			���̷δ�.
		*/
	}
	public static void answer4(String str) {

		String[] words = str.split("\\s");
		for(int i=words.length-1 ; i>=0 ; i--){
			System.out.println(words[i]);
		}

		/*
			���̷δ�
			�Ʒ�
			�ϴ�
			�����ϵ�
			�»���
		*/
	}


	public static void main(String[] args) {
		String str = "�»��� �����ϵ� �ϴ� �Ʒ� ���̷δ�.";
		answer1(str);
		System.out.println();
		answer2(str);
		System.out.println();
		answer3(str);
		System.out.println();
		answer4(str);

		
	}
}
