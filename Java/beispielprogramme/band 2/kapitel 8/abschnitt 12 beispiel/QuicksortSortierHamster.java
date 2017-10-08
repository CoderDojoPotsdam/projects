import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;class QuicksortSortierHamster extends SortierHamster {

    QuicksortSortierHamster(Hamster existierenderHamster) {
        super(existierenderHamster);
    }

    void sortiereArray() {
        this.quicksort(0, this.speicher.length - 1);
    }

    void quicksort(int vonIndex, int bisIndex) {
        int i = vonIndex;
        int j = bisIndex;
        int mittlererWert = this.speicher[(vonIndex + bisIndex) / 2];

        // Aufteilung
        while (i <= j) {
            while (this.speicher[i] < mittlererWert)
                i++;
            while (this.speicher[j] > mittlererWert)
                j--;
            if (i <= j) {
                tauschen(i, j);
                i++;
                j--;
            }
        }

        // rekursiver Aufruf
        if (vonIndex < j)
            quicksort(vonIndex, j);
        if (i < bisIndex)
            quicksort(i, bisIndex);
    }

    void tauschen(int i, int j) {
        int ablage = this.speicher[i];
        this.speicher[i] = this.speicher[j];
        this.speicher[j] = ablage;
    }
}