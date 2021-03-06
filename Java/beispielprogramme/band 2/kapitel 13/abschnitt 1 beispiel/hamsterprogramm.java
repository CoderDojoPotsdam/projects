import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;public class hamsterprogramm implements de.hamster.model.HamsterProgram {class MauerIstDaException extends Exception {
}

class KachelIstLeerException extends Exception {
}

class MaulIstLeerException extends Exception {
}

class VorsichtigerHamster extends Hamster {
    VorsichtigerHamster(int r, int s, int b, int k) {
        super(r, s, b, k);
    }

    VorsichtigerHamster(Hamster hamster) {
        super(hamster);
    }

    void vorsichtigesVor() throws MauerIstDaException {
        if (this.vornFrei()) {
            this.vor();
        } else {
            throw new MauerIstDaException();
        }
    }

    void vorsichtigesNimm() throws KachelIstLeerException {
        if (this.kornDa()) {
            this.nimm();
        } else {
            throw new KachelIstLeerException();
        }
    }

    void vorsichtigesGib() throws MaulIstLeerException {
        if (!this.maulLeer()) {
            this.gib();
        } else {
            throw new MaulIstLeerException();
        }
    }
}

public void main() {
    VorsichtigerHamster paul = new VorsichtigerHamster(
            Hamster.getStandardHamster());
    try {
        int anzahl = 0;
        paul.vorsichtigesNimm(); // Exception moeglich
        while (paul.vornFrei()) {
            paul.vor();
            anzahl++;
            paul.vorsichtigesNimm(); // Exception moeglich
        }

        paul.linksUm();
        paul.linksUm();

        while (anzahl > 0) {
            paul.vor();
            anzahl--;
        }

        while (!paul.maulLeer()) {
            paul.gib();
        }
    } catch (KachelIstLeerException fehlerObjekt) {
        paul.schreib("Ich streike!");
    }
}}