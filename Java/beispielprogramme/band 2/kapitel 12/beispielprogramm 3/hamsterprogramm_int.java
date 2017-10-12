import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;public class hamsterprogramm_int implements de.hamster.model.HamsterProgram {public void main() {
    Hamster paul = Hamster.getStandardHamster();

    // Zahlen eingeben
    int anzahl = paul
            .liesZahl("Wie viele Zahlen moechten Sie eingeben?");
    while (anzahl < 0) {
        anzahl = paul
                .liesZahl("Fehler! Die Anzahl darf nicht negativ sein!\n"
                        + "Wie viele Zahlen moechten Sie eingeben?");
    }
    Int[] zahlen = new Int[anzahl];
    for (int i = 0; i < anzahl; i++) {
        int zahl = paul.liesZahl("Zahl " + i + " eingeben!");
        zahlen[i] = new Int(zahl);
    }

    // Zahlen sortieren
    Sortieren.bubbleSort(zahlen);

    // Zahlen in aufsteigender Reihenfolge wieder ausgeben
    paul.schreib("Ich habe die Zahlen fuer Sie sortiert!");
    for (int i = 0; i < anzahl; i++) {
        paul.schreib("Zahl " + i + " = "
                + zahlen[i].toString());
    }
}}