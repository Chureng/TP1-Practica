package tp1.logic.gameobjects;

import tp1.logic.Position;
import tp1.view.Messages;

public class Wall {

	private Position position;
	
	// Constructor
	public Wall (Position position){
		this.position = position;
	}
	
	// Getters;
	public Position getPosition() {
		return position;
	}
	
	// Functions;
	public String getIcon() {
		return Messages.WALL;
	}

}
