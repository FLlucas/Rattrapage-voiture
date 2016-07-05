package controller;

import contract.*;

/**
 * La classe MoveManager pour gérer les mouvements
 */
class MoveManager {
	
	/**
	 * Linstance unique de la classe selon le pattern Singleton
	 */
    private static MoveManager ourInstance;
    
    /**
     * Le model du jeu
     */
    private IModel model;

    /**
     * Getter pour l'instance unique de la classe
     * @return MoveManager
     * L'instance
     */
    public static MoveManager getInstance() {
        if(ourInstance == null)
            System.err.println("Move manager not initialized");
        return ourInstance;
    }

    /**
     * Initialiser l'innstance
     * @param model
     * Le model du jeu
     */
    public static void init(IModel model){
        ourInstance = new MoveManager(model);
    }

    /**
     * Le constructeur privé de la classe
     * @param model
     * Le model du jeu
     */
    private MoveManager(IModel model) {
        this.model = model;
    }
    
    /**
     * Vérifier si un élément entre en collision avec un autre
     * @return IElement
     * L'autre élément en collision ou null si aucun
     * @param element
     * L'élément en question
     */
    IElement hasCollision(IElement element){
        ILocation elementLocation = element.getLocation();
        for(IEntity entity: this.model.getLevel().getEntities()){
            if(elementLocation.getX() == entity.getLocation().getX() && (elementLocation.getY()-2 == entity.getLocation().getY() || elementLocation.getY() == entity.getLocation().getY() || elementLocation.getY()-1 == entity.getLocation().getY() || elementLocation.getY()+1 == entity.getLocation().getY()) && element != entity){
                return entity;
            }
        }
        return this.model.getLevel().getElements()[elementLocation.getY()][elementLocation.getX()];
    }

    /**
     * Vérifier si un déplacement et possible ou non
     * @param x
     * position x
     * @param y
     * position y
     * @return boolean
     * Déplacement possible ou non
     */
    boolean canMoveOn(int x, int y){
        IDimension levelDimentions = this.model.getLevel().getDimension();
        if(x > levelDimentions.getWidth()-1 || x < 0)
            return false;
        if(y > levelDimentions.getHeight()-1 || y < 0)
            return false;
        
        return true;
    }

    /**
     * Déplacer une entité à une position spécifique
     * @param entity
     * L'entité à déplacer
     * @param x
     * Position X
     * @param y
     * Position Y
     * @return boolean
     * Déplacement possible ou non
     */
    boolean safeMoveTo(IEntity entity, int x, int y){
        if(canMoveOn(x,y) || y<11) {
            entity.moveTo(x,y);
            this.model.flush();
            return true;
        }
        if(this.model.getLevel().destroyElement(entity) && this.model.getLevel().getHero().isAlive())
        	this.model.getLevel().getHero().setScore(this.model.getLevel().getHero().getScore()+10);
        return false;
    }
}
