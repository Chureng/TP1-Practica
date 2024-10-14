package tp1.control;

import tp1.logic.Game;
import tp1.view.*;

public class Controller {

	private Game game;
	private GameView view;

	// Constructor
	public Controller(Game game, GameView view) {
		this.game = game;
		this.view = view;
	}

	// Functions
	private boolean isExit(String[] command) {
		return command[0].equals(Messages.COMMAND_EXIT_NAME) || command[0].equals(Messages.COMMAND_EXIT_SHORTCUT);
	}

	private boolean GameOver(String[] command) {
		return isExit(command) || game.playerWins() || game.playerLooses();
	}

	public void run() {
		if (game.initGame()) {
			view.showWelcome();
			view.showGame();
			String[] command;
			do {
				command = view.getPrompt();
				if (command.length == 1) { // Comandos sin argumentos
					if (!isExit(command)) {
						switch (command[0]) {
						case Messages.COMMAND_RESET_NAME:
						case Messages.COMMAND_RESET_SHORTCUT:
							game.initGame();
							view.showGame();
							break;
						case Messages.COMMAND_HELP_NAME:
						case Messages.COMMAND_HELP_SHORTCUT:
							System.out.println(game.help());
							break;
						case Messages.COMMAND_NONE_NAME:
						case Messages.COMMAND_NONE_SHORTCUT:
						case Messages.EMPTY:
							game.update();
							view.showGame();
							break;
						default:
							System.out.println(Messages.ERROR_UNKNOWN_COMMAND);
						}
					}
				} else if (command.length == 2) { // Comandos con 1 argumeto;
					if (command[0].equals(Messages.COMMAND_RESET_NAME)
							|| command[0].equals(Messages.COMMAND_RESET_SHORTCUT)) {
						if (game.initGame(Integer.parseInt(command[1]))) {
							view.showGame();
						}
						;
					}
				} else { // Comandos con más de 1 argumento (No existentes de momento)
					System.out.println(Messages.ERROR_INCORRECT_PARAMETER_NUMBER);
				}
			} while (!GameOver(command));

			view.showEndMessage();
		}
	}

}