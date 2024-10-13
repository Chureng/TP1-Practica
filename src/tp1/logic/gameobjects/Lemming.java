package tp1.logic.gameobjects;

import tp1.logic.*;
import tp1.view.Messages;

public class Lemming {

	private int fallDamage;
	private boolean alive;
	private boolean hasLeft;
	private Position position;
	private Direction direction;
	private Game game;

	// Constructor
	public Lemming(Position position, Game game) {
		this.fallDamage = 0;
		this.alive = true;
		this.hasLeft = false;
		this.position = position;
		this.direction = Direction.RIGHT;
		this.game = game;
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

		if (i == Game.DIM_Y) { // Si no hay muro, el lemming se sale del mapa y muere
			setAlive(false);
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
		Position under = new Position(getPosition().getCol(), getPosition().getRow() + 1);
		Position in_front = new Position(getPosition().getCol() + getDirection().getX(), getPosition().getRow());

		if (in_front.getCol() < 10 && in_front.getCol() >= 0) { // Comprobar que no se sale por los laterales
			if (!getGame().getContainer().hasWall(under)) { // Si no hay muro, el lemming cae
				if (this.getFallDamage() == 0) {
					this.setfallDamage(distanceFromGround());
				}
				this.fall();
			} else if (this.getFallDamage() >= 3) { // Si su daño de caida es >=3 entonces muere
				this.setAlive(false);
			} else if (getGame().getContainer().hasExitDoor(in_front)) { // Si tiene una puerta en frente, sale
				this.setHasLeft(true);
			} else if (getGame().getContainer().hasWall(in_front)) { // Si tiene una pared en frente, cambia de dirección
				this.changeDirection();
			} else { // Si no ocurre ningún evento especial, da un paso
				this.step(); 
			}
		}else { // Si se se sale por los laterales, muere
			this.setAlive(false);
		}
	}

}