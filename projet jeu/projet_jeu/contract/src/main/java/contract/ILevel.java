package contract;

import java.util.ArrayList;
/**
 * L'interface ILevel
 */
public interface ILevel {

    /**
     * Ajouter une entité
     * @param entity
     * L'entité à ajouter
     */
    void addEntity(IEntity entity);

    /**
     * Supprimer une entité
     * @param entity
     * L'entité à supprimer
     */
    void removeEntity(IEntity entity);

    /**
     * Getter pour la dimension
     * @return IDimension
     * La dimension
     */
    IDimension getDimension();

    /**
     * Setter pour la dimension
     * @param dimension
     * La nouvelle dimension
     */
    void setDimension(IDimension dimension);

    /**
     * Getter pour le joueur
     * @return ICar
     * Le joueur
     */
    ICar getHero();

    /**
     * Setter pour le joueur
     * @param hero
     * Le joueur
     */
    void setHero(ICar hero);

    /**
     * Gtter pour les éléments
     * @return IElement[][]
     * Les éléments du niveau
     */
    IElement[][] getElements();

    /**
     * Setter pour les éléments
     * @param elements
     * Les éléments du niveau
     */
    void setElements(IElement[][] elements);

    /**
     * Trouver l'élément à la position spécifiée
     * @param x
     * position x
     * @param y
     * position y
     * @return
     * les éléments du niveau
     */
    IElement getElement(int x, int y);

    /**
     * Mettre un élément à la position spécifiée
     * @param element
     * L'élément en question
     * @param x
     * position x
     * @param y
     * position y
     */
    void setElement(int x, int y, IElement element);

    /**
     * Getter pour les entités
     * @return 
     * Les entités du niveau
     */
    ArrayList<IEntity> getEntities();

    /**
     * Getter pour l'id du niveau
     * @return
     * L'id du niveau
     */
    int getId();

    /**
     * Détruire une entité
     * @param entity
     * L'entité
     * @return boolean
     */
	boolean destroyElement(IEntity entity);

}
