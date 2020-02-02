import Resources.Vector2D;

import java.awt.*;
import java.awt.geom.AffineTransform;

public class bigBlackSquare extends GameObject {
    private boolean end = false;
    Image texture = Sprites.back;
    AffineTransform spriteAffine;

    bigBlackSquare(boolean end){
        super(new Vector2D(0, 0), new Vector2D(0, 0), 0, false);
        this.end = end;
        genSpriteAffine();
    }

    @Override
    public void Interaction() {

    }

    @Override
    public void addoffset(int x, int y) {

    }

    private void genSpriteAffine(){
        double TxWidth = texture.getWidth(null);
        double TxHeight = texture.getHeight(null);
        double stretchX = (Constants.width/TxWidth);
        double stretchY = (Constants.height/TxHeight);
        spriteAffine = new AffineTransform();
        spriteAffine.scale(stretchX, stretchY);
    }

    @Override
    public void update() {

    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.BLACK);
        g.drawRect(0,0, Constants.width, Constants.height);

        AffineTransform at = g.getTransform();
        g.translate(position.x, position.y);
        g.drawImage(texture, this.spriteAffine, null);

        g.setTransform(at);

        if (end){

            Font font = new Font("Serif", Font.PLAIN, 40);
            g.setFont(font);
            g.setColor(Color.CYAN);
            g.drawString("Thank you for playing Some Assembly Required", Constants.width / 5 , (Constants.height / 2));
        }
    }
}
