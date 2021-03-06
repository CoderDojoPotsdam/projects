import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;public class hamsterprogramm extends de.hamster.debugger.model.IHamster implements de.hamster.model.HamsterProgram {public void main() {
    int breite = bestimmeBreite();
    linksUm();
    int hoehe = bestimmeHoehe();
    kehrt();
    graseFeldAb(breite, hoehe);
}

/*
 * ermittelt die Breite des Feldes;
 * Seiteneffekt: der Hamster steht anschliessend am Rand 
 * des Kornfeldes
 */
int bestimmeBreite() {
    int breite = 1;

    // zunaechst in die eine Richtung
    while (vornFrei() && vornKorn()) {
        vor(); 
        breite++;
    }
    kehrt();

    int zurueck = breite;
    while (zurueck > 1) {
        vor(); 
        zurueck--;
    }

    // dann in die andere Richtung
    while (vornFrei() && vornKorn()) {
        vor(); 
        breite++;
    }
    return breite;
}

/*
 * ermittelt die Hoehe des Feldes;
 * Seiteneffekt: der Hamster steht anschliessend in 
 * einer Ecke des Kornfeldes
 */
int bestimmeHoehe() {
    return bestimmeBreite();
}

/*
 * grast das Kornfeld mit der uebergebenen Groesse ab
 */
void graseFeldAb(int breite, int hoehe) {
    while (breite > 0) {
        graseReiheAbUndZurueck(hoehe);
        breite--;
        if (breite > 0) {
            rechtsUm(); 
            vor(); 
            rechtsUm();
        }
    }
}

/*
 * grast eine Reihe des Kornfeldes ab und laeuft
 * dann zurueck
 */
void graseReiheAbUndZurueck(int schritte) {

    // hin (mit Aufsammeln) ...
    int zurueck = schritte;
    sammle();
    while (schritte > 1) {
        vor(); 
        sammle();
        schritte--;
    }

    // ... und zurueck
    kehrt();
    while (zurueck > 1) {
        vor(); 
        zurueck--;
    }
}

/*
 * sammle alle Koerner auf einer Kachel auf
 */
void sammle() { 
    while (kornDa()) {
        nimm(); 
    }
}

/*
 * ueberprueft, ob die Kachel vor dem Hamster ein Korn enthaelt
 * (ohne Seiteneffekte)
 */
boolean vornKorn() {
    if (!vornFrei()) {
        return false;
    }
    vor();
    boolean da = kornDa();

    // zur Vermeidung von Seiteneffekten
    kehrt(); 
    vor(); 
    kehrt();
    return da;
}

void rechtsUm() { 
    kehrt(); 
    linksUm(); 
}

void kehrt() { 
    linksUm(); 
    linksUm(); 
}}