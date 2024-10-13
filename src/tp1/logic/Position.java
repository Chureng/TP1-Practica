package tp1.logic;

public class Position {

	private int col;
	private int row;

	// Constructor
	public Position(int col, int row) {
		this.col = col;
		this.row = row;
	}

	// Getters
	public int getCol() {
		return col;
	}

	public int getRow() {
		return row;
	}

	// Functions
	public boolean equals(Position position) {
		if (position == null) {
			return false;
		}
		if (position.getClass() != this.getClass()) {
			return false;
		}
		Position other = (Position) position;
		if (other.getCol() == this.col && other.getRow() == this.row) {
			return true;
		} else {
			return false;
		}
	}

}