// der Hamster huepft anzahl-mal vor, maximal aber bis zur Mauer
import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;public class hamsterprogramm extends de.hamster.debugger.model.IHamster implements de.hamster.model.HamsterProgram {void vor(int anzahl) {  // formaler Parameter
    while (vornFrei() && anzahl > 0) {
      vor();
      anzahl = anzahl - 1;
    }
}

// liefert seiteneffektfrei die Koerneranzahl im Maul des Hamsters
int koernerImMaul() {
    int anzahl = 0;
    while (!maulLeer()) {
        gib();
        anzahl = anzahl + 1;
    }
    int ergebnis = anzahl;
    
    // Koerner wieder fressen
    while (anzahl > 0) {
        nimm();
        anzahl = anzahl - 1;
    }
    return ergebnis;
}

public void main() {
    vor(4);                // aktueller Parameter
    linksUm();
    vor(koernerImMaul());  // aktueller Parameter
}
}