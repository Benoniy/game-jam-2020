import Resources.MyButton;
import Resources.MyContentPanel;

import javax.swing.*;
import java.awt.*;

public class MyWindow extends JFrame {
    boolean gameRun = true;
    boolean paused = false;
    MyContentPanel mainPanel = new MyContentPanel(Constants.width, Constants.height);


    public MyWindow(){
        setTitle("");
        setMinimumSize(Constants.screenDimension);
        setMaximumSize(Constants.screenDimension);
        setPreferredSize(Constants.screenDimension);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(mainPanel);
        setVisible(true);
        run();
    }

    public void run(){
        gameRun = mainMenu();
        while (gameRun){
            try {
                Thread.sleep(33);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean mainMenu(){
        mainPanel.removeAll();
        mainPanel.setLayout(new GridLayout(4,1));

        MyButton startBut = new MyButton("Start");
        MyButton settingBut = new MyButton("Settings");
        MyButton helpBut = new MyButton("Help");
        MyButton quitBut = new MyButton("Exit");
        mainPanel.add(startBut);
        mainPanel.add(settingBut);
        mainPanel.add(helpBut);
        mainPanel.add(quitBut);

        mainPanel.repaint();
        mainPanel.revalidate();
        return true;
    }
}
