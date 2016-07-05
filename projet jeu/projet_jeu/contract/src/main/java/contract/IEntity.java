package contract;

/**
 * L'interface IEntity
 */
public interface IEntity extends IElement {
	
	/**
	 * Getter pour la direction
	 * @return
     * La direction de l'entité
	 */
    Direction getDirection();
    
    /**
     * Setter pour la direction
     * @param direction
     * Direction de l'entité
     */
    void setDirection(Direction direction);
    
    /**
     * Déplacer l'entité à une position spécifique 
     * @param x
     * position x
     * @param y
     * position y
     */
    void moveTo(int x, int y);
}
