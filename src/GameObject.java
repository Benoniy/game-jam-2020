import Resources.Vector2D;

import java.awt.*;

public abstract class GameObject {
    public Vector2D position;
    Vector2D velocity;
    double radius;
    boolean dead;
    boolean god = false;



    public GameObject(Vector2D position, Vector2D velocity, double radius){
        this.position = position;
        this.velocity = velocity;
        this.radius = radius;
        this.dead = false;
    }

    public void hit(){
        dead = true;
    }



    public boolean overlap(GameObject other){
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
        if (this.overlap(other)){
            this.hit();
            other.hit();
        }
    }

    public void update(){
        position.addScaled(velocity, Constants.DT);
        position.wrap(Constants.width, Constants.height);
    }

    public boolean canHit(GameObject other){return true;};

    public abstract void draw(Graphics2D g);
}
