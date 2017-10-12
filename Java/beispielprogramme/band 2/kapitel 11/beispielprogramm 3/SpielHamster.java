import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;class SpielHamster extends AllroundHamster {
    int koernerAnzahl; // speichert die Laenge der Koernerreihe

    int genommen; // speichert die Anzahl der genommen Koerner

    SpielHamster(int r, int s, int b, int k, int anzahl) {
        super(r, s, b, k);
        this.koernerAnzahl = anzahl;
        this.genommen = 1;
    }

    // die Methode zum Fressen;
    // uebergeben wird, wie viele Koerner der Gegner gefressen
    // hat;
    // geliefert wird, wie viele Koerner der Hamster gefressen
    // hat
    int friss(int gegnerAnzahl) {
        this.koernerAnzahl = this.koernerAnzahl - gegnerAnzahl;
        // laufe wieder bis zum Anfang der Koernerreihe
        for (int i = 0; i < gegnerAnzahl; i++) {
            this.vor();
        }

        if (this.genommen == 1) {
            this.genommen = 2;
            this.vor();
            this.nimm();
            if (this.vornFrei()) {
                this.vor();
                this.nimm();
                this.koernerAnzahl = this.koernerAnzahl - 2;
                return 2;
            } else {
                this.koernerAnzahl = this.koernerAnzahl - 1;
                return 1;
            }
        } else {
            this.genommen = 1;
            this.vor();
            this.nimm();
            this.koernerAnzahl = this.koernerAnzahl - 1;
            return 1;
        }
    }

    // laufe eine Ehrenrunde
    void laufeEhrenrunde() {
        this.kehrt();
        while (this.vornFrei()) {
            this.vor();
        }
    }
}