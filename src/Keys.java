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
                action.Ymov = -1;
                break;
            case KeyEvent.VK_LEFT:
                action.Xmov = -1;
                break;
            case KeyEvent.VK_RIGHT:
                action.Xmov = 1;
                break;
            case KeyEvent.VK_DOWN:
                action.Ymov = 1;
                break;

        }
    }

    public void keyReleased(KeyEvent e) {
        // please add appropriate event handling code
        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_UP:
                action.Ymov = 0;
                break;
            case KeyEvent.VK_DOWN:
                action.Ymov = 0;
                break;
            case KeyEvent.VK_LEFT:
                action.Xmov = 0;
                break;
            case KeyEvent.VK_RIGHT:
                action.Xmov = 0;
                break;

        }
    }
}
