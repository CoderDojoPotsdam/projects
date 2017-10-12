import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;class MeinHamster extends Hamster implements VorsichtigerHamster {

    MeinHamster(int r, int s, int b, int k) {
        super(r, s, b, k);
    }

    public boolean linksFrei() {
        this.linksUm();
        boolean frei = this.vornFrei();
        this.rechtsUm();
        return frei;
    }

    public boolean rechtsFrei() {
        this.rechtsUm();
        boolean frei = this.vornFrei();
        this.linksUm();
        return frei;
    }

    public boolean hintenFrei() {
        this.kehrt();
        boolean frei = this.vornFrei();
        this.kehrt();
        return frei;
    }

    void kehrt() {
        this.linksUm();
        this.linksUm();
    }

    void rechtsUm() {
        this.kehrt();
        this.linksUm();
    }
}
