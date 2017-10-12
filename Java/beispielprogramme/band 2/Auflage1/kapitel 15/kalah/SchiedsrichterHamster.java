/*
Windows:
  CLASSPATH: Programme\beispielprogramme\band 2\kapitel 15
Linux, Solaris:
  CLASSPATH: Programme/beispielprogramme/band 2/kapitel 15
*/
package kalah;

// repraesentiert einen Hamster als Schiedsrichter des
// Kalah-Spiels
import de.hamster.debugger.model.Territorium;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.debugger.model.Hamster;public class SchiedsrichterHamster 
  extends AllroundHamster 
{
  // Attribute
  private Spielbrett brett;           // internes Spielbrett
  private Spielregeln regeln;         // Spielregeln
  private Spieler spielerA, spielerB; // die Spieler
  
  // Hilfsattribute
  private Spieler aktuellerSpieler;
  private Spielzug aktuellerSpielzug;
  private int letzteMulde;

  // Konstruktor
  public SchiedsrichterHamster() {
    super(0, 0, Hamster.OST, Spielbrett.ANZAHL_KOERNER);
  }

  // bereitet das Spiel vor
  public void initialisiereSpiel() {
    this.brett = new Spielbrett();
    this.regeln = new Spielregeln(this.brett);
    this.aktuellerSpieler = null;
    this.aktuellerSpielzug = null;
    this.erstelleSpielfeld();
    this.spielerA = erzeugeSpielerA(this.regeln);
    this.spielerB = erzeugeSpielerB(this.regeln);
  }

  // liefert Spieler A
  public Spieler getSpielerA() {
    return this.spielerA;
  }

  // liefert Spieler B
  public Spieler getSpielerB() {
    return this.spielerB;
  }

  
  // ueberprueft den Spielzug eines Spielers
  public boolean istSpielzugOk(Spieler spieler, Spielzug zug) {
    // merkt sich den aktuellen Spieler und Spielzug
    this.aktuellerSpieler = spieler;
    this.aktuellerSpielzug = zug;
    
    // ueberprueft den Spielzug auf dem internen Brett
    if (!this.regeln.istSpielzugOk(spieler.istSpielerA(), zug)) {
      return false;
    }
    
    // fuehrt den Spielzug auf dem internen Brett aus;
    // merkt sich die Mulde, in die das letzte Korn gelegt wurde
    this.letzteMulde = 
      this.brett.fuehreSpielzugAus(spieler.istSpielerA(), zug);
    
    // nun ueberprueft der Schiedsrichter-Hamster noch, ob auch
    // das Hamster-Territorium gemaess der Regeln in Ordnung ist;
    return this.kontrolliereTerritorium();
  }
  
  // ueberprueft, ob ein Spiel beendet ist
  public boolean istSpielBeendet() {
    boolean ende = 
      this.regeln.istSpielBeendet(this.werIstAmZug().istSpielerA());
    if (ende) {
      // auf dem internen Brett wird der Endzustand hergestellt
      this.brett.spielBeenden();
    }
    return ende;
  }
  
  // ueberprueft Endzustand von Spieler A
  public boolean istEndzustandVonSpielerAOk() {
    this.vor(Spielbrett.ANZAHL_MULDEN_PRO_SPIELER);
    this.kehrt();
    for (int i=0; i<Spielbrett.ANZAHL_MULDEN_PRO_SPIELER; i++) {
      if (Territorium.getAnzahlKoerner(this.getReihe(), 
                                       this.getSpalte()) != 0) {
        return false;
      }
      this.vor();
    }
    this.linksUm();
    this.vor();
    if (Territorium.getAnzahlKoerner(this.getReihe(), 
                                     this.getSpalte()) != 
          this.brett.liefereAnzahlKoerner(Spielbrett.KALAH_A)
       ) {
      return false;
    }
    this.gehZumAusgangspunkt();
    return true;
  }
  
  // ueberprueft Endzustand von Spieler B
  public boolean istEndzustandVonSpielerBOk() {
    this.rechtsUm();
    this.vor(2);
    this.linksUm();
    this.vor(1);
    for (int i=0; i<Spielbrett.ANZAHL_MULDEN_PRO_SPIELER; i++) {
      if (Territorium.getAnzahlKoerner(this.getReihe(), 
                                       this.getSpalte()) != 0) {
        return false;
      }
      this.vor();
    }
    this.linksUm();
    this.vor();
    if (Territorium.getAnzahlKoerner(this.getReihe(), 
                                     this.getSpalte()) != 
          this.brett.liefereAnzahlKoerner(Spielbrett.KALAH_B)
       ) {
      return false;
    }
    this.gehZumAusgangspunkt();
    return true;
  }
  
  // liefert den Sieger eines beendeten Spieles;
  // liefert null, wenn das Spiel mit einem Unentschieden endete
  public Spieler liefereSieger() {
    if (this.regeln.istUnentschieden()) {
      return null;
    } else if (this.regeln.istSpielerASieger()) {
      return this.spielerA;
    } else {
      return this.spielerB;
    }
  }
  
  // liefert den naechsten Spieler, der am Zug ist
  public Spieler werIstAmZug() {
    // es beginnt Spieler A
    if (this.aktuellerSpieler == null) {
      return this.spielerA;
    }
    
    if (this.aktuellerSpieler.istSpielerA() &&
        this.letzteMulde == Spielbrett.KALAH_A ||
        !this.aktuellerSpieler.istSpielerA() &&
        this.letzteMulde == Spielbrett.KALAH_B 
       ) {
      // die letzte Kugel landete im eigenen Kalah, d.h.
      // der Spieler muss nochmal ziehen
      return this.aktuellerSpieler;
    } else {
      // der Gegner ist an der Reihe
      return this.liefereGegner(this.aktuellerSpieler);
    }
  }
  
  // liefert den gegnerischen Spieler
  public Spieler liefereGegner(Spieler s) {
    if (s == this.spielerA) {
      return spielerB;
    } else {
      return spielerA;
    }
  }

  // liefert die Punkte von Spieler A
  public int getPunkteA() {
    return this.brett.liefereAnzahlKoernerInKalahA();
  }

  // liefert die Punkte von Spieler B
  public int getPunkteB() {
    return this.brett.liefereAnzahlKoernerInKalahB();
  }
  
  // interne Methoden
  
  // laeuft zur Kachel (0/0) und schaut nach Osten
  protected void gehZumAusgangspunkt() {
    this.gotoKachel(0, 0);
    this.setzeBlickrichtung(Hamster.OST);
  }

  // der Schiedsrichter-Hamster ueberprueft, ob auch
  // das Hamster-Territorium gemaess der Regeln in Ordnung ist;
  // d.h. ob der Zustand des Territoriums und des internen Brettes
  // identisch sind
  protected boolean kontrolliereTerritorium() {
    this.vor();
    for (int i=Spielbrett.ANZAHL_MULDEN_PRO_SPIELER-1; i>=0; i--) {
      if (this.brett.liefereAnzahlKoerner(i) !=
          Territorium.getAnzahlKoerner(this.getReihe(), this.getSpalte())
         ) {
        return false;
      }
      this.vor();
    }
    this.rechtsUm();
    this.vor();
    if (this.brett.liefereAnzahlKoerner(Spielbrett.KALAH_B) !=
        Territorium.getAnzahlKoerner(this.getReihe(), this.getSpalte())
       ) {
      return false;
    }
    this.vor();
    this.rechtsUm();
    this.vor();
    for (int i=Spielbrett.KALAH_B-1; i>=Spielbrett.KALAH_A+1; i--) {
      if (this.brett.liefereAnzahlKoerner(i) !=
          Territorium.getAnzahlKoerner(this.getReihe(), this.getSpalte())
         ) {
        return false;
      }
      this.vor();
    }
    this.rechtsUm();
    this.vor();
    if (this.brett.liefereAnzahlKoerner(Spielbrett.KALAH_A) !=
        Territorium.getAnzahlKoerner(this.getReihe(), this.getSpalte())
       ) {
      return false;
    }
    
    // und zurueck zum Ausgangspunkt
    this.vor();
    this.rechtsUm();

    return true;
  }

  // interne Methoden

  // baut das Spielfeld auf
  protected void erstelleSpielfeld() {
    // sorgt dafuer, dass in den Mulden die exakte Anzahl an Koernern
    // liegt
    this.vor();
    for (int i=Spielbrett.ANZAHL_MULDEN_PRO_SPIELER-1; i>=0; i--) {
      int anzahl = 
        Territorium.getAnzahlKoerner(this.getReihe(), this.getSpalte());
      // zu viele Koerner?
      while (anzahl > Spielbrett.ANZAHL_KOERNER_PRO_MULDE) {
        this.nimm();
        anzahl = anzahl - 1;
      }
      // zu wenige Koerner?
      while (anzahl < Spielbrett.ANZAHL_KOERNER_PRO_MULDE) {
        this.gib();
        anzahl = anzahl + 1;
      }
      this.vor();
    }
    this.rechtsUm();
    this.vor();

    // Kalah B leer machen
    this.nimmAlle();

    this.vor();
    this.rechtsUm();
    this.vor();
    for (int i=Spielbrett.KALAH_B-1; i>=Spielbrett.KALAH_A+1; i--) {
      int anzahl = 
        Territorium.getAnzahlKoerner(this.getReihe(), this.getSpalte());
      // zu viele Koerner?
      while (anzahl > Spielbrett.ANZAHL_KOERNER_PRO_MULDE) {
        this.nimm();
        anzahl = anzahl - 1;
      }
      // zu wenige Koerner?
      while (anzahl < Spielbrett.ANZAHL_KOERNER_PRO_MULDE) {
        this.gib();
        anzahl = anzahl + 1;
      }
      this.vor();
    }
    this.rechtsUm();
    this.vor();

    // Kalah A leer machen
    this.nimmAlle();
    
    // und zurueck zum Ausgangspunkt
    this.vor();
    this.rechtsUm();
  }

  // erzeugt und liefert Spieler A
  protected Spieler erzeugeSpielerA(Spielregeln regeln) {
    return new MenschHamster(true, regeln);
  }
  
  // erzeugt und liefert Spieler B
  protected Spieler erzeugeSpielerB(Spielregeln regeln) {
    return new MenschHamster(false, regeln);
  }
}      
