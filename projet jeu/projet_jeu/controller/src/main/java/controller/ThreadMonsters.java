package controller;

import contract.IModel;

/**
 * La classe ThreadMonsters.
 * Ajoute les voitures dans le traget
 */
public class ThreadMonsters implements Runnable {

	/**
	 * Le modèle
	 */
	private IModel model;
	
	/** 
	 * Le constructeur de la classe
	 * @param model
	 * Le modèle du jeu
	 */
    public ThreadMonsters(IModel model) {
			this.model = model;
			
	}
    
    /**
     * La méthode run du thread
     */
	public void run() {
		while(true){
			if(this.model.getLevel().getHero().isAlive()){
				for(long i=0; i<1000000000;i++);
				for(long i=0; i<1000000000;i++);
				for(long i=0; i<1000000000;i++);
				model.loadInitLevel();
				for(long i=0; i<1000000000;i++);
				for(long i=0; i<1000000000;i++);
				for(long i=0; i<1000000000;i++);
			}
		}
		
    }

}
