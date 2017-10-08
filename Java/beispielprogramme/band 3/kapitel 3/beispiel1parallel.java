import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;public class beispiel1parallel implements de.hamster.model.HamsterProgram {class LaufHamster extends Hamster {

    LaufHamster(int r, int s, int b, int k) {
        super(r, s, b, k);
    }

    public void run() {
        while (this.vornFrei()) {
            this.vor();
        }
    }
}

public void main() {
    LaufHamster paul = new LaufHamster(1, 0, Hamster.OST, 0);
    LaufHamster willi = new LaufHamster(2, 0, Hamster.OST, 0);
    paul.start(); // Aktivierungsbefehl fuer Paul
    willi.start(); // Aktivierungsbefehl fuer Willi
}}