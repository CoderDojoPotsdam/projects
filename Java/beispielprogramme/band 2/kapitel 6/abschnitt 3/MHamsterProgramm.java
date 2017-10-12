import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;public class MHamsterProgramm implements de.hamster.model.HamsterProgram {class MHamster extends Hamster {
    MHamster(int r, int s, int b, int k) {
        this.init(r, s, b, k);
    }
}

public void main() {
    MHamster paul = new MHamster(3, 1, Hamster.SUED, 89);
    // paul wird im Konstruktor initialisiert!
    if (paul.vornFrei()) {
        paul.vor();
    }
}
}