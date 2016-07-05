package model.elements;

import contract.AIType;
import model.Sprite;

/**
 * La classe AI
 */
public abstract class  AI extends Entity implements contract.IAI {

    /**
     * Type de l'AI
     */
    protected AIType aiType;

    /**
     * instancie la classe
     * @param x
     * Laposition X
     * @param y
     * La position y
     * @param image
     * Chemin de l'image de l'élément
     */
    public AI(int x, int y, String image) {
        super(x, y, image);
    }

    /**
     * Getter pour le aiType
     * @return
     * L'AIType
     */
    public AIType getAiType() {
        return aiType;
    }

    /**
     * Setter pour l'aiType
     * @param aiType
     * Le nouveau AIType
     */
    public void setAiType(AIType aiType) {
        this.aiType = aiType;
    }
}
