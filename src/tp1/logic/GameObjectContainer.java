package tp1.logic;

import java.util.ArrayList;
import tp1.logic.gameobjects.Lemming;
import tp1.logic.gameobjects.Wall;
import tp1.logic.gameobjects.ExitDoor;

public class GameObjectContainer {
	
	private ArrayList<Lemming> lemmings;
	private ArrayList<Wall> walls;	
	private ExitDoor exitDoor;
	// Constructor
	public GameObjectContainer() {
		lemmings = new ArrayList<>();
		walls = new ArrayList<>();
	}
	// Add
	public void add(Lemming lemming) {
		lemmings.add(lemming);
	}
	
	public void add(Wall wall) {
		walls.add(wall);
	}
	
	public void setExitDoor(ExitDoor exitDoor) {
		this.exitDoor = exitDoor;
	}
	// Update
	public void update() {
		
	}

}