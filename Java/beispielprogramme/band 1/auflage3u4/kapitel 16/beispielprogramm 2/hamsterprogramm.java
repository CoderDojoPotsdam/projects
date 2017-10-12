import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;public class hamsterprogramm extends de.hamster.debugger.model.IHamster implements de.hamster.model.HamsterProgram {public void main() {

    /*
     * lokale Variable; 
     * speichert die Groesse des aktuellen Radius
     */
    int radius = 1;     
    while (!kornDa()) {

        // radius wird als Parameter uebergeben
        testeEinenKreis(radius); 

        // nach jeder Runde wird der Radius ein Feld groesser
        radius++;
    }
    nimm();
}
 
void testeEinenKreis(int radius) {
    int richtungen = 0;  

    // ein Kreis besteht aus vier Richtungen
    while (!kornDa() && (richtungen < 4)) {
        testeEineRichtung(radius);
        richtungen++;
    }
}
    
void testeEineRichtung(int radius) {
    int schritte = 0;

    /*
     * die Ueberpruefung einer Richtung besteht aus der 
     * Ueberpruefung von so vielen Feldern, wie der Radius 
     * des Kreises aktuell betraegt
     */
    while (!kornDa() && (schritte < radius) && vornFrei()) {
        vor();
        schritte++;
    }

    if (!kornDa()) {
        linksUm();
    }
}}