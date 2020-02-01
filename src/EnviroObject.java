import Resources.Vector2D;

import java.awt.*;

public abstract class EnviroObject extends GameObject {
    boolean colision;

    public EnviroObject(int posX, int posY, double radius, boolean colision){
        super(new Vector2D(Constants.translate(posX), Constants.translate(posY)), new Vector2D(0,0), radius);
        System.out.println(Constants.translate(posX));
        System.out.println(Constants.translate(posY));
    }


    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.YELLOW);
        g.fillRect((int) position.x, (int)position.y, sizeX, sizeY);
        g.setColor(Color.black);
        g.fillRect((int) position.x, (int)position.y, sizeX, sizeY);
    }
}
