import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;public class hamsterprogramm_hamster implements de.hamster.model.HamsterProgram {public void main() {
    // in der obersten Reihe wird in jeder Spalte ein Hamster
    // erzeugt
    VergleichbarHamster[] hamster = new VergleichbarHamster[Territorium
            .getAnzahlSpalten()];
    for (int i = 0; i < hamster.length; i++) {
        hamster[i] = new VergleichbarHamster(0, i,
                Hamster.SUED, 0);
    }

    // jeder Hamster grast seine Spalte ab
    for (int i = 0; i < hamster.length; i++) {
        if (hamster[i].kornDa()) {
            hamster[i].nimm();
        }
        while (hamster[i].vornFrei()) {
            hamster[i].vor();
            if (hamster[i].kornDa()) {
                hamster[i].nimm();
            }
        }
        hamster[i].kehrt();
        while (hamster[i].vornFrei()) {
            hamster[i].vor();
        }
        hamster[i].kehrt();
    }

    // Die Hamster werden sortiert. Ganz vorne im Array steht
    // nach der Sortierung der Hamster mit den wenigsten
    // Koernern im Maul; ganz hinten steht der Hamster mit
    // den meisten Koernern im Maul
    Sortieren.bubbleSort(hamster);

    /*
     * Alternative: Sortieren.quickSort(hamster);
     */

    // Die Hamster legen die gesammelten Koerner wieder ab.
    // Es beginnt derjenige Hamster, der die wenigsten
    // Koerner im Maul hat. Dann folgt der Hamster mit den
    // zweit wenigsten, usw.
    for (int i = 0; i < hamster.length; i++) {
        if (!hamster[i].maulLeer()) {
            hamster[i].gib();
        }
        while (!hamster[i].maulLeer()
                && hamster[i].vornFrei()) {
            hamster[i].vor();
            hamster[i].gib();
        }
        hamster[i].kehrt();
        while (hamster[i].vornFrei()) {
            hamster[i].vor();
        }
        hamster[i].kehrt();
    }
}}