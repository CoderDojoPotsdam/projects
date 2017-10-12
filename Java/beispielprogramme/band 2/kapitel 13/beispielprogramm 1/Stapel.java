import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;class Stapel {

    Object[] speicher; // Speicher

    int oberstesElement; // Index auf oberstes Element

    Stapel(int maxGroesse) {
        this.speicher = new Object[maxGroesse];
        this.oberstesElement = -1;
    }

    // legt obj oben auf dem Stapel ab
    void drauflegen(Object obj) throws StapelVollException {
        if (this.oberstesElement < this.speicher.length - 1) {
            this.oberstesElement = this.oberstesElement + 1;
            this.speicher[this.oberstesElement] = obj;
        } else {
            throw new StapelVollException(this.speicher.length);
        }
    }

    // entfernt das oberste Element des Stapels und liefert es
    // als Wert zurueck
    Object herunternehmen() throws StapelLeerException {
        if (this.oberstesElement >= 0) {
            Object ergebnis = this.speicher[this.oberstesElement];
            this.oberstesElement = this.oberstesElement - 1;
            return ergebnis;
        } else {
            throw new StapelLeerException();
        }
    }
}