import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;

import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;public class sound implements de.hamster.model.HamsterProgram {class SoundHamster extends AllroundHamster {

    private AudioClip audioClip;

    public SoundHamster(int r, int s, int b, int k,
            String soundDatei) {
        super(r, s, b, k);
        try {
            File f = new File(soundDatei);
            this.audioClip = Applet.newAudioClip(f.toURI()
                    .toURL());
        } catch (Exception exc) {
            this.audioClip = null;
        }
    }

    public void startSound() {
        if (this.audioClip != null) {
            this.audioClip.play();
        }
    }

    public void stopSound() {
        if (this.audioClip != null) {
            this.audioClip.stop();
        }
    }

    public void loopSound() {
        if (this.audioClip != null) {
            this.audioClip.loop();
        }
    }
}

public void main() {
    SoundHamster paul = new SoundHamster(0, 0, Hamster.OST,
            0, "C:\\sounds\\musik.wav");
    paul.loopSound();  // Starte Hintergrundmusik
	
    paul.nimmAlle();
    while (paul.vornFrei()) {
        paul.vor();
        paul.nimmAlle();
    }
}}