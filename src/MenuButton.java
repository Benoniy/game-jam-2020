import Resources.Vector2D;

import java.awt.*;

public class MenuButton extends GameObject {
    int width, height, centerPosX, centerPosY;
    String text;

    public MenuButton(double posX, double posY, String text){
        super(new Vector2D(posX, posY), new Vector2D(0, 0), 0, false);
        width = Constants.width / 6;
        height = Constants.height / 14;
        centerPosX = ((int)position.x) - ((Constants.width / 10) * 4);
        centerPosY = ((int)position.y) - height / 2;
        this.text = text;
    }

    public void changeText(String text){
        this.text = text;
    }

    @Override
    public void Interaction() {}

    @Override
    public void addoffset(int x, int y) {

    }

    @Override
    public void update() {

    }

    @Override
    public void draw(Graphics2D g) {


        g.setColor(Color.CYAN);
        g.fillRect(centerPosX, centerPosY, width, height);

        g.setColor(Color.BLACK);
        g.drawRect(centerPosX, centerPosY, width, height);

        Font font = new Font("Serif", Font.PLAIN, 20);
        g.setFont(font);
        g.setColor(Color.BLACK);
        g.drawString(text, centerPosX + 10, (int)position.y);
    }
}
