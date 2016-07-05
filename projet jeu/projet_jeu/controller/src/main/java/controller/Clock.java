package controller;

import contract.IController;

import java.util.Observable;

/**
 * L'horloge du jeu
 */
public class Clock extends Thread {

    /** 
     * nombre de tiques depuis le départ du jeu
      */
    private int tickNumber;
    
    /**
     * L'interval entre deux tiques
     */
    private long tickInterval;
    
    /** 
     * L'état de l'horloge: démarré ou arrêté
      */
    private boolean stopped;
    
    /** 
     * L'interval par défaut entre deux tiques
     */
    public static int DEFAULT_TICK_INTERVAL = 100;


    /**
     * Le controller du jeu
     */
    private Controller controller;


    /**
     * Instantie la classe
     * @param controller
     * le controller du jeu
     */
    public Clock(Controller controller) {
        this.tickNumber = 0;
        this.setTickInterval(DEFAULT_TICK_INTERVAL);
        this.controller = controller;
    }
    /**
     * La méthode run du thread
     */
    public void run() {
        while(true) {
            this.controller.update();
            try {
                Thread.sleep(this.tickInterval);
            } catch (InterruptedException e) {
                System.err.println("Thread de l'horloge interrompu");
                e.printStackTrace();
            }
            this.tickNumber++;
        }
    }
    /**
     * Getter du nombre des tiques
     * @return
     * nombre des tiques depuis le début du jeu
     */
    public int getTickNumber() {
        return tickNumber;
    }

    /**
     * Get the interval between two ticks.
     * @return
     * The interval in miliseconds.
     */
    public long getTickInterval() {
        return tickInterval;
    }

    /**
     * Setter du interval entre deux tiques
     * @param tickInterval
     * Le nouveau interval en millisecondes
     */
    public synchronized void setTickInterval(long tickInterval) {
        this.tickInterval = tickInterval;
    }

    /**
     * Getter de l'état de l'horloge
     * @return
     * Trus si l'horloge est arrêté
     */
    public boolean isStopped() {
        return stopped;
    }

    /**
     * Arrête l'horloge
     */
    public void stopClock() {
        this.stopped = true;
    }
}
