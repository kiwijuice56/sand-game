import Config.ConfigReader;
import Gameplay.PhysicsEngine;
import Graphics.GameFrame;
import Graphics.GameGraphics;
import Input.MouseInput;


import javax.swing.JFrame;

public class Main{
    public static void main(String[] args){
        // Read options into Config class from config.txt
        ConfigReader.readConfig();

        // Initialize game graphics and add to window
        PhysicsEngine physicsEngine = new PhysicsEngine();
        MouseInput mouseInput = new MouseInput(physicsEngine);
        GameGraphics gameGraphics = new GameGraphics(physicsEngine.getGrid());

        GameFrame.createFrame(gameGraphics, mouseInput);

        while (true) {
            physicsEngine.calculatePositions();
            try
            {
                Thread.sleep(10);
            }
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }
        }
        //main loop
        //calculate game state
        //draw particles

    }
}