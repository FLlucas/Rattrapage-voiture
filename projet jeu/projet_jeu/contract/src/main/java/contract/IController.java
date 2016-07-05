package contract;

/**
 * L'interface IController.
 */
public interface IController {

	/**
	 * Envoi un ordre au controller.
	 *
	 * @param order
	 * L'ordre à exécuter
     */
	public void orderPerform(Order order);

	/**
	 * Assigner le model au controller
	 *
	 * @param model
	 * Le model du controller
     */
	public void setModel(IModel model);
	

	/**
	 * Commencer le jeu
	 */
	public void start();

}
