import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;public class hamsterprogramm implements de.hamster.model.HamsterProgram {class SammelHamster extends Hamster {

    int gesammelteKoerner = 0;

    void sammle() {
        while (this.kornDa()) {
            this.nimm();
            this.gesammelteKoerner = this.gesammelteKoerner + 1;
        }
    }
}

class LegUndSammelHamster extends SammelHamster {

    void legGesammelteKoernerAb() {
        while (this.gesammelteKoerner > 0) {
            this.gib();
            this.gesammelteKoerner = this.gesammelteKoerner - 1;
            // Zugriff auf geerbtes Attribut
        }
    }
}

public void main() {
    LegUndSammelHamster paul = new LegUndSammelHamster();
    paul.init(2, 3, Hamster.NORD, 9);
    paul.sammle();
    while (paul.vornFrei()) {
        paul.vor();
        paul.sammle();
    }
    paul.legGesammelteKoernerAb();
}
}