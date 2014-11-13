//Cell is a parent for different types of squares or areas of the Jungle board
public abstract class Cell {

	/*-----data members-----*/
	// p is a protected Position storing the position of the cell
	protected Position p;
	// player is a protected integer for storing the player number
	protected int player;

	/*-----methods-----*/
	// Cell is a constructor which accepts 2 parameters, player and Position
	public Cell(int player, Position p) {
		this.player = player;
		this.p = p;
	}

	// setPosition is a method which accepts a Position and return no result
	public void setPosition(Position p) {
		this.p = p;
		return;
	}

	// getPosition is a method which returns a Position
	public Position getPosition() {
		return p;
	}

	// getPlayer is a method which returns the value of player
	public int getPlayer() {
		return player;
	}

	// toString is an abstract method which returns the cell in a stardand
	// output format
	public abstract String toString();
}
