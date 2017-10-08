import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;public class hamsterprogramm_hamster implements de.hamster.model.HamsterProgram {public void main() {
    Stapel haufen = new Stapel(Territorium
            .getAnzahlSpalten());
    SammelHamster paul = null;
    int spalte = 0;

    // zuerst wird die oberste Reihe nach Osten hin
    // abgegrast; jede Kachel uebernimmt ein neuer Hamster
    do {
        paul = new SammelHamster(spalte);
        paul.sammle();
        haufen.drauflegen(paul);
        spalte = spalte + 1;
    } while (spalte < Territorium.getAnzahlSpalten());

    // anschliessend legen alle Hamster in umgekehrter
    // Reihenfolge die gefressenen Koerner wieder auf den
    // entsprechenden Kacheln ab
    while (!haufen.istLeer()) {
        Object objekt = haufen.herunternehmen();
        paul = (SammelHamster) objekt; // Typumwandlung
                                       // erforderlich!
        paul.legAb();
    }
}}