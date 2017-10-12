// eine erweitere Hamster-Klasse
import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;public class hamsterprogramm implements de.hamster.model.HamsterProgram {class LaufHamster extends Hamster {
    void drehDich(int drehungen) {
        while (drehungen > 0) {
            this.linksUm();
            drehungen = drehungen - 1;
        }
    }

    void rechtsUm() {
        this.drehDich(3);
    }

    boolean rechtsFrei() {
        this.rechtsUm();
        boolean ergebnis = this.vornFrei();
        this.linksUm();
        return ergebnis;
    }

    void laufe() {
        while (this.vornFrei()) {
            this.vor();
        }
    }
}

// noch eine erweiterte Hamster-Klasse
class SammelHamster extends Hamster {

    int gesammelteKoerner = 0;

    void sammle() {
        while (this.kornDa()) {
            this.nimm();
            this.gesammelteKoerner = this.gesammelteKoerner + 1;
        }
    }

    int getGesammelteKoerner() {
        return this.gesammelteKoerner;
    }
}

// Hauptprogramm
public void main() {
    // normaler Hamster
    Hamster paul = new Hamster(); // normaler Hamster
    paul.init(0, 1, Hamster.OST, 0);

    // erweiterter Hamster vom Typ LaufHamster
    LaufHamster willi = new LaufHamster();
    willi.init(6, 0, Hamster.OST, 0);

    // erweiterter Hamster vom Typ SammelHamster
    SammelHamster heidi = new SammelHamster();
    heidi.init(2, 0, Hamster.OST, 3);

    while (paul.vornFrei()) {
        paul.vor();
    }

    while (!willi.rechtsFrei()) {
        willi.vor();
    }
    willi.rechtsUm();
    willi.laufe();

    while (heidi.vornFrei()
            && heidi.getGesammelteKoerner() < 10) {
        heidi.sammle();
        heidi.vor();
    }
}}