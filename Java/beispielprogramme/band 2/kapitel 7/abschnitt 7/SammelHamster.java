import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;class SammelHamster extends Hamster {
    static int gemeinsamGesammelteKoerner = 0; // Klassenattribut

    SammelHamster(int r, int s, int b, int k) {
        super(r, s, b, k);
    }

    public void nimm() {
        super.nimm();
        SammelHamster.gemeinsamGesammelteKoerner =
            SammelHamster.gemeinsamGesammelteKoerner + 1;
    }

    static int getGemeinsamGesammelteKoerner() {
        return SammelHamster.gemeinsamGesammelteKoerner;
    }
}