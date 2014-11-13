//Animal is a parent for different types of animals
abstract class Animal {

	/*-----data members-----*/
	// p is a protected Position storing the position of the cell
	protected Position p;
	// player is a protected integer for storing the player number
	protected int player;
	// name is the name of the animal
	String name;
	// isDead is a protected boolean value for storing whether the animal is
	// dead
	protected boolean isDead;

	/*-----methods-----*/
	// Animal is a contructor which accepts 3 parameters, player, name and
	// Position
	public Animal(int player, Position p, String name) {
		this.player = player;
		this.p = p;
		this.name = name;
	}

	// setDead is a method which accepts a boolean value and returns no result
	public void setDead(boolean isDead) {
		this.isDead = isDead;
		return;
	}

	// getDead is a method which returns the value of isDead
	public boolean getDead() {
		return isDead;
	}

	// setPosition is a method which accepts a Position and returns no result
	public void setPosition(Position p) {
		this.p = p;
		return;
	}

	// getPosition is a method which returns a Position
	public Position getPosition() {
		return p;
	}

	// getName is a method which returns a name
	public String getName() {
		return name;
	}

	// execute is an abstract method which checks the validity of the move,
	// performs neccessary actions and returns a boolean value
	public abstract boolean execute(int x, int y, Animal a1[], Animal a2[], Cell[][] cell);
}