import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;

/**
* reference: https://stackoverflow.com/a/6700039 - Plays a beep sound.
* @author mbk
* @version 1
*/
public class Beep {
    private static final float SAMPLERATE = 44100f;

    /**
    * method to play a beep sound.
    */
    public static void beep(int secs) {
        try {
            tone(1000, secs, 1.0);
        } catch (LineUnavailableException e) {
            System.err.println("Beep unavailable");
        }
    }

    /**
    * Function to play a tone using the AudioSystem.
    * @param hz The hertz on the tone
    * @param msecs The duration in milliseconds
    * @param vol The volume (loudness) of the tone
    */
    private static void tone(int hz, int msecs, double vol)
        throws LineUnavailableException {

        byte[] buf = new byte[1];
        AudioFormat af =
            new AudioFormat(
                SAMPLERATE, // sampleRate
                8,           // sampleSizeInBits
                1,           // channels
                true,        // signed
                false);      // bigEndian
        SourceDataLine sdl = AudioSystem.getSourceDataLine(af);
        sdl.open(af);
        sdl.start();
        for (int i = 0; i < msecs * (int)SAMPLERATE / 1000; i++) {
            double angle = i / (SAMPLERATE / hz) * 2.0 * Math.PI;
            buf[0] = (byte) (Math.sin(angle) * 127.0 * vol);
            sdl.write(buf, 0, 1);
        }
        sdl.drain();
        sdl.stop();
        sdl.close();
    }
}
