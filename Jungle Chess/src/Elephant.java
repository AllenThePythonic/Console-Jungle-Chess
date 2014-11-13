//Elephant is a subclass of Animal
public class Elephant extends Animal {

	/*-----Methods-----*/
	// Elephant is a contructor which accepts 2 parameters, player and Position
	public Elephant(int player, Position p) {
		super(player, p, "7 = Elephant");
		this.player = player;
		this.p = p;
	}

	// execute is a method which checks the validity of the move and performs
	// necessary actions
	public boolean execute(int x, int y, Animal a1[], Animal a2[], Cell[][] cell) {

		// Check the surround position(up, down, left, right)
		if ((getPosition().getX() == x + 1 && getPosition().getY() == y)
				|| (getPosition().getX() == x - 1 && getPosition().getY() == y)
				|| (getPosition().getX() == x && getPosition().getY() == y + 1)
				|| (getPosition().getX() == x && getPosition().getY() == y - 1)) {

			// Check the next step position which there is self chess.
			// Otherwise, output "Invalid move!"
			for (int i = 0; i < a1.length; i++) {
				if (a1[i].getPosition().getX() == x
						&& a1[i].getPosition().getY() == y
						&& a1[i].getDead() == false) {
					return false;
				}
			}

			Animal enemy = null;

			// Check the next step position which there is enemy chess
			for (int i = 0; i < a2.length; i++) {
				if (a2[i].getPosition().getX() == x
						&& a2[i].getPosition().getY() == y
						&& a2[i].getDead() == false) {
					enemy = a2[i];
					break;
				}
			}

			Cell c = cell[x][y];

			// If the next step position is enemy chess, it will...
			if (enemy != null) {

				// If the next step position is enemy mouse, then output
				// "Invalid move!"
				if (enemy instanceof Mouse) {
					return false;
				} else {

					// If the next step position is river, then output
					// "Invalid move!"
					if (c instanceof River) {
						return false;
					} else {

						// If the next step position which is enemy chess and
						// can eat it, then eat it and refresh the new position
						enemy.setDead(true);
						getPosition().setX(x);
						getPosition().setY(y);
						return true;
					}
				}
			} else {

				// If the next step position is river, then output
				// "Invalid move!"
				if (c instanceof River) {
					return false;
				} else {

					// If the next step position is blank cell, then go to next
					// step position and refresh the new position
					getPosition().setX(x);
					getPosition().setY(y);
					return true;
				}
			}
		} else {

			// If the next position is unknown step, , then output
			// "Invalid move!" anyway.
			return false;
		}
	}

	// toString is a method which returns "E" and player number
	public String toString() {
		return "E" + player;
	}
}