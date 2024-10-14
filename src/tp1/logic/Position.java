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
	@Override
	public boolean equals(Object object) {
		if (object == null) {
			return false;
		}
		if (object.getClass() != this.getClass()) {
			return false;
		}
		Position other = (Position) object;
		if (other.getCol() == this.col && other.getRow() == this.row) {
			return true;
		} else {
			return false;
		}
	}

}