import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;public class hamsterprogramm extends de.hamster.debugger.model.IHamster implements de.hamster.model.HamsterProgram {int radius = 1;  // speichert die Groesse des aktuellen Radius

public void main() {
    while (!kornDa()) {
        testeEinenKreis();

        // nach jeder Runde wird der Radius ein Feld groesser
        radius++;
    }
    nimm();
}

void testeEinenKreis() {
    int richtungen = 0;
  
    // ein Kreis besteht aus vier Richtungen
    while (!kornDa() && (richtungen < 4)) {
        testeEineRichtung();
        richtungen++;
    }
}

void testeEineRichtung() {
    int schritte = 0;

    /*
     * die Ueberpruefung einer Richtung besteht aus der 
     * Ueberpruefung von so vielen Feldern, wie der Radius 
     * des Kreises aktuell gross ist; die zusaetzliche 
     * Konjunktion mit vornFrei() ist notwendig, falls das 
     * Feld nicht quadratisch ist
     */
    while (!kornDa() && (schritte < radius) && vornFrei()) {
        vor();
        schritte++;
    }

    if (!kornDa()) {
        linksUm();
    }
}}