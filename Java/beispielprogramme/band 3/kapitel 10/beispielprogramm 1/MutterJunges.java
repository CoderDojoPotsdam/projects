/*
 Windows:
 CLASSPATH: .;Programme\beispielprogramme\band 3
 Linux, Solaris:
 CLASSPATH: .:Programme/beispielprogramme/band 3
*/
import util.AllroundHamster;

import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;public class MutterJunges implements de.hamster.model.HamsterProgram {class Junges extends Hamster {

    private int erschoepfung;

    private final int MAX_ERSCHOEPFUNG = 10;

    Junges() {
        super(0, 0, Hamster.OST, 0);
        this.erschoepfung = 0;
    }

    public void run() {

        Object nest = Territorium.getKachel(this.getReihe(),
                this.getSpalte());
        // Erschoepfungstod oder Selbstmord :-(
        while (this.erschoepfung < this.MAX_ERSCHOEPFUNG
                && !Thread.interrupted()) {
            synchronized (nest) {
                try {
                    nest.wait(1000);
                    if (this.kornDa()) {
                        this.nimm();
                    }
                } catch (InterruptedException exc) {
                    this.interrupt();
                }
            }
        }

        // Ende
        if (this.erschoepfung >= this.MAX_ERSCHOEPFUNG) {
            this.schreib("Erschoepfungstod");
        } else {
            this.schreib("Selbstmord, kein Futter mehr da :-(");
        }
    }

    public boolean kornDa() {
        this.erschoepfung++;
        return super.kornDa();
    }

    public void nimm() {
        this.erschoepfung -= 5;
        super.nimm();
    }
}

class Mutter extends AllroundHamster {

    private Junges baby;

    Mutter() {
        super(0, 0, Hamster.OST, 0);
        this.baby = new Junges();
        this.baby.start();
    }

    public void run() {
        boolean kornGefunden = this.sucheKorn();
        while (kornGefunden && this.baby.isAlive()) {
            Object nest = Territorium.getKachel(this.baby
                    .getReihe(), this.baby.getSpalte());
            synchronized (nest) {
                this.gib();
                nest.notify();
            }
            kornGefunden = this.sucheKorn();
        }

        if (!kornGefunden) {

            // sorry, Baby wird in den Selbstmord getrieben
            this.baby.interrupt();
        }
    }

    boolean sucheKorn() {
        this.setzeBlickrichtung(Hamster.OST);
        while (this.vornFrei()) {
            this.vor();
            if (this.kornDa()) {
                this.nimm();
                this.laufeZuKachel(0, 0);
                return true;
            }
        }
        this.laufeZuKachel(0, 0);
        return false;
    }
}

public void main() {
    (new Mutter()).start();
}}