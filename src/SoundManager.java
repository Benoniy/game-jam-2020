// change package name to fit your own package structure!

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

// SoundManager for Asteroids

public class SoundManager {

    static int nBullet = 0;
    static boolean thrusting = false;

    // this may need modifying
    final static String path = "assets/sound/";

    // note: having too many clips open may cause
    // "LineUnavailableException: No Free Voices"

    public final static Clip testClip = getClip("sneaky-snitch-by-kevin-macleod");

    public final static Clip[] clips = {testClip};

    public static void main(String[] args) throws Exception {
        for (Clip clip : clips) {
            play(clip);
            Thread.sleep(1000);
        }
    }

    // methods which do not modify any fields

    public static void play(Clip clip) {
        clip.setFramePosition(0);
        clip.start();
    }

    private static Clip getClip(String filename) {
        Clip clip = null;
        try {
            clip = AudioSystem.getClip();
            AudioInputStream sample = AudioSystem.getAudioInputStream(new File(path
                    + filename + ".wav"));
            clip.open(sample);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return clip;
    }
    // Custom methods playing a particular sound
    // Please add your own methods below

    public static void playBackgroundMusic(){
        if (Constants.backMusic){
            play(testClip);
        }
    }

}