import Resources.MyWindow;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;


public class Game {

    public List<GameObject> diaObjects;
    public List<GameObject> TEMPobjects;
    public Keys ctrl;
    public controlBlock CONTROL;
    public Player player;
    private static View v;

    Game(){
        Constants.objects = new ArrayList<>();
        Constants.REMOVEobjects = new ArrayList<>();
        TEMPobjects = new ArrayList<>();
        diaObjects = new ArrayList<>();
        ctrl = new Keys();
        Constants.offsetControl();
        CONTROL = new controlBlock(ctrl);
        Constants.objects.add(CONTROL);
        String mapname = "map";
        try {
            Constants.objects = readMap(Constants.objects, mapname);
        } catch (IOException e) {
            System.out.println("Couldn't find map image.");
        }
        configReader cr = new configReader(mapname);
        Constants.objects.addAll(cr.objects);
        player = new Player(CONTROL);
        Constants.objects.add(player);
    }

    public ArrayList readMap(List objects, String mapname) throws IOException {

        // Opens PNG file, reads pixel by pixel
        BufferedImage mapImage = null;
        mapImage = ImageIO.read(new File("assets/maps/" + mapname + ".png"));
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
                        pixelArray[x][y] != -65536 &&
                        pixelArray[x][y] != -9087) {
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
                    objects.add(new DoorObject(x - cbX, y - cbY, Sprites.doorbroke, 180, false));
                }
                else if (pixelArray[x][y] == -9087) {
                    // broken door part
                    objects.add(new FloorObject(x - cbX, y - cbY));
                    objects.add(new DoorObject(x - cbX, y - cbY, Sprites.doorbroke, 0, false));
                }
                else if (pixelArray[x][y] == -6218463) {
                    // Barrel
                    objects.add(new FloorObject(x - cbX, y - cbY));
                    objects.add(new BarrelObject(x - cbX, y - cbY, 0));
                }
                else if (pixelArray[x][y] == -1){
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

        //SoundManager.playBackgroundMusic();
        while (true){
            g.update();
            v.repaint();
            try {
                Thread.sleep(18);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void genMainMenu(){
        if (TEMPobjects.isEmpty()){
            TEMPobjects.addAll(Constants.objects);
        }

        Constants.objects.clear();
        bigBlackSquare back = new bigBlackSquare(false);
        MenuButton Start = new MenuButton(Constants.width / 2,  Constants.height / 2 - 100, "Start");
        MenuButton Settings = new MenuButton(Constants.width / 2,  Constants.height / 2, "Settings");
        MenuButton Help = new MenuButton(Constants.width / 2,  Constants.height / 2 + 100, "Help");
        MenuButton Exit = new MenuButton(Constants.width / 2,  Constants.height / 2 + 200, "Exit");
        Constants.objects.add(back);
        Constants.objects.add(Start);
        Constants.objects.add(Settings);
        Constants.objects.add(Help);
        Constants.objects.add(Exit);

        MenuSelector selector = new MenuSelector(Start.centerPosX, Start.centerPosY);
        Constants.objects.add(selector);

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
        if (Constants.pause.equals("sm")){genSettingsMenu();}
    }

    public void genSettingsMenu(){
        System.out.println("SETTINGS");
        Constants.objects.clear();
        bigBlackSquare back = new bigBlackSquare(false);
        MenuButton Res = new MenuButton(Constants.width / 2,  Constants.height / 2 - 100, "Resolution: " + Constants.allowedRes.get(Constants.currentRes));
        MenuButton Settings = new MenuButton(Constants.width / 2,  Constants.height / 2, "PlaceHolder");
        MenuButton Help = new MenuButton(Constants.width / 2,  Constants.height / 2 + 100, "PlaceHolder");
        MenuButton Back = new MenuButton(Constants.width / 2,  Constants.height / 2 + 200, "Back");
        Constants.objects.add(back);
        Constants.objects.add(Res);
        Constants.objects.add(Settings);
        Constants.objects.add(Help);
        Constants.objects.add(Back);

        MenuSelector selector = new MenuSelector(Res.centerPosX, Res.centerPosY);
        Constants.objects.add(selector);

        while (Constants.pause.equals("sm")){
            Res.changeText("Resolution: " + Constants.allowedRes.get(Constants.currentRes));
            v.repaint();
            if (Constants.pauseSelection == 1){
                selector.moveSelector(Res.centerPosX, Res.centerPosY);
            }
            else if (Constants.pauseSelection == 2){
                selector.moveSelector(Settings.centerPosX, Settings.centerPosY);
            }
            else if (Constants.pauseSelection == 3){
                selector.moveSelector(Help.centerPosX, Help.centerPosY);
            }
            else {
                selector.moveSelector(Back.centerPosX, Back.centerPosY);
            }
        }

        genMainMenu();
    }

    public void genDialogue(){
        dialogueBox d = new dialogueBox();
        diaObjects.add(d);
        while (Constants.Interacting){
            v.repaint();
        }
        diaObjects.clear();
    }

    public void genEnd(){

        TEMPobjects.addAll(Constants.objects);
        Constants.objects.clear();
        bigBlackSquare back = new bigBlackSquare(true);
        Constants.objects.add(back);

        while (Constants.pause.equals("e")){
            v.repaint();
        }
    }

    public void update(){
        if (Constants.pause.equals("e")){
            genEnd();
        }

        if (Constants.pause.equals("mm")){
            genMainMenu();
            Constants.objects.clear();
            Constants.objects.addAll(TEMPobjects);
            TEMPobjects.clear();
        }

        if (Constants.pause.equals("i")){
            genDialogue();
        }

        Constants.current = System.currentTimeMillis();

        if (Constants.last == -1){
            Constants.last = System.currentTimeMillis();
            Constants.current = System.currentTimeMillis();
        }

        if (Constants.current - Constants.last > Constants.animationRate){
            Constants.ANIMATION_FRAME = !Constants.ANIMATION_FRAME;
            Constants.last = System.currentTimeMillis();
        }

        int skipAmount = 0;
        int counter = 0;
        if (!Constants.REMOVEobjects.isEmpty()){
            Constants.objects.removeAll(Constants.REMOVEobjects);
            Constants.REMOVEobjects.clear();
        }
        for (GameObject o : Constants.objects) {
            if (o.getClass() != Player.class){
                player.collisionHandling(o);
            }


            //Single object checks
            o.update();
        }
    }
}
