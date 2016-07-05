package model.elements;

import contract.*;
import model.Location;
import model.Sprite;

import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * La classe Element
 */
public abstract class Element implements IElement {

    /**
     * Comportement de l'élément
     */
    protected Behavior behavior;
    
    /**
     * Position de l'élément
     */
    protected ILocation location;
    
    /**
     * Le sprite de l'élément
     */
    protected ISprite sprite;
    
    /**
     * Constructeur de la classe
     * @param location
     * La position de l'element
     * @param image
     * Chemin de l'image de l'élément
     */
    public Element(Location location, String image) {
        this.location = location;
        this.sprite = new Sprite(image);
    }

    /**
     * Constructeur de la classe
     * @param x
     * Position X
     * @param y
     * Position Y
     * @param image
     * Chemin de l'image de l'élément
     */
    public Element(int x, int y, String image) {
        this.location = new Location(x,y);
        this.sprite = new Sprite(image);
    }

    /**
     * Constructeur de la classe
     * @param x
     * Position X
     * @param y
     * Position Y
     * @param sprite
     * Le sprite de l'élément
     */
    public Element(int x, int y, Sprite sprite) {
        this.location = new Location(x,y);
        this.sprite = sprite;
    }

    /**
     * Constructeur de la classe
     * @param location
     * Position de l'élément
     * @param sprite
     * Le sprite de l'élément
     */
    public Element(Location location, Sprite sprite) {
        this.location = location;
        this.sprite = sprite;
    }

  

    /**
     * Exécuté lorsque l'élément entre en collision avec un autre
     * @param other
     * L'autre élément
     * @param level
     * Le niveau du jeu
     */
    public void onCollision(IElement other, ILevel level){

    }
    
    /**
     * Getter pour le behavior
     * @return Behavior
     * Le behavior
     */
    public Behavior getBehavior() {
        return behavior;
    }

    /**
     * Getter pour location
     * @return ILocation
     * la position
     */
    public ILocation getLocation() {
        return location;
    }

    /**
     * Setter pour location
     * @param location
     * La position de l'élément
     */
    public void setLocation(ILocation location) {
        this.location = location;
    }

    /**
     * Setter pour location
     * @param x
     * position X
     * @param y
     * position Y
     */
    public void setLocation(int x, int y) {
    	for(long i=0;i<200000000; i++);
        this.location.setX(x);
        this.location.setY(y);
    }

    /**
     * Getter pour stripe
     * @return ISprite
     * le sprite
     */
    public ISprite getSprite() {
        return sprite;
    }

    /**
     * Setter pour sprite
     * @param sprite
     * le nouveau sprite
     */
    public void setSprite(ISprite sprite) {
        this.sprite = sprite;
    }

    /**
     * Getter pour l'image
     * @return Image
     * Retourne l'image
     */
    public Image getImage() {
        return this.sprite.getImage();
    }
}
