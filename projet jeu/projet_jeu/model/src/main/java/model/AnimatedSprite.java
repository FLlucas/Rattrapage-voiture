package model;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Animer les sprites
 */
public class AnimatedSprite extends Sprite implements contract.IAnimatedSprite {
	/**
	 * Liste des images à animer
	 */
    private Image images[];

    
    /**
     * Définie l'état actuel de l'animation
     */
    private int step;
    
    
    /**
     * Le constructeur de la classe
     * @param defaultImage
     * L'image par défaut
     * @param images
     * D'autres images si souhaité
     */
    public AnimatedSprite(String defaultImage, String[] images) {
        super(defaultImage);
        this.images = new Image[images.length];
        for(int i = 0; i<images.length; i++){
            try {
                this.images[i] = ImageIO.read(this.getClass().getClassLoader().getResourceAsStream(images[i]));
            } catch (IOException e) {
                System.err.println("Impossible de charger l'image "+images[i]);
                e.printStackTrace();
            }
        }
        this.step = 0;
    }

    /**
     * Initier l'état suivant de l'animation
     */
    public void nextStep()
    {
        this.step++;
        if(this.step >= this.images.length){
            this.step = 0;
        }
    }

    @Override
    public Image getImage() {
        return this.images[this.step];
    }
}
