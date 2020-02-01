public class Game {
    Game(){

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
