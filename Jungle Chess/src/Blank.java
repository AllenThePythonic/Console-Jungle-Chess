//Blank is a subclass of Cell
class Blank extends Cell {
	
	/*-----methods-----*/
	//Blank is a constructor which accepts 2 parameters, player and Position
	public Blank(int player, Position p) {
		super(player, p);
		this.player = player;
		this.p = p;
	}

	// toString is a method which returns "O"
	public String toString() {
		return "O ";
	}
}