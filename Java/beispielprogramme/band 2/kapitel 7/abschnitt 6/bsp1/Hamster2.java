import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;class Hamster2 extends Hamster1 {
    int gesammelteKoerner;

    // Definition (mindestens) eines Konstruktors ist
    // erforderlich
    Hamster2(int r, int s, int b, int k) {
        super(r, s, b, k); // Aufruf des vier-parametrigen
                           // Konstruktors der Klasse Hamster1
                           // mittels des super-Konstruktes
        this.gesammelteKoerner = 0;
    }
}