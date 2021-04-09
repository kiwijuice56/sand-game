package Input;
/*
    Listens to mouse on screen in order to register input
    Uses reference of physicsEngine and calls functions to add/delete particles
*/
import Gameplay.PhysicsEngine;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class MouseInput implements MouseListener{
    private PhysicsEngine physicsEngine;

    public MouseInput(PhysicsEngine physicsEngine){
        super();
        this.physicsEngine = physicsEngine;
    }
    public void mouseClicked(MouseEvent e){ }
    public void mousePressed(MouseEvent e){
        physicsEngine.addParticle(e.getX(), e.getY());
    }
    public void mouseReleased(MouseEvent e){
    }
    public void mouseEntered(MouseEvent e){ }
    public void mouseExited(MouseEvent e){ }
}
