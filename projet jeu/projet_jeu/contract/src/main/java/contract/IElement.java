package contract;

import java.awt.*;

/**
 * L'interface IElement
 */
public interface IElement {

	/**
	 * Quoi faire lorsque l'élément entr en collision avec un autre
	 * @param other
     * L'autre élément
	 * @param level
     * Le niveau actuel
	 */
    void onCollision(IElement other, ILevel level);

    /**
     * Getter pour behavior
     * @return
     * Le comportement de l'élément
     */
    Behavior getBehavior();

    /**
     * Getter pour location
     * @return
     * La position de l'élément
     */
    ILocation getLocation();

    /**
     * Setter pour location
     * @param location
     * La nouvelle position de l'élément
     */
    void setLocation(ILocation location);

    /**
     * Setter pour location
     * @param x
     * position x
     * @param y
     * position y
     */
    void setLocation(int x, int y);

    /**
     * Getter pour le sprite
     * @return
     * Le sprite de l'élément
     */
    ISprite getSprite();

    /**
     * Setter pour le sprite
     * @param sprite
     * Le nouveau sprite de l'élément
     */
    void setSprite(ISprite sprite);

    /**
     * Getter pour l'image
     * @return
     * L'image de l'élément
     */
    Image getImage();
}
