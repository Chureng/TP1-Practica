package tp1.logic.gameobjects;

import tp1.logic.Game;
import tp1.logic.Position;
import tp1.logic.Direction;
import tp1.view.Messages;

public class Lemming {
	private int fallDamage;
	private boolean alive;
	private Position position;
	private Direction direction;

	public Lemming(int row, int col) {
		this.fallDamage = 0;
		this.alive = true;
		this.position = new Position(row, col);
		this.direction = Direction.RIGHT;
	}

	// Getters

	public int getFallDamage() {
		return fallDamage;
	}

	public boolean getAlive() {
		return alive;
	}

	public Position getPosition() {
		return position;
	}

	public Direction getDirection() {
		return direction;
	}

	// Update

	public void update() {

	}

	// Print
	public String getIcon(Lemming lemming) {
		if (lemming.getDirection() == Direction.RIGHT) {
			return Messages.LEMMING_RIGHT;
		} else {
			return Messages.LEMMING_LEFT;
		}
	}
}