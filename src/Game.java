import Resources.Vector2D;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.io.IOException;
import java.net.URL;
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
        //objects.add(new WallObject(1,1));
        try {
            objects = readMap(objects);
        } catch (IOException e) {
            System.out.println("Couldn't find map image.");
        }
        objects.add(new Player());
    }

    public ArrayList readMap(List objects) throws IOException {

        // Opens PNG file, reads pixel by pixel
        BufferedImage mapImage = null;
        mapImage = ImageIO.read(new File("assets/maptest.png"));
        // RGB values of pixels are all merged into one
        System.out.println(mapImage);
        int[][] pixelArray = new int[mapImage.getWidth()][mapImage.getHeight()];
        for (int w = 0; w < mapImage.getWidth(); w++) {
            for (int h = 0; h < mapImage.getHeight(); h++) {
                pixelArray[w][h] = mapImage.getRGB(w, h);
                System.out.println(w + " " + h + " " + mapImage.getRGB(w, h));
            }
        }
        // Wall value = -16776961
        // Control Block value = -65536

        // Find Control Block
        int cbX = 0;
        int cbY = 0;
        for (int x = 0; x < pixelArray.length; x++) {
            for (int y = 0; y < pixelArray[x].length; y++) {
                if (pixelArray[x][y] == -65536) {
                    // Control Block Coord!
                    cbX = x;
                    cbY = y;
                }
            }
        }

        // Find Remaining Objects
        for (int x = 0; x < pixelArray.length; x++) {
            for (int y = 0; y < pixelArray[x].length; y++) {
                if (pixelArray[x][x] == -16776961) {
                    // Wall Object
                    objects.add(new WallObject(x - cbX, y - cbY));
                }
            }
        }
    return (ArrayList) objects;
    }

    public static void main(String[] args) {
        //readMap();
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
