import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;public class hamsterprogramm extends de.hamster.debugger.model.IHamster implements de.hamster.model.HamsterProgram {public void main() {

    /*
     * speichert die aktuelle Blickrichtung des Hamsters:
     * Kodierung der Blickrichtung:
     * 0 = Ost , 1 = Nord , 2 = West , 3 = Sued
     */
    int blickrichtung = 0;
    int anzahl = anzahlKoerner();
    while (anzahl != 1) {
        if (anzahl % 4 == 0) { // durch 4 teilbar
  
            // nach Osten (0) ausrichten
            ausrichten(blickrichtung, 0);
            blickrichtung = 0;
        } else if (anzahl % 3 == 0) { // durch 3 teilbar
  
            // nach Norden (1) ausrichten
            ausrichten(blickrichtung, 1);
            blickrichtung = 1;
        } else if (anzahl % 2 == 0) { // durch 2 teilbar
  
            // nach Westen (2) ausrichten
            ausrichten(blickrichtung, 2);
            blickrichtung = 2;
        } else {
  
            // nach Sueden (3) ausrichten
            ausrichten(blickrichtung, 3);
            blickrichtung = 3;
        }
  
        /*
         * entsprechende Anzahl an Feldern vorruecken und 
         * auf dem neuen Feld die Koerneranzahl ermitteln
         */
        vor(anzahl);
        anzahl = anzahlKoerner();
    }

    // Hurra! Der Schatz ist gefunden!
    nimm();
  }

/*
 * liefert die Anzahl an Koernern auf einem Feld 
 * (ohne Seiteneffekte)
 */
int anzahlKoerner() {
    int anzahl = 0;
    while (kornDa()) {
        nimm();
        anzahl++;
    }

    // zur Vermeidung von Seiteneffekten!
    int speicher = anzahl;
    while (speicher > 0) {
        gib();
        speicher--;
    }

    return anzahl;
}

/*
 * "anzahl"-Felder vorruecken
 */
void vor(int anzahl) {
    while (anzahl > 0) {
        vor();
        anzahl--;
    }
}

/*
 * in neue Blickrichtung ausrichten; 
 * Kodierung der Blickrichtung:
 * 0 = Ost , 1 = Nord , 2 = West , 3 = Sued
 */
void ausrichten(int aktuelleBlickrichtung, 
                int neueBlickrichtung) {
    linksUm((neueBlickrichtung + 4 - aktuelleBlickrichtung) % 4);
}

// dreht sich so oft nach links, wie der Parameterwert anzeigt
void linksUm(int anzahlDrehungen) {
    while (anzahlDrehungen > 0) {
        linksUm();
        anzahlDrehungen--;
    }
}}