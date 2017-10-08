import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;public class HerrscherUndKnecht implements de.hamster.model.HamsterProgram {class FaulerHamster extends Hamster {

    Hamster knecht; // Hamster-Subobjekt

    FaulerHamster(int r, int s, int b, int k) {
        this.init(r, s, b, k);
        this.knecht = new Hamster(r, s, b, k);
    }

    void laufeBisZurWand() {
        while (this.knecht.vornFrei()) {
            this.knecht.vor();
        }

        /* oder:
        while (knecht.vornFrei()) {
            knecht.vor();
        }
        */

    }
}

public void main() {
    FaulerHamster herrscher = new FaulerHamster(2, 0,
            Hamster.OST, 0);
    herrscher.laufeBisZurWand();
}}