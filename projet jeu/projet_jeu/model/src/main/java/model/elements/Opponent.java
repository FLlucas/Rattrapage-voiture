package model.elements;

import contract.AIType;
import contract.Behavior;
import contract.Direction;
import model.Sprite;

import static contract.AIType.*;

/**
 * La classe Monster
 */
public class Opponent extends AI implements contract.IOpponent {
    /**
     * Instancie la classe
     * @param x
     * Position X
     * @param y
     * Position Y
     * @param direction
     * La direction
     */
    public Opponent(int x, int y, Direction direction) {
        super(x, y, "sprites/opposant.png");
        this.direction = direction;
        this.behavior = Behavior.DEATH;
        switch(direction){
            default:
                this.aiType = STRAIGHT;
                this.sprite = new Sprite("sprites/opposant.png");
                break;
        }
    }

}
