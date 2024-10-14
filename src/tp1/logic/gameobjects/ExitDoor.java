package tp1.logic.gameobjects;

import tp1.logic.Position;
import tp1.view.Messages;

public class ExitDoor {
	
	private Position position;

	// Constructor
	public ExitDoor (Position position){
		this.position = position;
	}
	
	// Getters;
	public Position getPosition() {
		return position;
	}
	
	// Functions;
	public String getIcon() {
		return Messages.EXIT_DOOR;
	}

}
