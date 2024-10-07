package tp1.logic;

import tp1.logic.GameObjectContainer;
import tp1.logic.gameobjects.Lemming;

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
		// TODO Auto-generated method stub
		return 0;
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
		
		for (Lemming x : container.getLemmings()) {
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
		Position position1 = new Position(2, 3);
		Position position2 = new Position(3, 3);
		Position position3 = new Position(0, 8);
		Position position4 = new Position(9, 0);
		Lemming lemming1 = new Lemming(position1);
		Lemming lemming2 = new Lemming(position2);
		Lemming lemming3 = new Lemming(position3);
		Lemming lemming4 = new Lemming(position4);
		
		container.add(lemming1);
		container.add(lemming2);
		container.add(lemming3);
		container.add(lemming4);
		
		// Walls 
		Position positionW1 = new Position(3, 4);
		Position positionW2 = new Position(4, 4);
		Position positionW3 = new Position(5, 4);
		Lemming wall1 = new Lemming(positionW1);
		Lemming wall2 = new Lemming(positionW2);
		Lemming wall3 = new Lemming(positionW3);
		container.add(wall1);
		container.add(wall2);
		container.add(wall3);
	

	}

}