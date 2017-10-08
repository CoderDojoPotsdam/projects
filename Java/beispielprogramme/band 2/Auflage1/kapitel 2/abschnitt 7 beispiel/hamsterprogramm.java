import de.hamster.debugger.model.Territorium;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;public class hamsterprogramm extends de.hamster.debugger.model.IHamster implements de.hamster.model.HamsterProgram {int anzahl = 0; // globale Variable

void laufeBisZurWand() {
    while (vornFrei()) {
      vor();
      anzahl = anzahl + 1;  // Zuweisung
    }
}

void laufeZurueckZumAusgangspunkt() {
    while (anzahl > 0) { // Vergleichsausdruck
      vor();
      anzahl = anzahl - 1;
    }
}

public void main() {
    laufeBisZurWand();
    linksUm(); linksUm();
    laufeZurueckZumAusgangspunkt();
}}