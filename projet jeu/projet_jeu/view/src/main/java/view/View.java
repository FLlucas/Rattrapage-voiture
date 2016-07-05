package view;


import java.util.Observer;

import contract.IController;

import contract.IView;

/**
 * La classe View.
 */
public class View implements IView
{
	
	/**
	 * La fenetre de jeu, instante de la classe GameFrame
	 */
	private GameFrame frame;
	
	
	/**
	 * constructeur de la classe View
	 */
	public View()
	{
		this.frame = new GameFrame();
	}


	/**
	 * Mettre à jour la fenêtre
	 */
	public void repaint()
	{

	}
	
	
	/**
	 * methode pour ouvrir la fenêtre
	 */
	public void openFrame()
	{
		this.frame.setVisible(true);
	}

	
	/**
	 * methode pour fermer la fenêtre
	 */
	public void closeFrame()
	{
		this.frame.setVisible(false);
	}
	
	
	/**
	 * methode pour charger l'Observer du pattern
	 */
	public Observer getObserver() 
	{
		return this.frame.getGamePanel();
	}

	
	/**
	 * Affecter le controlleur associé à la vue
	 * @param controller
	 * Le controleur associé
     */
	public void setController(IController controller) 
	{
		this.frame.setController(controller);
	}
}
