package Gameplay;

public class Particle {
    private int color = 0;
    private boolean moved = false;
    public Particle(int color){
        this.color = color;
    }
    public int getColor(){
        return color;
    }
    public void setMoved(boolean moved){
        this.moved = moved;
    }
    public boolean getMoved(){
        return moved;
    }
}
