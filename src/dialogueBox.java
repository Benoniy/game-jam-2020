import Resources.Vector2D;

import java.awt.*;

public class dialogueBox extends GameObject {
    int currentY = 50;
    String name;
    String[] text;
    dialogueBox(){
        super(new Vector2D(0, Constants.height / 2), new Vector2D(0,0), 0, false);
        dialogueReader d = new dialogueReader();
        String[] args = d.read(Constants.currentDia).split(":");
        this.text = args[1].split("\n");
        this.name = args[0];
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
        g.setColor(Color.WHITE);
        g.fillRect((int)position.x, (int)position.y, Constants.width, Constants.height/2);
        g.setColor(Color.BLACK);
        g.drawRect((int)position.x, (int)position.y, Constants.width, Constants.height/2);

        Font font = new Font("Serif", Font.PLAIN, 30);
        g.setFont(font);
        g.drawString(name, 30 , currentY + (Constants.height / 2));
        currentY += 50;

        font = new Font("Serif", Font.PLAIN, 24);
        g.setFont(font);

        for (String s : text){
            g.drawString(s, 30 , currentY + (Constants.height / 2));
            currentY += 30;
        }


        currentY = 30;
    }
}
