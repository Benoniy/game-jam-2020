import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class dialogueReader {
    public String read(String dialogue) {
        try {
            // Read File
            File d = new File("assets/dialogue/" + dialogue + ".dia");
            BufferedReader bdr = new BufferedReader(new FileReader(d));

            // Return String
            StringBuilder toReturn = new StringBuilder();
            String line;

            while ((line = bdr.readLine()) != null) {
                if (line.charAt(0) == '#') {
                    // If comment
                    continue;
                }
                toReturn.append("\n").append(line);
            }
            return toReturn.toString();

        } catch (IOException e) {
            System.out.println("IOException in dialogue reader.");
            System.out.println(e);
            return "ERROR IN DIALOGUE READ";
        }
    }
}
