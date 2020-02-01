import Resources.Vector2D;

import java.util.ArrayList;
import java.util.List;

public class Game {
    public List<GameObject> objects;
    Game(){
        objects = new ArrayList<>();
        objects.add(new EnviroObject(0,0, 16, false));
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
