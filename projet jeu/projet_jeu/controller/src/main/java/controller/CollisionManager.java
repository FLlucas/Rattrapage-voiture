package controller;

import contract.*;

/**
 * Gestion des collisions
 */
class CollisionManager {
	/**
	 * Unique instance de la classe selon le pattern Singleton
	 */
    private static CollisionManager ourInstance;
    
    /**
     * Le model
     */
    private IModel model;
    
    static boolean alreadyExecuted = false;

    /**
     * Retourne l'instance unique de la classe
     * @return CollisionManager
     * instance de la classe CollisionManager
     */
    static CollisionManager getInstance() {
        if(ourInstance == null)
            System.err.println("Movemanager non initialisé");
        return ourInstance;
    }
    
    /**
     * Initialiser le gestionnaire des collisions
     * @param model
     * Le model du jeu
     */
    static void init(IModel model){
        ourInstance = new CollisionManager(model);
    }
    
    /**
     * Le constructeur privé
     * @param model
     * Le model du jeu
     */
    private CollisionManager(IModel model) {
        this.model = model;
    }
    
    /**
     * Action après une collision
     * @param element
     * le premier élément
     * @param other
     * le second élément
     */
    void performCollision(IElement element, IElement other){
        if(element.getBehavior() == null)
            return;
        switch (element.getBehavior()){
            case DEATH:
            	if(!alreadyExecuted) {
            		this.model.saveScore();
            	    alreadyExecuted = true;
            	}
                performDeath(element,other);
                break;
            default:
                System.err.println("Not implemented behavior "+element.getBehavior().toString());
                break;
        }
    }
    
    /**
	 * Collision between elements
	 * @param element
     * Collision between elements
	 * @param other
     * collision between other
	 */
    void performCrossedCollision(IElement element, IElement other){
        if(element.getBehavior() != null)
            this.performCollision(element,other);
        if(other.getBehavior() != null)
            this.performCollision(other,element);
    }
    
	/**
	 * Opération lorsque le jeu est terminé
	 * @param element
     * Element for the death of the hero
	 * @param other
     * Other for the death of the hero
	 */
    private void performDeath(IElement element, IElement other){
        if(other instanceof ICar){
            ((ICar) other).setAlive(false);
        }
    }

    
    

}
