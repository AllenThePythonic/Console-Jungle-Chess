//Den is a subclass of Cell
class Den extends Cell {

	/*-----methods-----*/
	// Den is a constructor which accepts 2 parameters, player and Position
	public Den(int player, Position p) {
		super(player, p);
		this.player = player;
		this.p = p;
	}

	// toString is a method which returns "V"
	public String toString() {
		return "V ";
	}
}
