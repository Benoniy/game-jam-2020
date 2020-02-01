import Resources.Vector2D;

import java.awt.*;

public abstract class EnviroObject extends GameObject {
    boolean colision;
    int offsetX, offsetY;
    Vector2D offset;

    public EnviroObject(int posX, int posY, double radius, boolean colision){
        super(new Vector2D(Constants.translate(posX), Constants.translate(posY)), new Vector2D(0,0), radius);
        this.offsetX = Constants.translate(posX);
        this.offsetY = Constants.translate(posY);
        this.offset = new Vector2D(offsetX, offsetY);
    }


    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.YELLOW);
        g.fillRect((int) position.x, (int)position.y, sizeX, sizeY);
        g.setColor(Color.black);
        g.fillRect((int) position.x, (int)position.y, sizeX, sizeY);
    }

    @Override
    public void update() {
        this.position = new Vector2D(Constants.controlPosition).add(offset);
    }
}
