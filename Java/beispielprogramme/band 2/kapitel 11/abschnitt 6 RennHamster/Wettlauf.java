import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;class Wettlauf { // realisiert einen Hamster-Wettlauf

    // in jedem Wettlauf-Zyklus darf jeder Hamster einmal ein
    // Feld vorruecken
    static Hamster zyklus(Hamster[] laeufer) {
        for (int i = 0; i < laeufer.length; i++) {
            if (laeufer[i].vornFrei()) {
                laeufer[i].vor();
            }
            if (!laeufer[i].vornFrei()) { // Mauer erreicht, d.h.
                                          // gewonnen!
                return laeufer[i];
                // Wettlauf beendet, der Sieger wird geliefert
            }
        }
        return null; // Wettlauf noch nicht beendet
    }

    // Durchfuehrung des Wettlaufs
    static Hamster durchfuehren(Hamster[] laeufer) {
        Hamster sieger = null;
        do {
            sieger = Wettlauf.zyklus(laeufer);
        } while (sieger == null);
        return sieger;
    }
}