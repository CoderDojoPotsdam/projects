import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;public class beispiel implements de.hamster.model.HamsterProgram {class DrehHamster extends Hamster {
    DrehHamster(int r, int s, int b, int k) {
        super(r, s, b, k);
    }

    void rechtsUm() {
        this.kehrt();
        this.linksUm();
    }

    void kehrt() {
        this.linksUm();
        this.linksUm();
    }
}

class NachfrageHamster extends DrehHamster {
    NachfrageHamster(int r, int s, int b, int k) {
        super(r, s, b, k);
    }

    void kehrt() {
        String antwort = this
                .liesZeichenkette("Soll ich mich wirklich "
                        + "umdrehen (ja/nein)?");
        if (antwort.equals("ja")) {
            super.kehrt();
        }
    }
}

public void main() {
    DrehHamster paul = new DrehHamster(0, 0, Hamster.OST, 0);
    paul.rechtsUm(); // Hamster dreht sich
    paul = new NachfrageHamster(0, 0, Hamster.OST, 0);
    paul.rechtsUm(); // Hamster fragt nach
}}