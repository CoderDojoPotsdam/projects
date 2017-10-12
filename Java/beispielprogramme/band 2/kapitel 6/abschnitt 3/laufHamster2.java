import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;public class laufHamster2 implements de.hamster.model.HamsterProgram {class LaufHamster2 extends Hamster {

    int maximaleSchritte;

    int schritte = 0;

    void setMaximaleSchritte(int anzahl) {
        this.maximaleSchritte = anzahl;
    }

    void lauf() {
        if (this.schritte < this.maximaleSchritte
                && this.vornFrei()) {
            this.vor();
            schritte = schritte + 1;
        }
    }
}

public void main() {
    LaufHamster2 paul = new LaufHamster2();
    paul.init(0, 0, Hamster.OST, 0);
    paul.setMaximaleSchritte(9);
    while (paul.vornFrei()) {
        paul.lauf();
    }

    Hamster heidi = Hamster.getStandardHamster();

    LaufHamster2 willi = new LaufHamster2();
    willi.init(2, 0, Hamster.OST, 0);
    willi.setMaximaleSchritte(heidi.getAnzahlKoerner());
    while (willi.vornFrei()) {
        willi.lauf();
    }
}
}