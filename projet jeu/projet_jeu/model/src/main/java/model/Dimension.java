package model;

/**
 * La classe Dimension
 */
public class Dimension implements contract.IDimension {
    /**
     * La largeur du jeu
     */
    private int width;
    
    /**
     * L'hauteur du jeu
     */
    private int height;

    /**
     *Instancie la classe
     * @param width
     * Largeur du niveau
     * @param height
     * Hauteur du niveau
     */
    public Dimension(int width, int height) {
        this.width = width;
        this.height = height;
    }
   
    /**
     * Getter pour la largeur
     * @return
     * Retourne le width
     */

    public int getWidth() {
        return width;
    }
    
    /**
     * Setter pour la largeur
     * @param width
     * Retourne la largeur
     */

    public void setWidth(int width) {
        this.width = width;
    }
    
    /**
     * Getter pour l'hauteur
     * @return
     * Retourne le height
     */

    public int getHeight() {
        return height;
    }
    /**
     * Setter pour l'hauteur
     * @param height
     * Retourne le height
     */

    public void setHeight(int height) {
        this.height = height;
    }
}
