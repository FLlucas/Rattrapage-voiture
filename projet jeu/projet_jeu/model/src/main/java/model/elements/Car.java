package model.elements;

import model.AnimatedSprite;

/**
 * La classe Car qui représente le joueur
 */
public class Car extends Entity implements contract.ICar {
   /**
    * Le jeu terminé ou pas
    */
   private boolean alive;
   
   /**
    * Score du joueur
    */
   private Integer score = 0;

    /**
     * Constructeur de la classe
     * @param x
     * position x
     * @param y
     * position y
     */
    public Car(int x, int y) {
        super(x, y, "sprites/voiture.png");
        String imagesPaths[] = {
                "sprites/voiture.png",
        };
        this.sprite = new AnimatedSprite("sprites/voiture.png",imagesPaths);
        this.alive = true;
    }
    
    /**
     * Getter pour le score
     * @return Integer
     * Le score
     */

    public Integer getScore() {
        return score;
    }
    
    /**
     * Setter pour le score
     * @param score
     * Le score
     */
    public void setScore(Integer score) {
        this.score = score;
    }

    /**
     * Getter pour alive
     * @return boolean
     * Le jeu terminé ou pas
     */
	public boolean isAlive() {
		return alive;
	}

	
	/**
     * Setter pour alive
     * @param alive
     * Le jeu terminé ou pas
     */
	public void setAlive(boolean alive) {
		this.alive = alive;
	}

}
