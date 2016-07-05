package controller;

import contract.*;


/**
 * La classe Controller.
 */
public class Controller implements IController {

	/**
	 * Le view
	 */
	private IView	view;

	/**
	 * Le model
	 */
	private IModel	model;

	/**
	 * L'horloge du jeu
	 */
	private Clock clock;

	/**
	 * Constructeur de la classe
	 * @param view
	 * Le view
	 * @param model
	 * Le model
	 */
	public Controller(final IView view, final IModel model) {
		this.setView(view);
		this.setModel(model);
		MoveManager.init(this.model);
		AIManager.init(this.model);
		CollisionManager.init(this.model);
		HeroManager.init(this.model);
	}

	/**
	 * Réaliser un ordre
	 * @param order
	 * L'ordre à réaliser
     */
	public void orderPerform(Order order) {
		HeroManager hm = HeroManager.getInstance();
		switch (order){
			case CHARACTER_LEFT:
				hm.move(Direction.LEFT);
				performCollision(this.model.getLevel().getHero());
				this.model.flush();
				break;
			case CHARACTER_RIGHT:
				hm.move(Direction.RIGHT);
				performCollision(this.model.getLevel().getHero());
				this.model.flush();
				break;
			case RETRY:
				this.model.getLevel().getHero().setAlive(true);
				this.model.getLevel().getHero().setScore(0);
				this.model.flush();
				this.view.repaint();
				CollisionManager.alreadyExecuted = false;
				break;
			default:
				System.out.println("Not supported order : "+order.toString());
				break;
		}
	}

	/**
	 * Commencer le jeu
	 */
	public void start(){
		this.model.loadInitLevel();
		this.model.getObservable().addObserver(this.view.getObserver());
		this.clock = new Clock(this);
		this.clock.start();
		this.view.openFrame();
		ThreadMonsters t = new ThreadMonsters(this.model);
		t.run();
	}

	/**
	 * Mettre à jour à chaque tique
	 */
	public void update() {
		AIManager aim = AIManager.getInstance();
		ILevel level = this.model.getLevel();
		for(IEntity entity:level.getEntities()){
			if(entity instanceof IAI){
				aim.performAi((IAI) entity);
			}
			performCollision(entity);
		}
		performCollision(level.getHero());
		this.model.flush();
	}

	
	/**
	 * Réaliser une collision
	 * @param element
	 * L'élément
	 */
	private void performCollision(IElement element){
		MoveManager mm = MoveManager.getInstance();
		CollisionManager cm = CollisionManager.getInstance();
		IElement other = mm.hasCollision(element);
		if(other == null)
			return;
		cm.performCrossedCollision(element,other);
	}


	/**
	 * Setter pour le view
	 * @param view
	 * Le view
	 */
	public void setView(final IView view) {
		this.view = view;
	}

	/**
	 * Setter pour le model
	 * @param model
	 * Le model
	 */
	public void setModel(final IModel model) {
		this.model = model;
	}

}
