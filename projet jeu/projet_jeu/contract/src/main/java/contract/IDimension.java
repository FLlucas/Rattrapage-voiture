package contract;

/**
 * Taille de l'écran
 */
public interface IDimension {

	/**
	 * getter pour la largeur
	 * @return
     * retourne la largeur de l'écran
	 */
    int getWidth();

    /**
     * Setter pour la largeur
     * @param width
     * Affecter la largeur de l'écran
     */
    void setWidth(int width);

    /**
     * Getter pour l'hauteur
     * @return
     * retourne l'hauteur de l'écran
     */
    int getHeight();

    /**
     * Setter pour l'hauteur
     * @param height
     * Affecter l'hauteur de l'écran
     */
    void setHeight(int height);
}
