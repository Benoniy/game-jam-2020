import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class WallObject extends EnviroObject {
    public WallObject(int posX, int posY) {
        super(posX, posY, Constants.blockRadius, true);
        System.out.println(position);
    }
    @Override
    public void draw(Graphics2D g) {

        // Buffered Image is the texture
        BufferedImage texture = null;
        try {
            URL url = new URL("assets/wall.png");
            texture = ImageIO.read(url);
        } catch (IOException e) {

        }


        g.setColor(Color.BLUE);
        g.fillRect((int) position.x, (int)position.y, sizeX, sizeY);
        g.drawRect((int) position.x, (int)position.y, sizeX, sizeY);
    }

}
