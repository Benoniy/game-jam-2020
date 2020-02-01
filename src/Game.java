import Resources.Vector2D;

import java.util.ArrayList;
import java.util.List;

public class Game {
    public List<GameObject> objects;
    public Keys ctrl;
    public controlBlock CONTROL;

    Game(){
        objects = new ArrayList<>();
        ctrl = new Keys();
        CONTROL = new controlBlock(ctrl);
        objects.add(CONTROL);
        objects.add(new WallObject(1,1));
        objects.add(new Player());
    }

    public static void main(String[] args) {
        Game g = new Game();
        View v = new View(g);
        MyWindow win = new MyWindow(v);

        win.addKeyListener(g.ctrl);
        while (true){
            g.update();
            v.repaint();
            try {
                Thread.sleep(33);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void update(){
        for (GameObject o : objects){
            o.update();
        }
    }
}
