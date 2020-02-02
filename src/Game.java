import Resources.MyWindow;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Game {
    public List<GameObject> objects;
    public List<GameObject> TEMPobjects;
    public Keys ctrl;
    public controlBlock CONTROL;
    public Player player;
    private static View v;

    Game(){
        objects = new ArrayList<>();
        TEMPobjects = new ArrayList<>();
        ctrl = new Keys();
        Constants.offsetControl(4,1);
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
        mapImage = ImageIO.read(new File("assets/images/map.png"));
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
                if (pixelArray[x][y] != -1 && pixelArray[x][y] != -16777216 &&
                        pixelArray[x][y] != -16765620 &&
                        pixelArray[x][y] != -12961222 &&
                        pixelArray[x][y] != -3859094 &&
                        pixelArray[x][y] != -10446270 &&
                        pixelArray[x][y] != -5347032 &&
                        pixelArray[x][y] != -7947291 &&
                        pixelArray[x][y] != -6282368 &&
                        pixelArray[x][y] != -16776961 &&
                        pixelArray[x][y] != -16715168 &&
                        pixelArray[x][y] != -15603 &&
                        pixelArray[x][y] != -7947291 &&
                        pixelArray[x][y] != -754905 &&
                        pixelArray[x][y] != -1237980 &&
                        pixelArray[x][y] != -16731413 &&
                        pixelArray[x][y] != -65536) {
                    System.out.println("Original Coord: (" + x + ", " + y + ") translated: (" + (x -cbX) + ", " + (y - cbY) + ") Color: " + pixelArray[x][y]);
                }
                if (pixelArray[x][y] == -16777216) {
                    // Horizontal Wall Object
                    objects.add(new WallObject(x - cbX, y - cbY, Sprites.WallMid, 90));
                }
                else if (pixelArray[x][y] == -12961222) {
                    // Vertical Wall
                    objects.add(new WallObject(x - cbX, y - cbY, Sprites.WallMid, 0));
                }
                else if (pixelArray[x][y] == -6282368) {
                    // Boxes
                    int angle;
                    int randNum = ThreadLocalRandom.current().nextInt(0, 3);
                    if (randNum == 0) {
                        angle = 90;
                    }
                    else if (randNum == 1) {
                        angle = 180;
                    }
                    else if (randNum == 2) {
                        angle = 270;
                    } else {
                        angle = 0;
                    }
                    objects.add(new CrateObject(x - cbX, y - cbY, angle));
                }
                else if (pixelArray[x][y] == -65536) {
                    //  Control Block
                    // objects.add(new WallObject(x - cbX, y -cbY, Sprites.Wall1, 0));
                }
                /*
                else if (pixelArray[x][y] == -16776961) {
                    // Arm
                    objects.add(new ArmObject(x - cbX, y - cbY));
                }
                else if (pixelArray[x][y] == -16715168) {
                    // Legs
                    objects.add(new LegsObject(x - cbX, y - cbY));
                }
                else if (pixelArray[x][y] == -15603) {
                    // Chest
                    objects.add(new ChestObject(x - cbX, y - cbY));
                }
                else if (pixelArray[x][y] == -7947291) {
                    // Head
                    objects.add(new HeadObject(x - cbX, y - cbY));
                }
                 */
                else if (pixelArray[x][y] == -16765620) {
                    // Up-Facing Wall End
                    objects.add(new WallObject(x - cbX, y - cbY, Sprites.WallEnd, 180));
                }
                else if (pixelArray[x][y] == -3859094) {
                    // Down-Facing Wall End
                    objects.add(new WallObject(x - cbX, y - cbY, Sprites.WallEnd, 0));
                }
                else if (pixelArray[x][y] == -10446270) {
                    // Left-Facing Wall End
                    objects.add(new WallObject(x - cbX, y - cbY, Sprites.WallEnd, 90));
                }
                else if (pixelArray[x][y] == -5347032) {
                    // Right-Facing Wall End
                    objects.add(new WallObject(x - cbX, y - cbY, Sprites.WallEnd, 270));
                }
                else if (pixelArray[x][y] == -13020378) {
                    // Top-Right Wall Corner
                    objects.add(new WallObject(x - cbX, y - cbY, Sprites.WallCor, 90));
                }
                else if (pixelArray[x][y] == -16761313) {
                    // Top-Left Wall Corner
                    objects.add(new WallObject(x - cbX, y - cbY, Sprites.WallCor, 0));
                }
                else if (pixelArray[x][y] == -10109071) {
                    // Bottom Right Wall Corner
                    objects.add(new WallObject(x - cbX, y - cbY, Sprites.WallCor, 180));
                }
                else if (pixelArray[x][y] == -16751540) {
                    // Bottom Left Wall Corner
                    objects.add(new WallObject(x - cbX, y - cbY, Sprites.WallCor, 270));
                }
                else if (pixelArray[x][y] == -754905) {
                    // Left Facing T-Junct.
                    objects.add(new WallObject(x - cbX, y - cbY, Sprites.Wall1, 0));
                }
                else if (pixelArray[x][y] == -1237980) {
                    // Right Facing T-Junct.
                    objects.add(new WallObject(x - cbX, y - cbY, Sprites.Wall1, 0));
                }
                else if (pixelArray[x][y] == -10351811) {
                    // Up Facing T-Junct.
                    objects.add(new WallObject(x - cbX, y - cbY, Sprites.Wall1, 0));
                }
                else if (pixelArray[x][y] == -14507) {
                    // broken door part
                    objects.add(new FloorObject(x - cbX, y - cbY));
                    objects.add(new DoorObject(x - cbX, y - cbY, Sprites.doorbroke, 180));
                }
                else if (pixelArray[x][y] == -9087) {
                    // broken door part
                    objects.add(new FloorObject(x - cbX, y - cbY));
                    objects.add(new DoorObject(x - cbX, y - cbY, Sprites.doorbroke, 0));
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
        Constants.loadSettings();
        Game g = new Game();
        v = new View(g);
        MyWindow win = new MyWindow(v);

        win.addKeyListener(g.ctrl);
        SoundManager.playBackgroundMusic();
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

    public void genMainMenu(){
        TEMPobjects.addAll(objects);
        objects.clear();
        bigBlackSquare back = new bigBlackSquare();
        MenuButton Start = new MenuButton(Constants.width / 2,  Constants.height / 2 - 100, "Start");
        MenuButton Settings = new MenuButton(Constants.width / 2,  Constants.height / 2, "Settings");
        MenuButton Help = new MenuButton(Constants.width / 2,  Constants.height / 2 + 100, "Help");
        MenuButton Exit = new MenuButton(Constants.width / 2,  Constants.height / 2 + 200, "Exit");
        objects.add(back);
        objects.add(Start);
        objects.add(Settings);
        objects.add(Help);
        objects.add(Exit);

        MenuSelector selector = new MenuSelector(Start.centerPosX, Start.centerPosY);
        objects.add(selector);

        while (Constants.pause.equals("mm")){
            v.repaint();
            if (Constants.pauseSelection == 1){
                selector.moveSelector(Start.centerPosX, Start.centerPosY);
            }
            else if (Constants.pauseSelection == 2){
                selector.moveSelector(Settings.centerPosX, Settings.centerPosY);
            }
            else if (Constants.pauseSelection == 3){
                selector.moveSelector(Help.centerPosX, Help.centerPosY);
            }
            else {
                selector.moveSelector(Exit.centerPosX, Exit.centerPosY);
            }
        }

        objects.clear();
        objects.addAll(TEMPobjects);
        TEMPobjects.clear();
    }

    public void update(){
        if (Constants.pause.equals("mm")){
            genMainMenu();
        }


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
