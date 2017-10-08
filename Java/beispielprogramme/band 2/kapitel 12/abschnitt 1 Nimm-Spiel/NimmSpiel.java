import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;class NimmSpiel {
    FrissHamster[] spieler; // speichert die spielenden Hamster

    int koernerAnzahl; // speichert die Laenge der Koernerreihe

    NimmSpiel(FrissHamster hamster1, FrissHamster hamster2,
            int anzahl) {
        // die spielenden Hamster werden ins Array gepackt
        this.spieler = new FrissHamster[2];
        this.spieler[0] = hamster1;
        this.spieler[1] = hamster2;
        this.koernerAnzahl = anzahl;
    }

    // spielen des Nimm-Spiels; geliefert wird der siegreiche
    // Hamster
    FrissHamster spielen() {
        int aktuellerIndex = 0;
        int gefressen = 0;
        while (this.koernerAnzahl > 0) {
            gefressen = this.spieler[aktuellerIndex]
                    .friss(gefressen);
            // friss wird dynamisch gebunden
            this.koernerAnzahl = this.koernerAnzahl - gefressen;
            if (this.koernerAnzahl > 0) {
                // bewirkt, dass die beiden Hamster abwechselnd
                // einen Spielzug ausfuehren
                aktuellerIndex = (aktuellerIndex + 1) % 2;
            }
        }
        return this.spieler[aktuellerIndex];
    }
}