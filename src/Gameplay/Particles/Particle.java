package Gameplay.Particles;
/*
    Individual particle
*/

public class Particle {
    private int color;
    private boolean gravity;
    public Particle(int color, boolean gravity){
        this.color = color;
        this.gravity = gravity;
    }

    public int getColor(){
        return color;
    }
    public boolean getGravity(){
        return gravity;
    }
}
