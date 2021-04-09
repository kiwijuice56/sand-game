package Graphics;
/*
    Updates image of gameplay, ie. draws the particles
*/
import Config.ConfigReader;
import Gameplay.Particle;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GameGraphics extends JPanel {
    private BufferedImage image;
    private Particle[][] grid;
    int w;
    int h;

    public GameGraphics(Particle[][] grid){
        this.grid = grid;
        w = ConfigReader.getOption("width");
        h = ConfigReader.getOption("height");
        image = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for (int y = h-1; y >= 0; y--){
            for (int x = w-1; x >= 0; x--){
                if (grid[y][x] != null)
                    image.setRGB(x, y, grid[y][x].getColor());
                else
                    image.setRGB(x, y, ConfigReader.getOption("bgColor"));
            }
        }
        g.drawImage(image, 0, 0, null);
        repaint();
    }
}
