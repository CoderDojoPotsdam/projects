import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;public class hamsterprogramm extends de.hamster.debugger.model.IHamster implements de.hamster.model.HamsterProgram {public void main() {
    begibDichInEineEcke();

    // Bestimmung von Breite und Laenge des Feldes
    int breite = bestimmeLaenge();
    linksUm();
    int hoehe = bestimmeLaenge();
    rechtsUm();

    // Berechnung des Umfangs des Feldes
    int umfang;
    if (breite == 1) {
        umfang = hoehe;
    } else if (hoehe == 1) {
        umfang = breite;
    } else {
        umfang = 2 * breite + 2 * (hoehe - 2);
    }

    // Aktion
    if (bestimmeKoernerImMaul() >= umfang) {
        legeKoernerAmRandAb();
    }
}

// begib dich in eine Ecke des Raumes
void begibDichInEineEcke() {

    // zum naechsten Rand
    while (vornFrei()) {
        vor();
    }
    linksUm();

    // in die naechste Ecke
    while (vornFrei()) {
        vor();
    }
    linksUm();
}

/*
 * bestimmt die Anzahl an freien Feldern vor dem Hamster
 * (ohne Seiteneffekte)
 */
int bestimmeLaenge() {
    int laenge = 1;
    while (vornFrei()) {
        vor();
        laenge++;
    }

    // und zurueck (zur Vermeidung von Seiteneffekten)
    int zurueck = laenge;
    kehrt();
    while (zurueck > 1) {
        vor();
        zurueck--;
    }
    kehrt();

    return laenge;
}

/*
 * bestimmt die Anzahl an Koernern, die der Hamster im Maul hat
 * (ohne Seiteneffekte)
 */
int bestimmeKoernerImMaul() {
    int anzahl = 0;
    while (!maulLeer()) {
        gib();
        anzahl++;
    }

    /*
     * zur Vermeidung von Seiteneffekten: 
     * Koerner wieder aufsammeln
     */
    int koerner = anzahl;
    while (koerner > 0) {
        nimm();
        koerner--;
    }

    return anzahl;
}

/*
 * lege an allen Randkacheln des Raumes (es existieren
 * maximal 4 Waende) je ein Korn ab
 */
void legeKoernerAmRandAb() {
    int richtungen = 0;
    while (richtungen < 4) {
        bearbeiteEineWand();
        richtungen++;
    }
}

/*
 * lege auf allen Kacheln an der Wand je ein Korn ab
 */
void bearbeiteEineWand() {
    while (vornFrei()) {
        vor();
        if (!kornDa()) {  // wegen Territorien mit nur einer 
                          // Reihe oder Spalte
            gib();
        }
    }
    linksUm();
}

void rechtsUm() { 
    linksUm(); 
    kehrt(); 
}

void kehrt() { 
    linksUm(); 
    linksUm(); 
}}