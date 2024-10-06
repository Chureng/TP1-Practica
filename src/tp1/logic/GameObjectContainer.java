package tp1.logic;

import java.util.ArrayList;
import tp1.logic.gameobjects.Lemming;
import tp1.logic.gameobjects.Wall;
import tp1.logic.gameobjects.ExitDoor;

public class GameObjectContainer {
	//TODO fill your code
	private ArrayList<Lemming> lemmingsArray;
	private ArrayList<Wall> wallsArray;
	private ExitDoor exitDoor;
	
	public GameObjectContainer() {
		lemmingsArray = new ArrayList<>();
	}
	
	public void add(Lemming lemming) {
		lemmingsArray.add(lemming);
	}
	 
	public void add(Wall wall) {
		 
	}
	 
	public void add(ExitDoor exitDoor) {
		
	}

}