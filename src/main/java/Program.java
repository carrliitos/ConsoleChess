/** @author Benzon Carlitos Salazar
*	Main program for playing Chess
*/

import chess.Game;
import chess.Tuple;
import console.Handler;
import console.Display;
import java.util.Scanner;

public class Program {
	public static void main(String[] args) {
		Handler handler = new Handler();
		Scanner scanner = new Scanner(System.in);

		Game game = new Game();
		Display.clearConsole();
		Display.printBoard(game.getBoard());

		while(!game.finished()) {
			System.out.println("Enter move (e.g. A2-A3): ");
			String input = scanner.nextLine();
			if(!handler.isValid(input)) {
				System.out.println("Invalid Input!");
				System.out.println("Valid input is in form: A2-A3");
			}else {
				Tuple from = handler.getFrom(input);
				Tuple to = handler.getTo(input);

				boolean movePlayed = game.playMove(from, to);
				if(!movePlayed) System.out.println("ILLEGAL MOVE!");
				else {
					Display.clearConsole();
					Display.printBoard(game.getBoard());
				}
			}
		}

		scanner.close();
		System.out.println("Game has finished. Goodbye!");
	} 
}