package contract;

import java.util.Observer;

/**
 * L'interface IView
 */
public interface IView 
{
	/**
	 * Mettre à jour la vu
	 */
	void repaint();

	
	/**
	 * Ouvrir une fenêtre
	 */
	void openFrame();

	
	/**
	 * Getter pour l'observer
	 * @return
	 * L'observer
     */
	Observer getObserver();

	
	/**
	 * Setter pour le controller
	 * @param controller
	 * Le controller
	 */
	void setController(IController controller);

}
