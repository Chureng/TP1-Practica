package tp1.logic;

import tp1.logic.gameobjects.*;
import tp1.view.Messages;
import tp1.logic.lemmingRoles.*;

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
	public int getLevel() {
		return this.nLevel;
	}

	public int getCycle() {
		return this.cycle;
	}

	public GameObjectContainer getContainer() {
		return this.container;
	}
	
	// Private functions
	private void updateCycle() {
		this.cycle++;
	}
	
	private void initGame0() {
		this.container = new GameObjectContainer();
		WalkerRole walker = new WalkerRole("walker");

		setCycle(0);

		// Lemmings
		container.addLemming(9, 0, this, walker);

		container.addLemming(2, 3, this, walker);

		container.addLemming(0, 8, this, walker);

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

	private void initGame1() {
		this.container = new GameObjectContainer();
		WalkerRole walker = new WalkerRole("walker");

		setCycle(0);

		// Lemmings
		container.addLemming(9, 0, this, walker);

		container.addLemming(2, 3, this, walker);
		container.addLemming(3, 3, this, walker);

		container.addLemming(0, 8, this, walker);

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


	// Public functions
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
		return 2;
	}

	public String positionToString(int col, int row) {
		Position position = new Position(col, row);
		StringBuilder icons = new StringBuilder();

		// Lemmings
		for (Lemming lemming : getContainer().getLemmings()) {
			if (lemming.getPosition().equals(position)) {
				icons.append(lemming.getWalkerRole().getIcon(lemming));
			}
		}

		// Walls
		for (Wall wall : getContainer().getWalls()) {
			if (wall.getPosition().equals(position)) {
				icons.append(wall.getIcon());
			}
		}

		// Exit door
		ExitDoor exitDoor = getContainer().getExitDoor();
		if (exitDoor.getPosition().equals(position)) {
			icons.append(exitDoor.getIcon());
		}

		return icons.length() > 0 ? icons.toString() : " ";
	}

	public boolean playerWins() {
		return (container.getLemmings().size() == 0 && container.getLeftLemmings() >= 2);
	}

	public boolean playerLooses() {
		return (container.getLemmings().size() == 0 && container.getLeftLemmings() < 2);
	}

	public String help() {
		return Messages.HELP;
	}
	
	public boolean initGame(int nLevel) {
		
		switch (nLevel) {
		case 0:
			this.nLevel = nLevel;
			initGame0();
			return true;
		case 1:
			this.nLevel = nLevel;
			initGame1();
			return true;
		default:
			System.out.println("Not an existing level");
			System.out.println(" ");
			return false;
		}
	}
	
	public boolean initGame() {
		switch (this.nLevel) {
		case 0:
			initGame0();
			return true;
		case 1:
			initGame1();
			return true;
		default:
			System.out.println("Not an existing level");
			System.out.println(" ");
			return false;
		}
	}

	public void update() {
		container.update();
		updateCycle();
	}

}