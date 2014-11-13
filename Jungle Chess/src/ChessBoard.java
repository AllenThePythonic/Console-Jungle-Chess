import java.util.*;

class ChessBoard {

	/*-----data members-----*/
	// c is a private static 2-dimensional array of Cell storing the board
	// components
	private static Cell c[][] = new Cell[9][7];
	// a1 is a private static 1-demensional array of Animal storing the animals
	// for player 1
	private static Animal a1[] = new Animal[8];
	// a2 is a private static 1-demensional array of Animal storing the animals
	// for player 2
	private static Animal a2[] = new Animal[8];

	/*-----methods-----*/
	// ChessBoard is a default constructor for setting up the chess board
	public ChessBoard() {

		// Blank Cell
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 7; j++) {
				c[i][j] = new Blank(-1, new Position(i, j));
			}
		}

		// Fixed Den Position
		c[0][3] = new Den(1, new Position(0, 3));
		c[8][3] = new Den(2, new Position(8, 3));

		// Fixed River Position
		c[3][1] = new River(-1, new Position(3, 1));
		c[3][2] = new River(-1, new Position(3, 2));
		c[3][4] = new River(-1, new Position(3, 4));
		c[3][5] = new River(-1, new Position(3, 5));
		c[4][1] = new River(-1, new Position(4, 1));
		c[4][2] = new River(-1, new Position(4, 2));
		c[4][4] = new River(-1, new Position(4, 4));
		c[4][5] = new River(-1, new Position(4, 5));
		c[5][1] = new River(-1, new Position(5, 1));
		c[5][2] = new River(-1, new Position(5, 2));
		c[5][4] = new River(-1, new Position(5, 4));
		c[5][5] = new River(-1, new Position(5, 5));

		// Fixed Player1's Trap Position
		c[0][2] = new Trap(-1, new Position(0, 2));
		c[0][4] = new Trap(-1, new Position(0, 4));
		c[1][3] = new Trap(-1, new Position(1, 3));

		// Fixed Player2's Trap Position
		c[8][2] = new Trap(-1, new Position(8, 2));
		c[8][4] = new Trap(-1, new Position(4, 4));
		c[7][3] = new Trap(-1, new Position(7, 3));

		// Player1's Chess Start Position
		a1[0] = new Mouse(1, new Position(2, 0));
		a1[1] = new Cat(1, new Position(1, 5));
		a1[2] = new Wolf(1, new Position(2, 4));
		a1[3] = new Dog(1, new Position(1, 1));
		a1[4] = new Leopard(1, new Position(2, 2));
		a1[5] = new Tiger(1, new Position(0, 6));
		a1[6] = new Lion(1, new Position(0, 0));
		a1[7] = new Elephant(1, new Position(2, 6));

		// Player2's Chess Start Position
		a2[0] = new Mouse(2, new Position(6, 6));
		a2[1] = new Cat(2, new Position(7, 1));
		a2[2] = new Wolf(2, new Position(6, 2));
		a2[3] = new Dog(2, new Position(7, 5));
		a2[4] = new Leopard(2, new Position(6, 4));
		a2[5] = new Tiger(2, new Position(8, 0));
		a2[6] = new Lion(2, new Position(8, 6));
		a2[7] = new Elephant(2, new Position(6, 0));
	}

	// play is a method to start and control the game which returns no result
	public void play() {

		// Loop Players' Input
		while (true) {

			Scanner input = new Scanner(System.in);

			// Player 1--------------------------------------------------------
			String p1AnimalDisplay = "";

			// do {

			// Print the Chess Board with all items for player 1
			System.out.print(this);

			// Print the choices that give Player 1 to choose the chess
			System.out.println("Player 1: Please select an animal to move :");
			for (int animal = 0; animal < a1.length; animal++) {
				p1AnimalDisplay += (a1[animal].getName() + ", ");
			}
			System.out.println(p1AnimalDisplay.substring(0, p1AnimalDisplay
					.length() - 2));
			int p1 = input.nextInt();

			// Warning Message for Player 1(Input number must be not dead
			// animal(s))
			while (p1 < 0 || p1 > 7 || a1[p1].getDead()) { // <--Cuation!!!!!
				System.out
						.println("Invalid Input. Please select an animal again!");
				p1 = input.nextInt();
			}

			// Player 1 that input row which the chess need
			System.out.println("Please enter the row number(0-8) to move :");
			int p1Row = input.nextInt();
			// Warning Message for Player 1(Input numbers must be from 0 to
			// 8)
			while (p1Row < 0 || p1Row > 7) {
				System.out.println("Invalid Input. Please enter 0-8!");
				System.out
						.println("Please enter the row number(0-8) to move :");
				p1Row = input.nextInt();
			}

			// Player 1 that input column which the chess need
			System.out.println("Please enter the column number(0-6) to move :");
			int p1Column = input.nextInt();
			// Warning Message for Player 1(Input numbers must be from 0 to
			// 6)
			while (p1Column < 0 || p1Column > 6) {
				System.out.println("Invalid Input. Please enter 0-6!");
				System.out
						.println("Please enter the column number(0-6) to move :");
				p1Column = input.nextInt();
			}

			System.out.println("");

			// Call execute to check the animal the next step position that
			// it
			// is correct or not. Otherwise, output "Invalid move!"
			if (a1[p1].execute(p1Row, p1Column, a1, a2, c) == false)
				System.out.println("Invalid move!\n");

			// } while (a1.execute(p1Row, p1Column, a1, a2, c) == true);

			// Player 2--------------------------------------------------------
			String p2AnimalDisplay = "";

			// Print the Chess Board with all items for player 2
			System.out.print(this);

			// Print the choices that give Player 2 to choose the chess
			System.out.println("Player 2: Please select an animal to move :");
			for (int animal = 0; animal < a2.length; animal++) {
				p2AnimalDisplay += (a2[animal].getName() + ", ");
			}
			System.out.println(p2AnimalDisplay.substring(0, p2AnimalDisplay
					.length() - 2));
			int p2 = input.nextInt();

			// Warning Message for Player 2(Input number must be not dead
			// animal(s))
			while (p2 < 0 || p2 > 7 || a2[p2].getDead()) { // <--Cuation!!!!!
				System.out
						.println("Invalid Input. Please select an animal again!");
				p2 = input.nextInt();
			}

			// Player 2 that input row which the chess need
			System.out.println("Please enter the row number(0-8) to move :");
			int p2Row = input.nextInt();
			// Warning Message for Player 2(Input numbers must be from 0 to 8)
			while (p2Row < 0 || p2Row > 7) {
				System.out.println("Invalid Input. Please enter 0-8!");
				System.out
						.println("Please enter the row number(0-8) to move :");
				p2Row = input.nextInt();
			}

			// Player 2 that input column which the chess need
			System.out.println("Please enter the column number(0-6) to move :");
			int p2Column = input.nextInt();
			// Warning Message for Player 2(Input numbers must be from 0 to 6)
			while (p2Column < 0 || p2Column > 6) {
				System.out.println("Invalid Input. Please enter 0-6!");
				System.out
						.println("Please enter the column number(0-6) to move :");
				p2Column = input.nextInt();
			}

			System.out.println("");

			// Call execute to check the animal the next step position that it
			// is correct or not. Otherwise, output "Invalid move!"
			if (a2[p2].execute(p2Row, p2Column, a1, a2, c) == false)
				System.out.println("Invalid move!\n");

		}
	}

	// checkWin is a method to determine if the game ends and print out the
	// winner of the game
	public void checkWin() {
	}

	// toString is a method to return the chess board in a standard output
	// format
	public String toString() {

		StringBuffer output = new StringBuffer();

		for (int i = 0; i < 9; i++) {
			output.append(i + "| ");

			for (int j = 0; j < 7; j++) {

				// 
				boolean check = false;

				for (int z = 0; z < a1.length; z++) {
					if (a1[z].getDead())
						continue;
					Position p = a1[z].getPosition();
					if (p.getX() == i && p.getY() == j) {
						output.append(a1[z].toString() + " ");
						check = true;
					}
				}

				if (check) {
					continue;
				}

				for (int z1 = 0; z1 < a2.length; z1++) {
					if (a2[z1].getDead())
						continue;
					Position p1 = a2[z1].getPosition();
					if (p1.getX() == i && p1.getY() == j) {
						output.append(a2[z1].toString() + " ");
						check = true;
					}
				}

				if (check) {
					continue;
				}

				output.append(c[i][j] + " ");
			}

			output.append("| \n");
			output.append(" |----------------------| \n");
		}

		output.append("   0  1  2  3  4  5  6 \n\n");
		return output.toString();
	}
}