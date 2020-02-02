import Resources.Vector2D;

import java.awt.*;

public class MenuButton extends GameObject {
    int width, height, centerPosX, centerPosY;
    String text;

    public MenuButton(double posX, double posY, String text){
        super(new Vector2D(posX, posY), new Vector2D(0, 0), 0, false);
        width = Constants.width / 8;
        height = Constants.height / 10;
        centerPosX = ((int)position.x) - ((Constants.width / 10) * 4);
        centerPosY = ((int)position.y) - height / 2;
        this.text = text;
    }

    @Override
    public void update() {

    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.BLUE);
        g.drawRect(centerPosX, centerPosY, width, height);

        Font font = new Font("Serif", Font.PLAIN, 20);
        g.setFont(font);
        g.setColor(Color.YELLOW);
        g.drawString(text, centerPosX + 10, (int)position.y);
    }
}