import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;class Int implements Vergleichbar {

    int wert;

    Int(int w) {
        this.wert = w;
    }

    Int(Int obj) {
        this.wert = obj.wert;
    }

    protected Object clone() {
        return new Int(this);
    }

    public boolean equals(Object obj) {
        return this.wert == ((Int) obj).wert;
    }

    public int hashCode() {
        return this.wert;
    }

    public String toString() {
        return String.valueOf(this.wert);
    }

    int getWert() {
        return this.wert;
    }

    public boolean gleich(Vergleichbar zahl) {
        return this.wert == ((Int) zahl).wert;
    }

    public boolean kleiner(Vergleichbar zahl) {
        return this.wert < ((Int) zahl).wert;
    }

    public boolean groesser(Vergleichbar zahl) {
        return this.wert > ((Int) zahl).wert;
    }
}