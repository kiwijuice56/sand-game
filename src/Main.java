import Config.ConfigReader;
import Gameplay.PhysicsEngine;
import Graphics.GameFrame;
import Graphics.GameGraphics;
import Input.MouseInput;

public class Main{
    public static void main(String[] args){
        // Read options into Config class from config.txt
        ConfigReader.readConfig();

        // Initialize engine, input, and window
        PhysicsEngine physicsEngine = new PhysicsEngine();
        MouseInput mouseInput = new MouseInput(physicsEngine);
        GameGraphics gameGraphics = new GameGraphics(physicsEngine.getGrid());

        GameFrame.createFrame(physicsEngine, gameGraphics, mouseInput);

        // Main loop
        // TODO: implement delta
        while (true) {
            physicsEngine.calculatePositions();
            try{ Thread.sleep(10); }
            catch(InterruptedException ex) { Thread.currentThread().interrupt(); }
        }
    }
}