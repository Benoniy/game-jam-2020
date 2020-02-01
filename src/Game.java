import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Game {
    public List<GameObject> objects;
    public Keys ctrl;
    public controlBlock CONTROL;
    public Player player;

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
        player = new Player(CONTROL);
        objects.add(player);
    }

    public ArrayList readMap(List objects) throws IOException {

        // Opens PNG file, reads pixel by pixel
        BufferedImage mapImage = null;
        mapImage = ImageIO.read(new File("assets/map.png"));
        // RGB values of pixels are all merged into one
        System.out.println(mapImage);
        int[][] pixelArray = new int[mapImage.getWidth()][mapImage.getHeight()];
        for (int w = 0; w < mapImage.getWidth(); w++) {
            for (int h = 0; h < mapImage.getHeight(); h++) {
                pixelArray[w][h] = mapImage.getRGB(w, h);
            }
        }
        // Find Control Block
        int cbX = 0;
        int cbY = 0;
        for (int x = 0; x < pixelArray.length; x++) {
            for (int y = 0; y < pixelArray[x].length; y++) {
                if (pixelArray[x][y] == -65536) {
                    // Control Block Coordinates
                    cbX = x;
                    cbY = y;
                }
            }
        }
        // Find Remaining Objects
        for (int x = 0; x < pixelArray.length; x++) {
            for (int y = 0; y < pixelArray[x].length; y++) {
                if (pixelArray[x][y] != -1 && pixelArray[x][y] != -16777216 && pixelArray[x][y] != -16765620 && pixelArray[x][y] != -12961222 &&
                        pixelArray[x][y] != -3859094 && pixelArray[x][y] != -10446270 && pixelArray[x][y] != -5347032) {
                    System.out.println("Original Coord: (" + x + ", " + y + ") translated: (" + (x -cbX) + ", " + (y - cbY) + ") Color: " + pixelArray[x][y]);
                }
                if (pixelArray[x][y] == -16777216) {
                    // Horizontal Wall Object
                    objects.add(new WallObject(x - cbX, y - cbY, Sprites.WallMid));
                }
                else if (pixelArray[x][y] == -12961222) {
                    // Vertical Wall
                    objects.add(new WallObject(x - cbX, y - cbY, Sprites.WallMid));
                }
                else if (pixelArray[x][y] == -65536) {
                    //  Control Block
                    objects.add(new WallObject(x - cbX, y -cbY, Sprites.Wall1));
                }
                else if (pixelArray[x][y] == -16776961) {
                    // Arm
                    objects.add(new CrateObject(x - cbX, y - cbY));
                }
                else if (pixelArray[x][y] == -16715168) {
                    // Legs
                    objects.add(new CrateObject(x - cbX, y - cbY));
                }
                else if (pixelArray[x][y] == -15603) {
                    // Chest
                    objects.add(new CrateObject(x - cbX, y - cbY));
                }
                else if (pixelArray[x][y] == -16765620) {
                    // Up-Facing Wall End
                    objects.add(new WallObject(x - cbX, y - cbY, Sprites.WallEnd));
                }
                else if (pixelArray[x][y] == -3859094) {
                    // Down-Facing Wall End
                    objects.add(new WallObject(x - cbX, y - cbY, Sprites.WallEnd));
                }
                else if (pixelArray[x][y] == -10446270) {
                    // Left-Facing Wall End
                    objects.add(new WallObject(x - cbX, y - cbY, Sprites.WallEnd));
                }
                else if (pixelArray[x][y] == -5347032) {
                    // Right-Facing Wall End
                    objects.add(new WallObject(x - cbX, y - cbY, Sprites.WallEnd));
                }
                else {
                    // Else add floor
                    objects.add(new FloorObject(x - cbX, y - cbY));
                }
            }
        }
    return (ArrayList) objects;
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
        int skipAmount = 0;
        int counter = 0;
        for (GameObject o : objects) {
            if (o.getClass() != Player.class){
                player.collisionHandling(o);
            }


            //Single object checks
            o.update();
        }
    }
}
