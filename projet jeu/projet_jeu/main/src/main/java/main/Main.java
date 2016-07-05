package main;

import controller.Controller;
import model.Model;
import view.View;

/**
 * La classe Main.
 */
public abstract class Main {

	/**
	 * La méthode d'entrée.
	 *
	 * @param args
	 * les arguments
	 */
	public static void main(final String[] args) {
		Model model = new Model();
		View view = new View();
		Controller controller = new Controller(view,model);
		view.setController(controller);
		controller.start();
	}
}