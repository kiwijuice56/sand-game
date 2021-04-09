package Input;
/*
    Listens to button presses for selecting particles
*/

import Gameplay.PhysicsEngine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonInput implements ActionListener {
    private PhysicsEngine physicsEngine;
    private String particleType;

    public ButtonInput(PhysicsEngine physicsEngine, String particleType){
        super();
        this.physicsEngine = physicsEngine;
        this.particleType = particleType;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        physicsEngine.setCurrentParticle(particleType);
    }
}
