import Resources.Action;
import Resources.Controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Keys extends KeyAdapter implements Controller {
    private Action action;

    Keys() {
        action = new Action();

    }

    public Action action() {
        // this is defined to comply with the standard interface
        return action;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_A:
                if (Action.rightAllowed){
                    Action.right = true;
                }
                break;
            case KeyEvent.VK_S:
                if (Action.upAllowed){
                    Action.up = true;
                }
                break;
            case KeyEvent.VK_D:
                if (Action.leftAllowed){
                    Action.left = true;
                }
                break;
            case KeyEvent.VK_W:
                if (Action.downAllowed){
                    Action.down = true;
                }
                break;
        }
    }

    public void keyReleased(KeyEvent e) {
        // please add appropriate event handling code
        int key = e.getKeyCode();

        if (Constants.pause.equals("mm")){
            switch (key) {
                case KeyEvent.VK_UP:
                    if (Constants.pauseSelection > 1){
                        Constants.pauseSelection--;
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if (Constants.pauseSelection < 5){
                        Constants.pauseSelection++;
                    }
                    break;
                case KeyEvent.VK_ENTER:
                    if (Constants.pauseSelection == 1){
                        Constants.pause = "";
                    }
                    else if (Constants.pauseSelection == 2){
                        Constants.pause = "sm";
                    }
                    else if (Constants.pauseSelection == 3){

                    }
                    else {
                        System.exit(0);
                    }
                    break;
            }
        }
        else if (Constants.pause.equals("sm")){
            switch (key) {
                case KeyEvent.VK_UP:
                    if (Constants.pauseSelection > 1){
                        Constants.pauseSelection--;
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if (Constants.pauseSelection < 5){
                        Constants.pauseSelection++;
                    }
                    break;
                case KeyEvent.VK_ENTER:
                    if (Constants.pauseSelection == 1){
                        if (Constants.currentRes < 2){
                            Constants.currentRes ++;
                        }
                        else {
                            Constants.currentRes = 0;
                        }
                        System.out.println(Constants.currentRes);
                    }
                    else if (Constants.pauseSelection == 2){

                    }
                    else if (Constants.pauseSelection == 3){

                    }
                    else {
                        Constants.pause = "mm";
                        Constants.saveSettings();
                    }
                    break;
            }
        }
        else if (Constants.pause.equals("i")) {
            switch (key){
                case KeyEvent.VK_ENTER:
                    if (!Constants.currentDia.equals("four")){
                        Constants.pause = "";
                        Constants.Interacting = false;
                    }
                    else{
                        Constants.pause = "e";
                        Constants.Interacting = false;
                    }

                    break;
            }
        }
        else {
            switch (key) {
                case KeyEvent.VK_W:
                    Action.down = false;
                    break;
                case KeyEvent.VK_A:
                    Action.right = false;
                    break;
                case KeyEvent.VK_D:
                    Action.left = false;
                    break;
                case KeyEvent.VK_S:
                    Action.up = false;
                    break;
                case KeyEvent.VK_ENTER:
                    if (Constants.Interaction && !Constants.currentDia.equals("")){
                        Action.up = false;
                        Action.left = false;
                        Action.right = false;
                        Action.down = false;
                        Constants.pause = "i";
                    }
                    break;
            }
        }

    }
}
