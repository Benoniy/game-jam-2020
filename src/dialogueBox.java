import Resources.Vector2D;

import java.awt.*;

public class dialogueBox extends GameObject {
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
    }
}
