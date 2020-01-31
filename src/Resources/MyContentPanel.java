package Resources;

import javax.swing.*;
import java.awt.*;

public class MyContentPanel extends JPanel {
    private Color bkColor = new Color(0,0,0,0);
    private int width, height;


    public MyContentPanel(int xSize, int ySize, Color backColor){
        super();
        bkColor = backColor;
        width = xSize;
        height = ySize;
        selfMake();
    }
    public MyContentPanel(int xSize, int ySize){
        super();
        width = xSize;
        height = ySize;
    }

    private void selfMake(){
        this.setSize(width, height);
        setBackground(bkColor);
    }
}
