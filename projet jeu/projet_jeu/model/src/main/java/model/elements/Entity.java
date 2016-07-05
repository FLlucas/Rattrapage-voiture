package model.elements;

import contract.IEntity;
import contract.Direction;
import model.Sprite;

import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * La classe Entity
 */
public abstract class Entity extends Element implements IEntity {

    public boolean moveTo(Integer x, Integer y){
        return false;
    }
    /**
     * Direction de l'entité
     */
    protected Direction direction;

    /**
     * Constructeur de la classe
     * @param x
     * Position X
     * @param y
     * Position Y
     * @param image
     * L'image
     */

    public Entity(int x, int y, String image) {
        super(x, y, image);
        this.direction = Direction.LEFT;
    }

    /**
     * Déplacer l'élément à une position spécifique
     * @param x
     * La position X
     * @param y
     * La position Y
     */
    public void moveTo(int x, int y){
        this.setLocation(x,y);
    }

    /**
     * Getter pour la direction
     * @return Direction
     * La direction
     */
    public Direction getDirection() {
        return direction;
    }

    /**
     * Setter pour la direction
     * @param direction
     * La nouvelle direction
     */
    public void setDirection(Direction direction) {
        this.direction = direction;
    }

}
