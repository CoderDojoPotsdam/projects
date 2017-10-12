import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;abstract class FrissHamster extends Hamster {
    int koernerAnzahl; // speichert die Laenge der Koernerreihe

    FrissHamster(int r, int s, int b, int k, int anzahl) {
        super(r, s, b, k);
        this.koernerAnzahl = anzahl;
    }

    // die Methode zum Fressen; uebergeben wird, wie viele
    // Koerner der Gegner gefressen hat; geliefert wird, wie
    // viele Koerner der Hamster gefressen hat
    abstract int friss(int gegnerAnzahl);

    // laufe eine Ehrenrunde
    void laufeEhrenrunde() {
        this.linksUm();
        this.linksUm();
        while (this.vornFrei()) {
            this.vor();
        }
    }
}