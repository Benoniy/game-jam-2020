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
            case KeyEvent.VK_UP:
                if (action.downAllowed){action.down = true;}
                break;
            case KeyEvent.VK_LEFT:
                if (action.rightAllowed){action.right = true;}
                break;
            case KeyEvent.VK_RIGHT:
                if (action.leftAllowed){action.left = true;}
                break;
            case KeyEvent.VK_DOWN:
                if (action.upAllowed){action.up = true;}
                break;

        }
    }

    public void keyReleased(KeyEvent e) {
        // please add appropriate event handling code
        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_UP:
                action.down = false;
                break;
            case KeyEvent.VK_LEFT:
                action.right = false;
                break;
            case KeyEvent.VK_RIGHT:
                action.left = false;
                break;
            case KeyEvent.VK_DOWN:
                action.up = false;
                break;

        }
    }
}
