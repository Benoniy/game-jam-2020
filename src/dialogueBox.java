import Resources.Vector2D;

import java.awt.*;

public class dialogueBox extends GameObject {
    int currentY = 30;
    dialogueBox(){
        super(new Vector2D(0, Constants.height / 2), new Vector2D(0,0), 0, false);
    }

    @Override
    public void Interaction() {

    }

    @Override
    public void update() {

    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.WHITE);
        g.fillRect((int)position.x, (int)position.y, Constants.width, Constants.height/2);
        g.setColor(Color.BLACK);
        g.drawRect((int)position.x, (int)position.y, Constants.width, Constants.height/2);

        Font font = new Font("Serif", Font.PLAIN, 24);
        g.setFont(font);
        g.drawString("AAAA", 10 , currentY + (Constants.height / 2));
    }
}
