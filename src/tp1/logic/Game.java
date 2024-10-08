package tp1.logic;

import tp1.logic.GameObjectContainer;
import tp1.logic.gameobjects.Lemming;
import tp1.logic.gameobjects.Wall;

public class Game {

	public static final int DIM_X = 10;
	public static final int DIM_Y = 10;

	private GameObjectContainer container;
	private int nLevel;

	public Game(int nLevel) {
		this.nLevel = nLevel;
		initGame1();
	}

	public int getCycle() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int numLemmingsInBoard() {
		int count = 0;
		for (Lemming x : container.getLemmings()) {
			if (x.getAlive()) {
				count++;
			}
		}
		return count;
	}

	public int numLemmingsDead() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int numLemmingsExit() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int numLemmingsToWin() {
		// TODO Auto-generated method stub
		return 0;
	}

	public String positionToString(int col, int row) {
		for (Lemming x : container.getLemmings()) {
			if (x.getPosition().getCol() == col && x.getPosition().getRow() == row) {
				return x.getIcon(x);
			}
		}

		for (Wall x : container.getWalls()) {
			if (x.getPosition().getCol() == col && x.getPosition().getRow() == row) {
				return x.getIcon(x);
			}
		}
		return " ";
	}

	public boolean playerWins() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean playerLooses() {
		// TODO Auto-generated method stub
		return false;
	}

	public String help() {
		// TODO Auto-generated method stub
		return null;
	}

	public void initGame1() {
		container = new GameObjectContainer();
		// Lemmings
		container.addLemming(2, 3);
		container.addLemming(3, 3);

		// Walls
		container.addWall(2, 4);
		container.addWall(3, 4);
		container.addWall(4, 4);
	}
	
	public void update() {
		container.update(container);
	}

}