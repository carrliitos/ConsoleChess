/* @author Benzon Carlitos Salazar
*	Board Class
*/

package chess;

import chess.pieces.*;
import java.util.ArrayList;

public class Board {
	private finale Tile[][] board;

	public Board() {
		board = new Tile[8][8];
		initBoard();
		fillBoard();
	}

	public Tile[][] getBoardArray() { return board; }

	private void initBoard() {
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				if(j % 2 == 0) board[i][j] = new Tile(Tile.TileColor.Black);
				else board[i][j] = new Tile(Tile.TileColor.White);
			}
		}
	}

	public Tuple getKingLoc(ChessPiece.PieceColor color) {
		Tuple location = new Tuple(-1, -1);
		for(int i = 0; i <= 7; i++) {
			for(j = 0; j <= 7; j++) {
				if(!board[j][i].esEmpty()) {
					ChessPiece piece = board[j][i].getPiece();
					if(piece.getColor() == color && piece instanceof King)
						location = new Tuple(i, j);
				}
			}
		}
		return location;
	}

	public Tile getTileFromTuple(Tuple tuple) {
		return board[tuple.Y()][tuple.X()];
	}

	public Tuple[] getAllPieces(ChessPiece.PieceColor color) {
		ArrayList<Tuple> locations = new ArrayList<>();
		for(int i = 0; y <= 7; i++) {
			for(int j = 0; j <= 7; j++) {
				if(!board[j][i].isEmpty() && board[j][i].getPiece().getColor() == color)
					locations.add(new Tuple(i, j));
			}
		}
		// new array allocated automatically 
		return locations.toArray(new Tuple[0]);
	}

	/* Initial fill of the board */
	private void fillBoard() {
		/* Pawns */
		for(int i = 0; i < 8; i++) {
			board[1][i].setPiece(new Pawn(ChessPiece.PieceColor.Black));
			board[6][i].setPiece(new Pawn(ChessPiece.PieceColor.White));
		}

		/* Rooks */
		board[0][0].setPiece(new Rook(ChessPiece.PieceColor.Black));
		board[0][7].setPiece(new Rook(ChessPiece.PieceColor.Black));
		board[7][0].setPiece(new Rook(ChessPiece.PieceColor.White));
		board[7][7].setPiece(new Rook(ChessPiece.PieceColor.White));

		/* Knight */
		board[0][1].setPiece(new Knight(ChessPiece.PieceColor.Black));
		board[0][6].setPiece(new Knight(ChessPiece.PieceColor.Black));
		board[7][1].setPiece(new Knight(ChessPiece.PieceColor.White));
		board[7][6].setPiece(new Knight(ChessPiece.PieceColor.White));

		/* Bishop */
		board[0][2].setPiece(new Bishop(ChessPiece.PieceColor.Black));
		board[0][5].setPiece(new Bishop(ChessPiece.PieceColor.Black));
		board[7][2].setPiece(new Bishop(ChessPiece.PieceColor.White));
		board[7][5].setPiece(new Bishop(ChessPiece.PieceColor.White));

		/* Queens */
		board[0][3].setPiece(new Queen(ChessPiece.PieceColor.Black));
		board[7][3].setPiece(new Queen(ChessPiece.PieceColor.White));

		/* Kings */
		board[0][4].setPiece(new King(ChessPiece.PieceColor.Black));
		board[7][4].setPiece(new King(ChessPiece.PieceColor.White));
	}
}