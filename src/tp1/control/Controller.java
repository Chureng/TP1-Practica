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
		if (game.getLevel() == 1) {
			game.initGame1();
		} else {
			game.initGame0();
		}
		view.showGame();
		String[] command;
		do {
			command = view.getPrompt();
			if (!command[0].equals(Messages.COMMAND_EXIT_NAME) && !command[0].equals(Messages.COMMAND_EXIT_SHORTCUT)) {
				if (command.length >= 2) {
					System.out.println(Messages.ERROR_INCORRECT_PARAMETER_NUMBER);
				} else if (command[0].equalsIgnoreCase(Messages.COMMAND_RESET_NAME) || command[0].equalsIgnoreCase(Messages.COMMAND_RESET_SHORTCUT)) {
					game.initGame1();
					view.showGame();
				} else if (command[0].equalsIgnoreCase(Messages.COMMAND_HELP_NAME) || command[0].equalsIgnoreCase(Messages.COMMAND_HELP_SHORTCUT) ) {
					System.out.println(game.help());
				} else if (command[0].equalsIgnoreCase(Messages.COMMAND_NONE_NAME) || command[0].equals(Messages.COMMAND_NONE_SHORTCUT) || command[0].equals(Messages.EMPTY)) {
					game.update();
					game.updateCycle();
					view.showGame();
				} else {
					System.out.println(Messages.ERROR_UNKNOWN_COMMAND);
				}
			}
		} while (!command[0].equals(Messages.COMMAND_EXIT_NAME) && !command[0].equals(Messages.COMMAND_EXIT_SHORTCUT) && !game.playerWins() && !game.playerLooses());

		view.showEndMessage();
	}

}