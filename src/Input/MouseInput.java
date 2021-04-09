package Input;
/*

*/
import Gameplay.PhysicsEngine;

import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class MouseInput implements MouseListener{
    private PhysicsEngine physicsEngine;

    // Used reference of physics engine to call particle add/delete functions
    public MouseInput(PhysicsEngine physicsEngine){
        super();
        this.physicsEngine = physicsEngine;
    }
    public void mouseClicked(MouseEvent e){

    }
    public void mousePressed(MouseEvent e){
        physicsEngine.addParticle(e.getX(), e.getY());
    }
    public void mouseReleased(MouseEvent e){

    }
    public void mouseEntered(MouseEvent e){

    }
    public void mouseExited(MouseEvent e){

    }
}
