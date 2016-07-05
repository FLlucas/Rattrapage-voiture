package model;


import contract.ISprite;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Un sprite represente un élement
 */
public class Sprite implements ISprite {


    /** L'image du sprite */
    protected Image image;

    /**
     * Instancie le sprite
     * @param image
     * Chemin de l'iimage
     */
    public Sprite(String image) {
        try {
            this.image =ImageIO.read(this.getClass().getClassLoader().getResourceAsStream(image));
        } catch (IOException e) {
            System.err.println("Impossible de charger l'image "+image);
            e.printStackTrace();
        }
    }

    /**
     * Instanciate the sprite
     * @param image
     * The image
     */
    public Sprite(Image image) {
        this.image = image;
    }

    /**
     * Get the current image of the sprite
     * @return The image of the sprite
     */
    public Image getImage() {
        return image;
    }
}
