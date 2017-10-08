import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;class MeinHamster extends Hamster {
    
    // Definition von Attributen
    int gesammelteKoerner = 0;

    // Definition von Methoden
    void sammle() {
        while (this.kornDa()) {
            this.nimm();
            this.gesammelteKoerner = this.gesammelteKoerner + 1;
        }
    }

    void legeGesammelteKoernerAb() {
        while (this.gesammelteKoerner > 0) {
            this.gib();
            this.gesammelteKoerner = this.gesammelteKoerner - 1;
        }
    }
}