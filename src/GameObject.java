import Resources.Vector2D;

import java.awt.*;

public abstract class GameObject {
    public Vector2D position;
    Vector2D velocity;
    int sizeX, sizeY;
    double radius;
    boolean dead;
    boolean god = false;
    boolean collision = false;



    public GameObject(Vector2D position, Vector2D velocity, double radius, boolean collision){
        this.position = position;
        this.velocity = velocity;
        this.radius = radius;
        this.dead = false;
        this.sizeX = Constants.blockSize;
        this.sizeY = Constants.blockSize;
        this.collision = collision;
    }

    public void hit(){
        dead = true;
    }



    public boolean overlap(GameObject other){

        if (position.dist(other.position) < (radius - 1) + (other.radius - 1)) {
            return true;
        }
        else{
            return false;
        }
    }

    public boolean trueOverlap(GameObject other){

        if (position.dist(other.position) < radius + other.radius) {
            return true;
        }
        else{
            return false;
        }
    }

    public boolean spawnOverlap(GameObject other){
        if (position.dist(other.position) < radius + other.radius + 50) {
            return true;
        }
        else{
            return false;
        }
    }

    public void collisionHandling(GameObject other){
    }

    public abstract void update();

    public boolean canHit(GameObject other){return true;};

    public abstract void draw(Graphics2D g);
}
