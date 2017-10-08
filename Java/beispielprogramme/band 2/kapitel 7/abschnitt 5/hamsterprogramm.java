import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;public class hamsterprogramm implements de.hamster.model.HamsterProgram {class Hamster1 extends Hamster {
    int gesammelteKoerner;

    void sammle() {
        while (this.kornDa()) {
            this.nimm();
            this.gesammelteKoerner = this.gesammelteKoerner + 1;
        }
    }
}

class Hamster2 extends Hamster1 {
    int gesammelteKoerner;

    void legAb() {
        while (this.gesammelteKoerner > 0) {
        // while (super.gesammelteKoerner > 0) {
            this.gib();
            this.gesammelteKoerner = this.gesammelteKoerner - 1;
            // super.gesammelteKoerner =
            //     super.gesammelteKoerner - 1;
        }
    }
}

public void main() {
    Hamster2 paul = new Hamster2();
    paul.init(0, 0, Hamster.SUED, 3);
    paul.sammle();
    paul.legAb();
}}