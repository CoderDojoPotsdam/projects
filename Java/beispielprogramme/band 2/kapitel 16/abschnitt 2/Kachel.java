import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;class Kachel {
    private int reihe;

    private int spalte;

    Kachel(int r, int s) {
        this.reihe = r;
        this.spalte = s;
    }

    int getReihe() {
        return this.reihe;
    }

    int getSpalte() {
        return this.spalte;
    }
    
    public int hashCode() {
        return this.reihe + this.spalte;
    }

    public boolean equals(Object obj) {
        Kachel kachel = (Kachel) obj;
        return this.reihe == kachel.reihe
                && this.spalte == kachel.spalte;
    }
}