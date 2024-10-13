package tp1.control;

import tp1.logic.Game;
import tp1.view.*;

public class Controller {

	private Game game;
	private GameView view;

	public Controller(Game game, GameView view) {
		this.game = game;
		this.view = view;
	}
	
	public void run() {
		view.showWelcome();
		game.initGame1();
		view.showGame();
		String[] command;
		command = view.getPrompt();
		while (!command[0].equalsIgnoreCase("exit") && !game.playerWins() && !game.playerLooses()) {
			if (command[0].equalsIgnoreCase("r") || command[0].equals("reset")) {
				game.initGame1();
				view.showGame();
			} else if (command[0].equalsIgnoreCase("h") || command[0].equals("help")) {
				System.out.println(game.help());
			} else if (command[0].equalsIgnoreCase("n") || command[0].equals("none") || command[0].equals("") ) {
				game.update();
				game.updateCycle();
				view.showGame();
			}else {
				System.out.println(Messages.UNKNOWN_COMMAND);
			}
			command = view.getPrompt();
		}
		view.showEndMessage();
	}

}