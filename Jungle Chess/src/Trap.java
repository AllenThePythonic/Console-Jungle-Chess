//Trap is a subclass of Cell
class Trap extends Cell {

	/*-----methods-----*/
	// Trap is a constructor which accepts 2 parameters, player and Position
	public Trap(int player, Position p) {
		super(player, p);
		this.player = player;
		this.p = p;
	}

	// toString is a method which returns "#"
	public String toString() {
		return "# ";
	}
}
