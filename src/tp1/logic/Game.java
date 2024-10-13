package tp1.logic;

import tp1.logic.gameobjects.*;
import tp1.view.Messages;

public class Game {

	public static final int DIM_X = 10;
	public static final int DIM_Y = 10;

	private int nLevel;
	private int cycle;
	private GameObjectContainer container;

	// Constructor
	public Game(int nLevel) {
		this.nLevel = nLevel;
		this.cycle = 0;
		this.container = new GameObjectContainer();
	}

	// Setters
	public void setCycle(int cycle) {
		this.cycle = cycle;
	}

	// Getters
	public int getCycle() {
		return this.cycle;
	}

	public GameObjectContainer getContainer() {
		return this.container;
	}

	// Functions
	public int numLemmingsInBoard() {
		return container.getLemmings().size();
	}

	public int numLemmingsDead() {
		return container.getDeadLemmings();
	}

	public int numLemmingsExit() {
		return container.getLeftLemmings();
	}

	public int numLemmingsToWin() {
		return nLevel;
	}

	public String positionToString(int col, int row) {
		Position position = new Position(col, row);
		StringBuilder multipleLemmings = new StringBuilder();
		
		for (Lemming lemming : getContainer().getLemmings()) {
			if (lemming.getPosition().equals(position)) {
				multipleLemmings.append(lemming.getIcon());
			}
		}
		if (multipleLemmings.length()>0) {
			return multipleLemmings.toString();
		}
		
		for (Wall wall : getContainer().getWalls()) {
			if (wall.getPosition().equals(position)) {
				return wall.getIcon();
			}
		}
		ExitDoor exitDoor = getContainer().getExitDoor();
		if (exitDoor.getPosition().equals(position)) {
			return exitDoor.getIcon();
		}
		return " ";
	}

	public boolean playerWins() {
		return (container.getLemmings().size() == 0 && container.getLeftLemmings() >= nLevel);
	}

	public boolean playerLooses() {
		return (container.getLemmings().size() == 0 && container.getLeftLemmings() < nLevel);
	}

	public String help() {
		return Messages.HELP;
	}

	public void initGame1() {
		// Lemmings
		container.addLemming(9, 0, this);

		container.addLemming(2, 3, this);
		container.addLemming(3, 3, this);

		container.addLemming(0, 8, this);

		// Walls
		container.addWall(8, 1);
		container.addWall(9, 1);

		container.addWall(2, 4);
		container.addWall(3, 4);
		container.addWall(4, 4);

		container.addWall(7, 5);

		container.addWall(4, 6);
		container.addWall(5, 6);
		container.addWall(6, 6);
		container.addWall(7, 6);

		container.addWall(8, 8);

		container.addWall(0, 9);
		container.addWall(1, 9);
		container.addWall(8, 9);
		container.addWall(9, 9);

		// Exit door
		container.setExitDoor(4, 5);
	}

	public void updateCycle() {
		this.cycle++;
	}

	public void update() {
		container.update();
	}

}