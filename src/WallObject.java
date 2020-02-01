import java.awt.*;

public class WallObject extends EnviroObject {
    public WallObject(int posX, int posY) {
        super(posX, posY, Constants.blockRadius, true);
        System.out.println(position);
    }
    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.BLUE);
        g.fillRect((int) position.x, (int)position.y, sizeX, sizeY);
        g.setColor(Color.black);
        g.drawRect((int) position.x, (int)position.y, sizeX, sizeY);
    }
}
