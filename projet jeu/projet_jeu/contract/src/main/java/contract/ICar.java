package contract;

/**
 * L'interface ICar
 */
public interface ICar extends IEntity {
    /**
     * Getter pour le score
     * @return Integer
     * Le score du joueur
     */
    Integer getScore();
    
    /**
     * Setter pour le score
     * @param score
     * Le nouveau score
     */
    void setScore(Integer score);
    
   /**
    * Getter pour alive
    * @return boolean
    * Le jeu est terminé ou pas
    */
    boolean isAlive();
    
    /**
     * Setter pour alive
     * @param alive
     * Le jeu est terminé ou pas
     */
    void setAlive(boolean alive);

}
