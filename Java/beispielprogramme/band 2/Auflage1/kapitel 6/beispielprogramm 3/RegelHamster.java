// realisiert die NGewinnt-Regeln
import de.hamster.debugger.model.Territorium;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.debugger.model.Hamster;class RegelHamster extends Hamster {
  
  // Groesse des Spielfeldes
  final static int FELD_GROESSE = 7;
  
  // wie  viele Scheiben in Reihe, Spalte oder Diagonale
  final static int N_GEWINNT = 4;
  
  int sieger = 0;

  RegelHamster() {
    this.init(RegelHamster.FELD_GROESSE-1, 0, Hamster.OST, 0);
  }
  
  boolean spielEnde() {
    // der Regelhamster ist zu faul, das Feld abzulaufen und
    // die Koerner zu zaehlen;
    // stattdessen nutzt er die Moeglichkeiten der Klasse
    // Territorium
    
    // Ueberpruefung der Zeilen
    int zeile = 0;
    while (zeile < RegelHamster.FELD_GROESSE) {
      int spalte = 0;
      while (spalte <= RegelHamster.FELD_GROESSE - 
                       RegelHamster.N_GEWINNT) {
        if (Territorium.getAnzahlKoerner(zeile, spalte) == 
            NGewinntHamster.ROT) {
          if (nInZeile(zeile, spalte, NGewinntHamster.ROT)) {
            this.sieger = NGewinntHamster.ROT;
            return true;
          }
        } else if (Territorium.getAnzahlKoerner(zeile, spalte) == 
                   NGewinntHamster.GELB) {
          if (nInZeile(zeile, spalte, NGewinntHamster.GELB)) {
            this.sieger = NGewinntHamster.GELB;
            return true;
          }
        }
        spalte = spalte + 1;
      }
      zeile = zeile + 1;
    }
    
    // Ueberpruefung der Spalten:
    // siehe Aufgabe 3
    
    // Ueberpruefung der Diagonalen
    // siehe Aufgabe 3
    
    // Feld voll und kein Sieger?
    zeile = 0;
    while (zeile < RegelHamster.FELD_GROESSE) {
      int spalte = 0;
      while (spalte < RegelHamster.FELD_GROESSE) {
        if (Territorium.getAnzahlKoerner(zeile, spalte) == 0) {
          return false;
        }
        spalte = spalte + 1;
      }
      zeile = zeile + 1;
    }
    return true;
  }
  
  int ermittleSieger() {
    return sieger;
  }
  
  // ueberprueft, ob sich N_GEWINNT gleiche Scheiben in einer
  // Reihe befinden, und zwar ab Kachel (zeile/spalte)
  boolean nInZeile(int zeile, int spalte, int anzahl) {
    int i = 1;
    while (i < RegelHamster.N_GEWINNT) {
      if (Territorium.getAnzahlKoerner(zeile, spalte+i) != anzahl) { 
        return false;
      }
      i = i + 1;
    }
    return true;
  }
} 
