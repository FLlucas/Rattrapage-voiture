package contract;

import java.util.ArrayList;
import java.util.Observable;

/**
 * L'Interface IModel
 */
public interface IModel{
	
	/**
	 * Retrouver un élément à partir de sa position
	 * @param x
	 * position x
	 * @param y
	 * position y
	 * @return
	 * L'élément à la position donnée
	 */
	IElement getElement(int x, int y);
	
	/**
	 * Getter pour les éléments
	 * @return IElement[][]
	 * Liste des éléments du jeu
	 */
	IElement[][] getElements();
	
	/**
	 * Informer le model que la vu a changé
	 */
	void flush();
	
	/**
	 * Getter pour l'observable
	 * @return Observable
	 * L'observable
	 */
	Observable getObservable();
	
	/**
	 * Getter pour le level
	 * @return ILevel
	 * Le level du jeu
	 */
	ILevel getLevel();
	
	/**
	 * Charger le niveau initial
	 */
	void loadInitLevel();
	
	/**
	 * Enregistrer le score dans la base de données
	 */
	void saveScore();
}
