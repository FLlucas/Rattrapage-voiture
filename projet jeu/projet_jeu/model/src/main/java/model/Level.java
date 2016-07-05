package model;


import contract.*;
import model.elements.Element;
import model.elements.Car;
import java.util.ArrayList;

/**
 * niveau du jeu
 */
public class Level implements ILevel {


    private ArrayList<IEntity> entities;

    /**
     * l'ID du niveau
     */
    private int id;

    /**
     * Les éléments du niveau
     */
    private IElement elements[][];

    /**
     * Le joueur
     */

    private ICar hero;

    /**
     * Dimension du niveau
     */
    private IDimension dimension;

    /**
     * Niveau terminé ou non
     */
    private boolean finished;
    

    /**
     * Instanciation du niveau
     * @param id
     * L'id du niveau
     * @param width
     * La largeur du niveau
     * @param height
     * L'hauteur du niveau
     * @param hero
     * Le joueur
     */
    public Level(int id,int width, int height, Car hero) {
        this.dimension = new Dimension(width,height);
        this.hero = hero;
        this.elements = new Element[height][width];
        this.entities = new ArrayList<IEntity>();
        this.id = id;
    }

    /**
     * Ajouter entité
     * @param entity
     * L'entité à ajouter
     */
    public void addEntity(IEntity entity){
        this.entities.add(entity);
    }

    /**
     * Supprimer entité 
     * @param entity
     * L'entité à supprimer
     */
    public void removeEntity(IEntity entity){
        this.entities.remove(entity);
    }
    /**
     * Détruire élément
     * @param element
     * L'élément à détruire
     */
    public void destroyElement(IElement element) {
    	this.entities.remove(element);

    }
    /**
     * Getter pour la dimension
     * @return
     * La dimension
     */
    public IDimension getDimension() {
        return dimension;
    }
    /**
     * Setter pour la dimension
     * @param dimension
     * la nouvelle dimension
     */
    public void setDimension(IDimension dimension) {
        this.dimension = dimension;
    }
    /**
     * Getter pour le Hero
     * @return
     * Retourne le joueur
     */
    public ICar getHero() {
        return hero;
    }
    /**
     * Setter pour le Hero
     * @param hero
     * Le joeur
     */
    public void setHero(ICar hero) {
        this.hero = hero;
    }

    /**
     * Getter pour les éléments du niveau
     * @return elements
     * Retourne les éléments du niveau
     */
    public IElement[][] getElements() {
        return elements;
    }
    /**
     * Setter pour les éléments du niveau
     * @param elements
     * Liste des éléments
     */
    public void setElements(IElement[][] elements) {
        this.elements = elements;
    }
    
    /**
     * Retourner l'élément à la position donnée
     * @return IElement
     * L'élément à la position donnée
     */
    public IElement getElement(int x, int y){
        return this.elements[y][x];
    }

    /**
     * Affecter un élément à une position
     * @param x
     * position x
     * @param y
     * position y
     * @param element
     * l'élément
     */
    public void setElement(int x, int y, IElement element){
        this.elements[y][x] = element;
    }

    /**
     * Getter pour les entities du niveau
     * @return
     * Les entités
     */
    public ArrayList<IEntity> getEntities() {
        return (ArrayList<IEntity>) entities.clone();
    }
    /**
     * Setter pour les entities
     * @param entities
     * les entités
     */
    public void setEntities(ArrayList<IEntity> entities) {
        this.entities = entities;
    }
   
    /**
     * Getter du id
     * @return int
     * L'id
     */
    public int getId() {
        return id;
    }
    /**
     * Setter du id
     * @param id
     * L'id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Détruire un élément
     * @param element
     * L'élément à détruire
     * @return boolean
     * L'élément a pu être détruit ou non
     */
    public boolean destroyElement(IEntity element) {
        if (element instanceof IEntity) {
            this.entities.remove(element);
            return true;
        }
        return false;

    }
}

