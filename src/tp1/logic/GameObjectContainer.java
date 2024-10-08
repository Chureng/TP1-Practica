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
	public void addLemming(int col, int row) {
		Position position = new Position(col, row);
		Lemming lemming = new Lemming(position);
		lemmings.add(lemming);
	}
	
	public void addWall(int col, int row) {
		Position position = new Position(col, row);
		Wall wall = new Wall(position);
		walls.add(wall);
	}
	
	public void setExitDoor(ExitDoor exitDoor) {
		this.exitDoor = exitDoor;
	}
	// Getters
	public ArrayList<Lemming> getLemmings(){
		return lemmings;
	}
	
	public ArrayList<Wall> getWalls(){
		return walls;
	}
	// Update
	public void update(GameObjectContainer container) {
		for (Lemming x: container.getLemmings()) {
			x.update(x);
		}
	}

}