package Graphics;
/*
    Creates and maintains GUI, including the window and buttons
*/
import Config.ConfigReader;
import Input.MouseInput;


import javax.swing.*;
import java.awt.*;

public class GameFrame {
    public static JFrame createFrame(GameGraphics gameGraphics, MouseInput mouseInput){
        // Initializing frame
        JFrame frame = new JFrame("Sand Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        int w = ConfigReader.getOption("width"), h = ConfigReader.getOption("height");
        frame.setSize(w, h+100);
        frame.setResizable(false);

        // Initializing components
        frame.setLayout(new BorderLayout());

        // Input; TODO
        JPanel buttons = new JPanel();
        JButton button1 = new JButton("Rainbow Sand");
        buttons.add(button1);
        gameGraphics.addMouseListener(mouseInput);

        // Adding components to frame
        frame.getContentPane().add(gameGraphics, BorderLayout.CENTER);
        frame.getContentPane().add(buttons, BorderLayout.PAGE_END);

        frame.setVisible(true);
        return frame;
    }
}
