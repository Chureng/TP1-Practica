package tp1.logic;

import java.util.ArrayList;
import tp1.logic.gameobjects.*;
import tp1.logic.lemmingRoles.*;

public class GameObjectContainer {

	private ArrayList<Lemming> lemmings;
	private ArrayList<Wall> walls;
	private ExitDoor exitDoor;
	private int deadLemmings;
	private int leftLemmings;

	// Constructor
	public GameObjectContainer() {
		lemmings = new ArrayList<>();
		walls = new ArrayList<>();
		deadLemmings = 0;
		leftLemmings = 0;
	}

	// Getters
	public ArrayList<Lemming> getLemmings() {
		return lemmings;
	}

	public ArrayList<Wall> getWalls() {
		return walls;
	}

	public ExitDoor getExitDoor() {
		return this.exitDoor;
	}

	public int getDeadLemmings() {
		return this.deadLemmings;
	}

	public int getLeftLemmings() {
		return this.leftLemmings;
	}

	// Lemming functions
	public void addLemming(int col, int row, Game game, WalkerRole walkerRole) {
		Position position = new Position(col, row);
		Lemming lemming = new Lemming(position, game, walkerRole);
		lemmings.add(lemming);
	}

	public void deleteLemmings() {
		for (int i = 0; i < this.getLemmings().size(); i++) {
			if (!this.getLemmings().get(i).getAlive()) { // Quitar lemmings muertos + actualizar contador lemmings
															// muertos
				this.getLemmings().remove(i);
				this.updateDeadLemmings();
			} else if (this.getLemmings().get(i).getHasLeft()) { // Quitar lemmings salidos + actualizar contador de
																	// lemmings salidos
				this.getLemmings().remove(i);
				this.updateLeftLemmings();
			}
		}
	}

	public void updateDeadLemmings() {
		this.deadLemmings++;
	}

	public void updateLeftLemmings() {
		this.leftLemmings++;
	}

	// Wall functions
	public void addWall(int col, int row) {
		Position position = new Position(col, row);
		Wall wall = new Wall(position);
		walls.add(wall);
	}

	public boolean hasWall(Position position) {
		for (Wall wall : getWalls()) {
			if (wall.getPosition().equals(position)) {
				return true;
			}
		}
		return false;
	}

	// Exit door functions
	public void setExitDoor(int col, int row) {
		Position position = new Position(col, row);
		this.exitDoor = new ExitDoor(position);
	}

	public boolean hasExitDoor(Position pos) {
		return exitDoor.getPosition().equals(pos);
	}

	// Functions
	public void update() {
		for (Lemming lemming : this.getLemmings()) {
			lemming.update();
		}
		deleteLemmings();
	}

}