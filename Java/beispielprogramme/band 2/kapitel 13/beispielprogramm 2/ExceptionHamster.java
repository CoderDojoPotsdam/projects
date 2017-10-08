import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;class ExceptionHamster extends Hamster {

    ExceptionHamster(int r, int s, int b, int k) {
        super(r, s, b, k);
    }

    // ueberschriebene Hamster-Testbefehle
    final public boolean vornFrei() {
        return true;
    }

    final public boolean kornDa() {
        return true;
    }

    final public boolean maulLeer() {
        return false;
    }
}