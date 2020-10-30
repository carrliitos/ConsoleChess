/* @author Benzon Carlitos Salazar
*	Bishop Class
*/

package chess.pieces;

import chess.ChessPiece;
import chess.Move;

public class Bishop extends ChessPiece {
	public Bishop(PieceColor color) {
		super(PieceType.Bishop, color, validMoves(), true);
	}

	private static Move[] validMoves() {
		return new Move[] {
			new Move(1, 1, false, false),
			new Move(1, -1, false, false),
			new Move(-1, 1, false, false),
			new Move(-1, -1, false, false)
		};
	}
}