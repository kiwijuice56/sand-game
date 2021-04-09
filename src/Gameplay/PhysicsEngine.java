package Gameplay;
/*
    Updates position of each particle
*/
import java.util.Random;
import Config.ConfigReader;

public class PhysicsEngine {
    private Particle[][] grid;
    private int w;
    private int h;

    public PhysicsEngine(){
        w = ConfigReader.getOption("width");
        h = ConfigReader.getOption("height");
        grid = new Particle[h][w];
    }

    public Particle[][] getGrid(){
        return grid;
    }

    public void addParticle(int x, int y){
        int size = ConfigReader.getOption("brushSize");
        int color = new Random().nextInt();
        for (int i = Math.max(0, y-(size/2)); i < Math.min(h, y+(size/2)); i++){
            for (int j = Math.max(0, x-(size/2)); j < Math.min(w, x+(size/2)); j++){
                if (grid[i][j] == null)
                    grid[i][j] = new Particle(color);
            }
        }

    }
    public void calculatePositions(){
        for (int y = h-1; y >= 0; y--){
            for (int x = w-1; x >= 0; x--){
                Particle p = grid[y][x];
                if (p == null)
                    continue;
                if (y+1 < h) {
                    if (grid[y+1][x] == null)
                        grid[y+1][x] = p;
                    else if (x+1 < w && grid[y+1][x+1] == null)
                        grid[y+1][x+1] = p;
                    else if (x-1 >= 0 && grid[y+1][x-1] == null)
                        grid[y+1][x-1] = p;
                    else
                        continue;
                    grid[y][x] = null;
                }
            }
        }
    }
}
