import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;class LaufHamster3 extends Hamster {

    int maximaleSchritte;

    int schritte;

    // Konstruktor
    LaufHamster3(int r, int s, int b, int k, int maxSchritte) {
        this.init(r, s, b, k);
        this.schritte = 0;
        this.maximaleSchritte = maxSchritte;
    }

    void lauf() {
        if (this.schritte < this.maximaleSchritte
                && this.vornFrei()) {
            this.vor();
            schritte = schritte + 1;
        }
    }
}
