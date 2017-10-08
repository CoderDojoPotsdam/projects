import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;class BeuteHamster extends AllroundHamster implements Spieler {
    int spielrunde;

    BeuteHamster(Hamster hamster, int runden) {
        super(hamster);
        this.spielrunde = runden;
    }

    public boolean spielzug() {
        if (this.spielrunde <= 0) {
            // hat gewonnen, wenn die letzte Spielrunde vorbei
            // ist
            return true;
        }
        this.fluechten();
        this.spielrunde = this.spielrunde - 1;
        return false;
    }

    void fluechten() {
        String antwort = this
                .liesZeichenkette("Wohin (links, rechts, "
                        + "vorne, hinten)?");
        if (antwort.equals("links")) {
            this.linksUm();
            this.vor();
        } else if (antwort.equals("rechts")) {
            this.rechtsUm();
            this.vor();
        } else if (antwort.equals("vorne")) {
            this.vor();
        } else if (antwort.equals("hinten")) {
            this.kehrt();
            this.vor();
        }
    }
}