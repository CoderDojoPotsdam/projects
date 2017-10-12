// realisiert gut trainierte Hamster, die beim Aufruf
// des vor-Befehls gleich 3 Kacheln vorruecken
import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;class RennHamster extends Hamster {
    RennHamster(int r, int s, int b, int k) {
        super(r, s, b, k);
    }

    // ueberschriebene vor-Methode!
    public void vor() {
        super.vor();
        if (this.vornFrei()) {
            super.vor();
            if (this.vornFrei()) {
                super.vor();
            }
        }
    }
}