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
			System.out.println("맞았습니다.");
		} else {
			System.out.println("틀렸습니다.");
		}
		return check;
	}
	public void startPlaying(){

		userGuess = getUserInput("예상값을 입력하시오: ");
		diceFace = rollDice();		
		while(!checkUserGuess()){
			userGuess = getUserInput("예상값을 입력하시오: ");
		}
	}

}

public class OPPDiceGameTest{
	public static void main(String[] args){
		DiceGame game = new DiceGame();
		game.startPlaying();

	}
}
