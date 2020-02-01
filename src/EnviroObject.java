import Resources.Vector2D;

import java.awt.*;

public class EnviroObject extends GameObject {
    int sizeX = 96;
    int sizeY = 96;
    boolean colision;

    public EnviroObject(int posX, int posY, double radius, boolean colision){
        super(new Vector2D(posX, posY), new Vector2D(0,0), radius);

    }
    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.YELLOW);
        g.fillRect(0,0, sizeX, sizeY);
        g.setColor(Color.black);
        g.drawRect(0, 0, sizeX, sizeY);
    }
}
