import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class configReader {
    //---[ Class Vars ]---
    public ArrayList objects;
    public ArrayList chestDoors;
    public ArrayList headDoors;
    public ArrayList armDoors;
    public ArrayList legDoors;

    // Read in the config file
    public configReader(String mapname) {
        objects = new ArrayList<>();
        chestDoors = new ArrayList<>();
        headDoors = new ArrayList<>();
        armDoors = new ArrayList<>();
        legDoors =  new ArrayList<>();
        readFile(mapname);
    }

    private ArrayList getCoords(String line) {
        ArrayList<Integer> coordPair = new ArrayList<>();
        String subStr = line.substring(line.indexOf("[") + 1, line.indexOf("]"));
        for(String x: subStr.split(",")) {
            coordPair.add(Integer.parseInt(x));
        }
        return coordPair;
    }

    private void readFile(String mapname) {
        try {
            // Read file in constructor?
            File f = new File("assets/maps/" + mapname + ".cfg");
            BufferedReader br = new BufferedReader(new FileReader(f));

            // Read Line-by-Line
            ArrayList doorList = chestDoors;
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println("Config: " + line);
                if (line.length() == 0) {
                    // prevent trying to get char @ 0 on empty lines as to not throw error
                    continue;
                }
                if (line.charAt(0) == 'C') {
                    // Get coordinates of Chest & Related Door pieces
                    doorList = chestDoors;
                    ArrayList<Integer> coords = getCoords(line);
                    objects.add(new ChestObject(coords.get(0), coords.get(1), chestDoors));
                } else if (line.charAt(0) == 'A') {
                    doorList = armDoors;
                    // Get coordinates of Chest
                    ArrayList<Integer> coords = getCoords(line);
                    objects.add(new ArmObject(coords.get(0), coords.get(1), armDoors));
                } else if (line.charAt(0) == 'H') {
                    doorList = headDoors;
                    // Get coordinates of Head
                    ArrayList<Integer> coords = getCoords(line);
                    objects.add(new HeadObject(coords.get(0), coords.get(1), headDoors));
                } else if (line.charAt(0) == 'L') {
                    doorList = legDoors;
                    // Get coordinates of Legs
                    ArrayList<Integer> coords = getCoords(line);
                    objects.add(new LegsObject(coords.get(0), coords.get(1), legDoors));
                } else if (line.charAt(0) == 'D') {
                    // Get coords of door piece (normal ways)
                    ArrayList<Integer> coords = getCoords(line);
                    DoorObject door = new DoorObject(coords.get(0), coords.get(1), Sprites.doormid, 0, true);
                    doorList.add(door);
                    objects.add(door);
                } else if (line.charAt(0) == 'd') {
                    // Get coords of door piece (sideways)
                    System.out.println("d: " + line);
                    ArrayList<Integer> coords = getCoords(line);
                    DoorObject door = new DoorObject(coords.get(0), coords.get(1), Sprites.doormid, 90, true);
                    doorList.add(door);
                    objects.add(door);
                }
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
