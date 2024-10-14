package tp1.logic.lemmingRoles;

import tp1.logic.Direction;
import tp1.logic.Position;
import tp1.logic.gameobjects.Lemming;
import tp1.view.Messages;

public class WalkerRole {
	private String role;

	// Constructor
	public WalkerRole(String role) {
		this.role = role;
	}

	// Getters
	public String getRole() {
		return role;
	}

	// Setters
	public void setRole(String role) {
		this.role = role;
	}

	// Funcitions
	public void play(Lemming lemming) {
		if (role == "walker") {
			Position under = new Position(lemming.getPosition().getCol(), lemming.getPosition().getRow() + 1);
			Position in_front = new Position(lemming.getPosition().getCol() + lemming.getDirection().getX(),
					lemming.getPosition().getRow());
			if (under.getRow() < 10) {
				if (!lemming.getGame().getContainer().hasWall(under)) { // Si no hay muro, el lemming cae
					if (lemming.getFallDamage() == 0) {
						lemming.setfallDamage(lemming.distanceFromGround());
					}
					lemming.fall();
				} else if (lemming.getFallDamage() >= 3) { // Si su daño de caida es >=3 entonces muere
					lemming.setAlive(false);
				} else if (lemming.getGame().getContainer().hasExitDoor(lemming.getPosition())) { // Si tiene una puerta se sale																			
					lemming.setHasLeft(true);
				} else if (in_front.getCol() > 9 || in_front.getCol() < 0
						|| lemming.getGame().getContainer().hasWall(in_front)) {
					lemming.changeDirection();
				} else { // Si no ocurre ningún evento especial, da un paso
					lemming.step();
				}
			} else {
				lemming.setAlive(false);
			}
		}
	}

	public String getIcon(Lemming lemming) {
		if (lemming.getDirection() == Direction.RIGHT) {
			return Messages.LEMMING_RIGHT;
		} else {
			return Messages.LEMMING_LEFT;
		}
	}
}
