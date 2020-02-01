import java.awt.*;

public class FloorObject extends EnviroObject {
    public FloorObject(int posX, int posY, double radius) {
        super(posX, posY, radius, false);
    }
    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.GREEN);
        g.fillRect((int) position.x, (int)position.y, sizeX, sizeY);
        g.setColor(Color.black);
        g.drawRect((int) position.x, (int)position.y, sizeX, sizeY);
    }
}
