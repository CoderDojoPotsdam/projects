import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;class KornHamster extends Hamster implements
        VornUndHintenKornHamster {
    KornHamster(int r, int s, int b, int k) {
        super(r, s, b, k);
    }

    public boolean vornKorn() {
        if (!vornFrei()) {
            return false;
        }
        vor();
        boolean da = kornDa();
        kehrt();
        vor();
        kehrt();
        return da;
    }

    public boolean hintenKorn() {
        kehrt();
        boolean da = vornKorn();
        kehrt();
        return da;
    }
    
    public void kehrt() {
        linksUm();
        linksUm();
    }
}