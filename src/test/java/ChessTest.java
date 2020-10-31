import console.*;
import chess.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class ChessTest {
	@Test
	public void testNewGameIsNotFinished() {
		Game game = new Game();
		assertTrue("Game shouldn't finish", !game.finished());
	}

	@Test
	public void testFoolsMateEndsGame() {
		String[] foolsMate = new String[]{
			"H2-H4",
			"E7-E6",
			"G1-F3",
			"D8-H4"
		};
		Game game = new Game();
		Handler handler = new Handler();
		for(String move : foolsMate) {
			Tuple from = handler.getFrom(move);
			Tuple to = handler.getTo(move);

			boolean movePlayed = game.playMove(from, to);
			if(!movePlayed) fail("Should be legal move.");
		}
		console.Display.printBoard(game.getBoard());
		assert(game.finished());
	}

	@Test
	public void testFirstMovePawn() {
		Handler handler = new Handler();
		Tuple location = handler.parse("A2");
		Game game = new Game();
		assert(game.isFirstMoveForPawn(location, game.getBoard()));
	}
	
	@Test
	public void testNotFirstMovePawn() {
		Handler handler = new Handler();
		String move = "B2-B3";
		Tuple from = handler.getFrom(move);
		Tuple to = handler.getTo(move);
		Game game = new Game();
		game.playMove(from, to);
		assert(!game.isFirstMoveForPawn(to, game.getBoard()));
	}
}