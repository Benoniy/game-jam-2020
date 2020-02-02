import Resources.Vector2D;

import java.awt.*;

public class bigBlackSquare extends GameObject {
    boolean end = false;
    public bigBlackSquare(boolean end){
        super(new Vector2D(0, 0), new Vector2D(0, 0), 0, false);
        this.end = end;
    }

    @Override
    public void Interaction() {

    }

    @Override
    public void addoffset(int x, int y) {

    }

    @Override
    public void update() {

    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.BLACK);
        g.drawRect(0,0, Constants.width, Constants.height);

        if (end){
            Font font = new Font("Serif", Font.PLAIN, 40);
            g.setFont(font);
            g.setColor(Color.WHITE);
            g.drawString("Thank you for playing Some Assembly Required", Constants.width / 5 , (Constants.height / 2));
        }
    }
}
