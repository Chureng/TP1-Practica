package tp1.logic.gameobjects;

import tp1.logic.Direction;
import tp1.logic.Position;
import tp1.view.Messages;

public class Wall {

	private Position position;

	public Wall (Position position){
		this.position = position;
	}
	// Getters;
	public Position getPosition() {
		return position;
	}

	// Print
	public String getIcon(Wall wall) {
		return Messages.WALL;
	}

}
