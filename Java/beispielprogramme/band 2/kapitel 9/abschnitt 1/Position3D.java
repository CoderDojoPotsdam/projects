import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;class Position3D extends Position {
    // Attribute
    int tiefe;

    // Konstruktor
    Position3D(int rWert, int sWert, int tWert) {
        super(rWert, sWert);
        this.tiefe = tWert;
    }

    // Methoden
    int getTiefe() {
        return this.tiefe;
    }
}