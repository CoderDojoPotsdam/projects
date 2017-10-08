import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;class SammelHamster2 extends Hamster {

    int alleineGesammelteKoerner; // Instanzattribut

    static int gemeinsamGesammelteKoerner = 0; // Klassenattribut

    SammelHamster2(int r, int s, int b, int k) {
        this.init(r, s, b, k);
        this.alleineGesammelteKoerner = 0;
    }

    void sammle() {
        while (this.kornDa()) {
            this.nimm();
            this.alleineGesammelteKoerner = this.alleineGesammelteKoerner + 1;
            SammelHamster2.gemeinsamGesammelteKoerner = SammelHamster2.gemeinsamGesammelteKoerner + 1;
        }
    }

    void laufeUndSammle() {
        this.sammle();
        while (this.vornFrei()) {
            this.vor();
            this.sammle();
        }
    }

    // Definition einer Klassenmethode
    static int getGemeinsamGesammelteKoerner() {
        return SammelHamster2.gemeinsamGesammelteKoerner;
    }
}

