package lab14;

import java.util.Scanner;

public class Lab14App {

	private static Scanner scnr = new Scanner(System.in);

	public static void main(String[] args) {
		Player player1 = createHumanPlayer();
		Player player2 = selectOpponent();
		
		int count1 = 0;
		int count2 = 0;
		
		do {
			Roshambo hand1 = player1.generateRoshambo();
			Roshambo hand2 = player2.generateRoshambo();

			// TODO compare. to find winner
			System.out.println(player1.getName() + " played " + hand1);
			System.out.println(player2.getName() + " played " + hand2);
			if (hand1.equals(hand2))
				System.out.println("It's a tie!");
			else if (hand1.equals(Roshambo.ROCK)) {
				if (hand2.equals(Roshambo.SCISSORS)) {
					System.out.println("Rock crushes scissors. You win!!");
					count1++;
				}
				else if (hand2.equals(Roshambo.PAPER)) {
					System.out.println("Paper eats rock. You lose!!");
					count2++;
				}
			} else if (hand1.equals(Roshambo.PAPER)) {
				if (hand2.equals(Roshambo.SCISSORS)) {
					System.out.println("Scissor cuts paper. You lose!!");
					count2++;
				}
					else if (hand2.equals(Roshambo.ROCK)) {
					System.out.println("Paper eats rock. You win!!");
					count1++;
					}
			} else if (hand1.equals(Roshambo.SCISSORS)) {
				if (hand2.equals(Roshambo.PAPER)) {
					System.out.println("Scissor cuts paper. You win!!");
					count1++;
				}
					else if (hand2.equals(Roshambo.ROCK)) {
					System.out.println("Rock breaks scissors. You lose!!");
					count2++;
					}
			} else
				System.out.println("Invalid user input.");
		} while (ValidatorHelper.getYesNo(scnr, "Play again? (y/n) : "));
System.out.println("Scores: " + player1.getName() + ": " + count1 + " // " + player2.getName() + " " + count2 );

	}

	private static Player selectOpponent() {
		String input = ValidatorHelper.getString(scnr, "Would you like to face An Actaul Rock or Randy: ");
		if (input.startsWith("A")) {
			return new RockPlayer("An Actual Rock");
		} else {
			return new PaperPlayer("Random Randy");
		}
	}

	private static HumanPlayer createHumanPlayer() {
		String name = ValidatorHelper.getString(scnr, "What is your name? : ");;
		return new HumanPlayer(name, scnr);
	}
}