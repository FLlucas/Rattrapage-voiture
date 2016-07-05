package view;


import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import contract.IController;
import contract.Order;


/**
 * La classe ViewFrame.
 */
class GameFrame extends JFrame implements KeyListener 
{
	
	/**
	 * Largeur de la fenêtre
	 */
	private int width = 228;
	
	
	/**
	 * Hauteur de la fenêtre
	 */
	private int height = 564;
	
	
	/**
	 * Un lien avec le controlleur
	 */
	private IController controller;

	
	/**
	 * Le panel qui regroupe les élements
	 */
	private GamePanel panel;
	
	
	/**
	 * constructeur de la classe
	 * initiliser le jeu
	 */
	GameFrame()
	{
		this.setTitle("La route est à vous");
		this.setSize(width, height);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.panel = new GamePanel();
		this.panel.setBackground(Color.GRAY);
		this.setContentPane(this.panel);
		this.setResizable(false);
		
		this.addKeyListener(this);
	}
	
	/**
	 * Mettre à jour à partir de la View
	 */
	public void repaint()
	{
		this.panel.repaint();
	}
	
	
	/**
	 * getter pour le GamePanel
	 * @return
	 * Le GamePanel de la fenêtre
	 */
	public GamePanel getGamePanel()
	{
		return this.panel;
	}
	
	
	/**
	 * getter pour le Width
	 * @return
	 * Retourne width
	 */
	public int getWidth()
	{
		return width;
	}
	
	
	/**
	 * geter pour le Height
	 * @return
	 * Retourne height
	 */
	public int getHeight()
	{
		return height;
	}
	
	
	/**
	 * getter pour le Controller
	 * @return
	 * retourne le controller
	 */
	public IController getController() 
	{
		return controller;
	}
	
	
	/**
	 * setter pour le controller
	 * @param controller
	 * affecter le controller
	 */
	public void setController(IController controller)
	{
		this.controller = controller;
	}

	
	/**
	 * Capture les actions de l'utilisateur et les envoyer au controller
	 */
	public void keyPressed(KeyEvent e) 
	{
		switch(e.getKeyCode())
		{
			case KeyEvent.VK_Q:
			case KeyEvent.VK_LEFT:
			this.controller.orderPerform(Order.CHARACTER_LEFT);
			break;
			
			case KeyEvent.VK_D:
			case KeyEvent.VK_RIGHT:
			this.controller.orderPerform(Order.CHARACTER_RIGHT);
			break;
			
			case KeyEvent.VK_R:
			this.controller.orderPerform(Order.RETRY);
			break;
		}
	}
	
	
	/**
	 * Capture l'évènement de relachement d'une touche
	 */
	public void keyReleased(KeyEvent e) 
	{
		
	}
	
	
	/**
	 * Capture l'évènement de clic sur une touche
	 */
	public void keyTyped(KeyEvent e) 
	{
	
	}

	
}
