import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;public class OOHamsterProgramm implements de.hamster.model.HamsterProgram {class SammelHamster extends Hamster {
    SammelHamster(int r, int s, int b, int k) {
        super(r, s, b, k);
    }


    void sammle() {
        while (this.kornDa()) {
            this.nimm();
        }
    }
    
    void laufeZurMauerUndSammle() {
        this.sammle();
        while (this.vornFrei()) {
            this.vor();
            this.sammle();
        }
    }
}

public void main() {
    Hamster willi = Hamster.getStandardHamster();
    while (willi.vornFrei()) {
        willi.vor();
    }

    SammelHamster paul = new SammelHamster(1, 0,
            Hamster.OST, 0);
    paul.laufeZurMauerUndSammle();
}
}