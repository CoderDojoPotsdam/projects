import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;class Hamster2 extends Hamster1 {
    int maxSchritte;

    Hamster2(int r, int s, int b, int k, int m) {
        super(r, s, b, k);
        this.maxSchritte = m;
    }

    Hamster2(int m) {
        // automatischer Aufruf des parameterlosen Konstruktors
        // der Klasse Hamster1
        this.maxSchritte = m;
    }
}