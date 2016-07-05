package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import contract.IElement;
import contract.IEntity;
import contract.ICar;
import contract.ILevel;
import contract.IModel;

/**
 * La classe ViewPanel.
 */
class GamePanel extends JPanel implements Observer
{
	
	private IModel model;
	
	
	Font f;

	/**
	 * constructeur de la classe
	 */
	GamePanel()
	{
		setBackground(Color.BLACK);
		setVisible(true);
	}
	
	
	/**
	 * Construire les élements de la fenêtre
	 */
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		ILevel level = null ;
		f = new Font ("Consola", Font.BOLD, 20);
		g.setFont(f);
		g.setColor(Color.WHITE);
		if(this.model!=null){
			level = this.model.getLevel();
			for (int y = 0; y < level.getDimension().getHeight(); y++)
			{
				for (int x = 0; x < level.getDimension().getWidth(); x++)
				{
					IElement ele = level.getElement(x, y);
					if (ele == null)
						continue;
					g.drawImage(model.getElement(x,y).getImage(),x*32,y*32,this);
				}
			}
		

			for (IEntity ele : model.getLevel().getEntities())
			{
				g.drawImage(ele.getImage(), ele.getLocation().getX()*32, ele.getLocation().getY()*32, null);
			}
	
	
			if(this.model.getLevel().getHero().isAlive()) {
				ICar ele = level.getHero();
				g.drawImage(ele.getImage(), ele.getLocation().getX() * 32, ele.getLocation().getY() * 32, null);
			}
			
			if(!this.model.getLevel().getHero().isAlive()) 
			{
				g.drawString("GAME OVER", 50, 200);
				g.drawString("R pour réessayer", 30, 250);
			}
			
			g.setColor(Color.YELLOW);
			g.drawString("Score : "+model.getLevel().getHero().getScore().toString(), 20,514);
		}
		
	}

	/**
	 * methode pour mettre à jour les informations envoyées à la classe
	 * @param observable
	 * L'objet Observable
	 * @param o
	 * Un objet
	 */
	public void update(Observable observable, Object o) 
	{
		this.model = (IModel) observable;
		this.repaint();
	}

	
	
}
