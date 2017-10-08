// repraesentiert "vergleichbare" Hamster; die Hamster werden
// bezueglich der Anzahl an Koernern im Maul miteinander
// verglichen
import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;class VergleichbarHamster extends AllroundHamster implements
        Vergleichbar {
    VergleichbarHamster(int r, int s, int b, int k) {
        super(r, s, b, k);
    }

    public boolean gleich(Vergleichbar hamster) {
        return this.getAnzahlKoerner() == ((Hamster) hamster)
                .getAnzahlKoerner();
    }

    public boolean kleiner(Vergleichbar hamster) {
        return this.getAnzahlKoerner() < ((Hamster) hamster)
                .getAnzahlKoerner();
    }

    public boolean groesser(Vergleichbar hamster) {
        return this.getAnzahlKoerner() > ((Hamster) hamster)
                .getAnzahlKoerner();
    }
}