package controller;

import contract.Direction;
import contract.ICar;
import contract.IModel;

/**
 * La classe HeroManager pour le gérer le joueur
 */
class HeroManager {
	
	/**
	 * L'instance unique du gestionnaire selon le pattern Singleton
	 */
    private static HeroManager ourInstance;
    
    /**
     * Le model du jeu
     */
    private IModel model;
    
    /**
     * Le gestionnaire des mouvements
     */
    private MoveManager mm;

    
    /**
     * Getter pour l'instance unique de la classe
     * @return HeroManager
     * L'instance
     */
    public static HeroManager getInstance() {
        if(ourInstance == null)
            System.err.println("Hero Manager not initialized");
        return ourInstance;
    }

    /**
     * Initialiser le HeroManager
     * @param model
     * Le model du jeu
     */
    public static void init(IModel model){
        ourInstance = new HeroManager(model);
    }

    /**
     * Constructeur privé de la classe
     * @param model
     * Le model du jeu
     */
    private HeroManager(IModel model) {
        this.model = model;
        this.mm = MoveManager.getInstance();
    }
    /**
     * Déplacer le joueur, ici la voiture
     * @param direction
     * Direction du joueur
     * @return boolean
     * Indique si le déplacement a été possible ou non
     */
    public boolean move(Direction direction){
        ICar h = this.model.getLevel().getHero();
        if(!h.isAlive())
            return false;
        int nextX = h.getLocation().getX();
        int nextY = h.getLocation().getY();
        switch (direction){
            
            case LEFT:
                nextX = nextX-2;
                break;
            case RIGHT:
                nextX = nextX+2;
                break;
            default:
                System.out.println("Invalid direction move");
                break;
        }
        h.setDirection(direction);
        return mm.safeMoveTo(h,nextX,nextY);
    }

}
