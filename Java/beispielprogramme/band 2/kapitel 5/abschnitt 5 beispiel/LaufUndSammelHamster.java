import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;class LaufUndSammelHamster extends Hamster {

    void sammle(int maxKoerner) {
        int anzahl = 0; // methodenlokale Variable
        while (this.kornDa() && anzahl < maxKoerner) {
            this.nimm();
            anzahl = anzahl + 1;
        }
    }

    int schritte; // als Attribut: korrekt, aber schlecht

    void laufe(int maxSchritte) {
        schritte = 0;
        while (this.vornFrei() && schritte < maxSchritte) {
            this.vor();
            schritte = schritte + 1;
        }
    }
}