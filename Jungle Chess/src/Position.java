class Position {
	// x is a private integer storing the row number
	private int x;
	// y is a private integer storing the column number
	private int y;

	// Position is a constructor which accepts 2 integer values and intializes
	// all data members
	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	// setX is a method which accepts an integer value and returms no result
	public void setX(int x) {
		if ((x >= 9) || (x < 0)) {
			this.x = 0;
			return;
		} else {
			this.x = x;
			return;
		}
	}

	// setY is a method which accepts an integer value and returms no result
	public void setY(int y) {
		if ((y >= 7) || (y < 0)) {
			this.y = 0;
			return;
		} else {
			this.y = y;
			return;
		}
	}

	// getX is a method which returns the value of x
	public int getX() {
		return x;
	}

	// getX is a method which returns the value of y
	public int getY() {
		return y;
	}
}