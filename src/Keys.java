import Resources.Action;
import Resources.Controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Keys extends KeyAdapter implements Controller {
    Action action;

    public Keys() {
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
                if (action.rightAllowed){
                    action.right = true;
                }
                break;
            case KeyEvent.VK_S:
                if (action.upAllowed){
                    action.up = true;
                }
                break;
            case KeyEvent.VK_D:
                if (action.leftAllowed){
                    action.left = true;
                }
                break;
            case KeyEvent.VK_W:
                if (action.downAllowed){
                    action.down = true;
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
                    action.down = false;
                    break;
                case KeyEvent.VK_A:
                    action.right = false;
                    break;
                case KeyEvent.VK_D:
                    action.left = false;
                    break;
                case KeyEvent.VK_S:
                    action.up = false;
                    break;
                case KeyEvent.VK_E:
                    if (Constants.Interaction && !Constants.currentDia.equals("")){
                        action.up = false;
                        action.left = false;
                        action.right = false;
                        action.down = false;
                        Constants.pause = "i";
                    }
                    break;
            }
        }

    }
}
