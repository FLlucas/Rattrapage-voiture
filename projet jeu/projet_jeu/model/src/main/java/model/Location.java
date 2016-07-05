package model;

/**
 * Une classe représentant l'emplacement d'un élément
 */
public class Location implements contract.ILocation {
    /** La position X */
    private int x;
    /** Le position Y */
    private int y;

    /**
     * Instantie la classe
     * @param x
     * La position X
     * @param y
     * La position Y
     */
    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Getter de la position Y
     * @return 
     * La position Y
     */
    public int getY() {
        return y;
    }

    /**
     * Setter de la position Y
     * @param y
     * La nouvelle position Y
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Getter de la position X
     * @return 
     * La position X
     */
    public int getX() {
        return x;
    }

    /**
     * Setter de la position X
     * @param x
     * La nouvelle position X
     */
    public void setX(int x) {
        this.x = x;
    }
}
