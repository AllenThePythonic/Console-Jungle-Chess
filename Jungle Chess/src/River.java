//River is a subclass of Cell
class River extends Cell {
	
	/*-----methods-----*/
	// River is a constructor which accepts 2 parameters, player and Position
	public River(int player, Position p) {
		super(player, p);
		this.player = player;
		this.p = p;
	}

	// toString is a method which returns "R"
	public String toString() {
		return "R ";
	}
}
