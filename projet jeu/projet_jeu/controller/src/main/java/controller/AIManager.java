package controller;

import contract.Direction;
import contract.IAI;
import contract.IEntity;
import contract.IModel;

import java.util.Random;

/**
 * La classe AIManager.
 */
class AIManager {
	/**
	 * Instance de la classe selone le pattern Singleton
	 */
    private static AIManager ourInstance;
    
    /**
     * Le model
     */
    private IModel model;
    
    /**
     * Le gestionnaire de mouvement
     */
    private MoveManager mm;

    /**
     * Retourne l'instance unique de la classe
     * @return AIManager
     * L'instance de la classe courante
     */
    public static AIManager getInstance() {
        if(ourInstance == null)
            System.err.println("AI manager not initialized");
        return ourInstance;
    }

    /**
     * Initialiser l'instance par un model
     * @param model
     * Le model du jeu
     */
    public static void init(IModel model){
        ourInstance = new AIManager(model);
    }

    /**
     * Constructeur privé
     * @param model
     * Le model du jeu
     */
    private AIManager(IModel model) {
        this.model = model;
        this.mm = MoveManager.getInstance();
    }

	/**
	 * Les mouvements possibles de l'AI
	 * @param entity
	 * entité AI
	 */
    void performAi(IAI entity){
        switch (entity.getAiType()){
            case STRAIGHT:
                this.performStraight(entity);
                break;
        }
    }
	/**
	 * La réalisation du déplacement vertical des voitures
	 * @param ai
	 * mouvement AI
	 */
    private void performStraight(IAI ai){
        int nextX, nextY;
        nextX = ai.getLocation().getX();
        nextY = ai.getLocation().getY();
        switch (ai.getDirection()){
        case LEFT:
            nextY++;
            break;
        case RIGHT:
            nextY++;
            break;
        default:
            System.out.println("Direction invalide pour "+ai.toString());
            break;
        }
        mm.safeMoveTo(ai,nextX,nextY);
    }
}
