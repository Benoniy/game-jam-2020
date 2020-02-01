import Resources.Vector2D;

import java.util.ArrayList;
import java.util.List;

public class Game {
    public List<GameObject> objects;
    public controlBlock CONTROL = new controlBlock();

    Game(){
        objects = new ArrayList<>();
        objects.add(CONTROL);
        objects.add(new WallObject(1,1));
    }

    public static void main(String[] args) {
        Game g = new Game();
        View v = new View(g);
        MyWindow win = new MyWindow(v);

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

    }
}
