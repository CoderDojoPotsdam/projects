import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;public class hamsterprogramm implements de.hamster.model.HamsterProgram {class AbgrasHamster2 extends Hamster {
    AbgrasHamster2(int r, int s, int b, int k) {
        this.init(r, s, b, k);
    }

    void sammle() {
        while (this.kornDa()) {
            this.nimm();
        }
    }

    void laufeUndSammle() {
        this.sammle();
        int spalte = 0;
        while (spalte < Territorium.getAnzahlSpalten() - 1) {
            this.vor();
            this.sammle();
            spalte = spalte + 1;
        }
    }
}

public void main() {
    int zeile = 0;
    while (zeile < Territorium.getAnzahlReihen()) {
        AbgrasHamster2 paul = new AbgrasHamster2(zeile, 0,
                Hamster.OST, 0);
        paul.laufeUndSammle();
        zeile = zeile + 1;
    }
}}