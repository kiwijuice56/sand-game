package Graphics;
/*
    Creates and maintains GUI, including the window and buttons
*/
import Config.ConfigReader;
import Gameplay.PhysicsEngine;
import Input.ButtonInput;
import Input.MouseInput;

import javax.swing.*;
import java.awt.*;

public class GameFrame {
    public static void createFrame(PhysicsEngine physicsEngine, GameGraphics gameGraphics, MouseInput mouseInput){
        // Initializing frame
        JFrame frame = new JFrame("Sand Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        int w = ConfigReader.getOption("width"), h = ConfigReader.getOption("height");
        frame.setSize(w, h+ConfigReader.getOption("guiPadding"));
        frame.setResizable(false);

        // Initializing layout
        frame.setLayout(new BorderLayout());

        // Initializing input
        gameGraphics.addMouseListener(mouseInput);

        // TODO: Buttons for different particles
        JPanel buttons = new JPanel();
        String[] particleTypes = {"Sand", "Stone"};
        for (String particleType : particleTypes) {
            JButton button = new JButton(particleType);
            button.addActionListener(new ButtonInput(physicsEngine, particleType));
            buttons.add(button);
        }

        // Adding components to frame
        frame.getContentPane().add(gameGraphics, BorderLayout.CENTER);
        frame.getContentPane().add(buttons, BorderLayout.PAGE_END);

        frame.setVisible(true);
    }
}
