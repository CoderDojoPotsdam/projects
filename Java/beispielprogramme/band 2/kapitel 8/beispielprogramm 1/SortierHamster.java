import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;class SortierHamster extends AllroundHamster {

    SortierHamster(int r, int s, int b, int k) {
        super(r, s, b, k);
    }

    void laufNachUntenLinks() {
        this.setzeBlickrichtung(Hamster.WEST);
        this.laufeZurWand();
        this.linksUm();
        this.laufeZurWand();
        this.linksUm();
        // der Hamster steht ganz unten links;
        // Blickrichtung OST
    }

    int zaehleSpalten() {
        // der Hamster steht ganz unten links;
        // Blickrichtung OST
        int spalten = 1;
        while (this.vornFrei()) {
            this.vor();
            spalten = spalten + 1;
        }
        return spalten;
        // der Hamster steht ganz unten rechts;
        // Blickrichtung OST
    }

    void zaehleUndSammleKoerner(int[] koerner) {
        // der Hamster steht ganz unten rechts,
        // Blickrichtung OST
        this.linksUm();
        for (int s = koerner.length - 1; s >= 0; s--) {
            int anzahl = zaehleKoernerInSpalteUndNimm();
            koerner[s] = anzahl;
            this.linksUm();
            if (this.vornFrei()) {
                this.vor();
                this.rechtsUm();
            } else {
                this.rechtsUm();
            }
        }
        // der Hamster steht ganz unten links,
        // Blickrichtung NORD
    }

    int zaehleKoernerInSpalteUndNimm() {
        // der Hamster steht ganz unten;
        // Blickrichtung NORD
        int anzahl = 0;
        while (this.kornDa()) {
            this.nimm();
            anzahl = anzahl + 1;
            if (this.vornFrei()) {
                this.vor();
            }
        }
        this.kehrt();
        this.laufeZurWand();
        this.kehrt();
        return anzahl;
    }

    void sortiereKoerner(int[] koerner) {
        // sortieren des Arrays;
        // wir nehmen wieder den Bubblesort-Algorithmus
        boolean getauscht = false;
        do {
            getauscht = false;
            for (int i = 1; i < koerner.length; i++) {
                if (koerner[i - 1] > koerner[i]) {
                    int ablage = koerner[i - 1];
                    koerner[i - 1] = koerner[i];
                    koerner[i] = ablage;
                    getauscht = true;
                }
            }
        } while (getauscht);
    }

    void legeAlleKoernerAb(int[] koerner) {
        // der Hamster steht ganz unten links;
        // Blickrichtung NORD
        for (int s = 0; s < koerner.length; s++) {
            this.legeKoernerAb(koerner[s]);
            this.rechtsUm();
            if (this.vornFrei()) {
                this.vor();
                this.linksUm();
            }
        }
    }

    void legeKoernerAb(int anzahl) {
        // legt anzahl Koerner in einer Spalte ab;
        // der Hamster steht unten; Blickrichtung NORD
        for (int z = 0; z < anzahl; z++) {
            this.gib();
            if (this.vornFrei()) {
                this.vor();
            }
        }
        this.kehrt();
        this.laufeZurWand();
        this.kehrt();
    }
}