import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;public class hamsterprogramm implements de.hamster.model.HamsterProgram {class MaulIstLeerException extends Exception {
}

class KachelIstLeerException extends Exception {
}

class MeinHamster extends Hamster {

    MeinHamster(int r, int s, int b, int k) {
        super(r, s, b, k);
    }

    void kehrt() {
        this.linksUm();
        this.linksUm();
    }

    void nimm(int anzahl) throws KachelIstLeerException {
        while (anzahl > 0) {
            if (!this.kornDa()) {
                throw new KachelIstLeerException();
            }
            this.nimm();
            anzahl = anzahl - 1;
        }
    }

    void gib(int anzahl) throws MaulIstLeerException {
        while (anzahl > 0) {
            if (this.maulLeer()) {
                throw new MaulIstLeerException();
            }
            this.gib();
            anzahl = anzahl - 1;
        }
    }

    void laufeTuWasUndZurueck(int anzahl)
            throws MaulIstLeerException {
        int schritte = 0;
        try {
            boolean gerade = true;
            while (this.vornFrei()) {
                if (gerade) {
                    this.nimm(anzahl);
                } else {
                    this.gib(2 * anzahl);
                }
                gerade = !gerade;
                this.vor();
                schritte = schritte + 1;
            }
        } catch (KachelIstLeerException exc) {
            this.kehrt();
            this.kehrt();
            return;
        } finally {
            this.kehrt();
            while (schritte > 0) {
                this.vor();
                schritte = schritte - 1;
            }
            this.kehrt();
        }
        this.schreib("Aufgabe vollstaendig erledigt!");
    }
}

public void main() {
    MeinHamster paul = new MeinHamster(3, 5, Hamster.OST, 5);
    try {
        int anzahl = paul.liesZahl("Koerner: ");
        paul.laufeTuWasUndZurueck(anzahl);
    } catch (MaulIstLeerException exc) {
        // egal
    }
}}