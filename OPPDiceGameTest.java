import java.util.Scanner;

class DiceGame{
	
	private int diceFace;
	private int userGuess;

	private int rollDice(){
		return (int)(Math.random()*6)+1;
	}
	private int getUserInput(String prompt){
		System.out.println(prompt);
		Scanner s = new Scanner(System.in);
		return s.nextInt();
	}
	private boolean checkUserGuess(){

		boolean check = (diceFace == userGuess);

		if(check){
			System.out.println("�¾ҽ��ϴ�.");
		} else {
			System.out.println("Ʋ�Ƚ��ϴ�.");
		}
		return check;
	}
	public void startPlaying(){

		userGuess = getUserInput("������ �Է��Ͻÿ�: ");
		diceFace = rollDice();		
		while(!checkUserGuess()){
			userGuess = getUserInput("������ �Է��Ͻÿ�: ");
		}
	}

}

public class OPPDiceGameTest{
	public static void main(String[] args){
		DiceGame game = new DiceGame();
		game.startPlaying();

	}
}
