/* @author Benzon Carlitos Salazar
*	Chess Tuple Class used to store the int to map to tiles on the board
*/

package chess;

public class Tuple {
	private final int x;
	private final int y;

	public Tuple(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int X() { return x; }
	public int Y() { return y; }
}