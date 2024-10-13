package tp1.logic.gameobjects;

import tp1.logic.*;
import tp1.view.Messages;
import tp1.logic.lemmingRoles.*;

public class Lemming {

	private int fallDamage;
	private boolean alive;
	private boolean hasLeft;
	private Position position;
	private Direction direction;
	private Game game;
	private WalkerRole walkerRole;

	// Constructor
	public Lemming(Position position, Game game, WalkerRole walkerRole) {
		this.fallDamage = 0;
		this.alive = true;
		this.hasLeft = false;
		this.position = position;
		this.direction = Direction.RIGHT;
		this.game = game;
		this.walkerRole = walkerRole;
	}

	// Getters
	public int getFallDamage() {
		return fallDamage;
	}

	public boolean getAlive() {
		return alive;
	}

	public boolean getHasLeft() {
		return hasLeft;
	}

	public Position getPosition() {
		return position;
	}

	public Direction getDirection() {
		return direction;
	}

	public Game getGame() {
		return game;
	}
	
	public WalkerRole getWalkerRole() {
		return walkerRole;
	}

	// Setters
	public void setfallDamage(int fallDamage) {
		this.fallDamage = fallDamage;
	}

	public void setAlive(boolean alive) {
		this.alive = alive;
	}

	public void setHasLeft(boolean hasLeft) {
		this.hasLeft = hasLeft;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}
	
	public void setWalkerRole(WalkerRole walkerRole) {
		this.walkerRole = walkerRole;
	}

	// Functions
	public String getIcon() {
		if (this.getDirection() == Direction.RIGHT) {
			return Messages.LEMMING_RIGHT;
		} else {
			return Messages.LEMMING_LEFT;
		}
	}

	public void step() {
		int new_x = this.getPosition().getCol() + this.getDirection().getX();
		int new_y = this.getPosition().getRow();
		Position new_position = new Position(new_x, new_y);
		this.setPosition(new_position);
	}

	public void fall() {
		int new_x = this.getPosition().getCol();
		int new_y = this.getPosition().getRow() + Direction.DOWN.getY();
		Position new_position = new Position(new_x, new_y);
		this.setPosition(new_position);
	}

	public int distanceFromGround() {
		int i = 2;
		Position under_i = new Position(getPosition().getCol(), getPosition().getRow() + i);

		// Buscar la posición del muro de abajo para aterrizar
		while (i < Game.DIM_Y && !getGame().getContainer().hasWall(under_i)) {
			i++;
			under_i = new Position(getPosition().getCol(), getPosition().getRow() + i);
		}

		return --i;
	}

	public void changeDirection() {
		if (this.getDirection() == Direction.RIGHT) {
			this.setDirection(Direction.LEFT);
		} else {
			this.setDirection(Direction.RIGHT);
		}
	}

	public void update() {
		getWalkerRole().play(this);
	}

}