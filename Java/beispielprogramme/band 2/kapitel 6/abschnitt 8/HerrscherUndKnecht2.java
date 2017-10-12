import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;public class HerrscherUndKnecht2 implements de.hamster.model.HamsterProgram {class FaulerHamster2 extends Hamster {

    Hamster knecht; // Hamster-Subobjekt

    FaulerHamster2(int r, int s, int b, int k, Hamster hamster) {
        this.init(r, s, b, k);
        this.knecht = hamster;
    }

    void setKnecht(Hamster hamster) {
        this.knecht = hamster;
    }

    Hamster getKnecht() {
        return this.knecht;
    }

    void laufeBisZurWand() {
        if (this.knecht != null) {
            while (this.knecht.vornFrei()) {
                this.knecht.vor();
            }
        } else {
            while (this.vornFrei()) {
                this.vor();
            }
        }
        this.kehrt();
    }

    void kehrt() {
        if (this.knecht != null) {
            knecht.linksUm();
            knecht.linksUm();
        } else {
            this.linksUm();
            this.linksUm();
        }
    }
}

public void main() {
    /* 1 */Hamster james = new Hamster(0, 0, Hamster.SUED, 0);
    /* 2 */FaulerHamster2 paul = new FaulerHamster2(2, 0,
            Hamster.OST, 0, james);
    /* 3 */FaulerHamster2 willi = new FaulerHamster2(3, 0,
            Hamster.OST, 0, james);

    /* 4 */paul.laufeBisZurWand();
    /* 5 */willi.laufeBisZurWand();

    /* 6 */paul.setKnecht(null);
    /* 7 */willi.setKnecht(null);

    /* 8 */paul.laufeBisZurWand();
    /* 9 */willi.laufeBisZurWand();
}}