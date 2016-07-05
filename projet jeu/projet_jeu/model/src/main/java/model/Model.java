package model;


import contract.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import model.elements.*;
import model.database.DBConnection;

/**
 * La classe Model.
 */
public class Model extends Observable implements IModel {

	/**
	 * Le niveau
	 */
	private Level level;

	/**
	 * Le joueur
	 */
	private Car hero;


	/** 
	 * Instantier la classe 
	 */
	public Model() {
		this.hero = new Car(1,1);
		this.level = null;
	}
	
	/** 
	 * Réinitialiser le model
	 */
	public void resetModel(){
		this.hero = new Car(1,1);
		this.level = null;
	}

	
	
	/**
	 * Charger le niveau initial
	 */
	public void loadInitLevel(){
		if(this.level==null)
		{
			this.level = new Level(1,6,12,new Car(1,11));
			this.level.setElement(0,0,new Street(0,0, "sprites/street.png"));
		}
		int randomNum = 1 + (int)(Math.random() * 6);
		if(randomNum%2==0) randomNum--;
		AI ele = new Opponent(randomNum,0, Direction.RIGHT);
		ele.setAiType(AIType.STRAIGHT);
		this.level.addEntity(ele);
		int randomNum2;
		do{
			randomNum2 = 1 + (int)(Math.random() * 6);
			if(randomNum2%2==0) randomNum2--;
		}while(randomNum==randomNum2);
		randomNum = randomNum2;
		ele = new Opponent(randomNum,1, Direction.RIGHT);
		ele.setAiType(AIType.STRAIGHT);
		this.level.addEntity(ele);
	}

	/**
	 * Getter pour le level
	 * @return 
	 * Retourne le level actuel
	 */
	public Level getLevel(){
		return this.level;
	}

	/**
	 * Notifier la vue que le model a changé
	 */
	public void flush() {
		this.setChanged();
		this.notifyObservers();
	}
	
	/**
	 * Getter de l'observable
	 * @return 
	 * Retourne l'Observable
	 */
	public Observable getObservable() {
		return this;
	}
	
	/**
	 * Obtenir l'élément à une position spécifique
	 * @return 
	 * Retourne l'element à la position (x,y) ou null
	 */
	public IElement getElement(int x, int y) {
		return this.level.getElement(x,y);
	}

	/**
	 * Obtenir tous les éléments du niveau
	 * @return 
	 * Un tableau de tableau des éléments
	 */
	public IElement[][] getElements(){
		return this.level.getElements();
	}

	/**
	 * Getter pour le joueur
	 * @return 
	 * Retourne le joueur
	 */
	public IEntity getHero(){
		return this.hero;
	}
	
	/**
	 * Enregistrer le score dans la BD
	 */
	public void saveScore(){
		DBConnection db = DBConnection.getInstance();
		try {
			db.saveScore(this.getLevel().getHero().getScore());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
}
