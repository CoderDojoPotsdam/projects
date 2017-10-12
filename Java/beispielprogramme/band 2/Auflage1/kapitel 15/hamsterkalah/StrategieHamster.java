/*
Windows:
  CLASSPATH: Programme\beispielprogramme\band 2\kapitel 15
Linux, Solaris:
  CLASSPATH: Programme/beispielprogramme/band 2/kapitel 15
*/
package hamsterkalah;

import kalah.*;

// repraesentiert einen "intelligenten"
// Kalah-spielenden Hamster
import de.hamster.debugger.model.Territorium;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.debugger.model.Hamster;public class StrategieHamster 
  extends MenschHamster
  implements Spieler 
{  
  // Attribute
  protected int spielstaerke;

  // initialisiert einen StrategieHamster; uebergeben werden die
  // Spielregeln, die Information, ob der Hamster Spieler A oder 
  // B ist, sowie die Spielstaerke des Hamsters (je groesser der
  // Wert, desto besser spielt der Hamster)
  public StrategieHamster(boolean istSpielerA,
                          Spielregeln regeln,
                          int staerke) {
    super(istSpielerA, regeln);
    this.spielstaerke = staerke;
  }
  
  // ermittelt den naechsten Spielzug, fuehrt ihn aus und liefert ihn
  public Spielzug naechsterSpielzug() {
    // ermittelt den besten Spielzug
    WertSpielzug zug = null;
    WertSpielbrett brett = new WertSpielbrett(this.regeln.getBrett());
    if (this.istSpielerA()) {
      zug = this.ermittleBestenAZug(this.spielstaerke, brett);
    } else {
      zug = this.ermittleBestenBZug(this.spielstaerke, brett);
    }

    // anschliessend wird der Spielzug im Hamster-Territorium
    // ausgefuehrt
    this.fuehreSpielzugAus(zug.getZug());

    // der ausgefuehrte Spielzug wird geliefert
    return zug.getZug();
  }

  // interne Methoden

  // ermittelt den besten Spielzug von Spieler A
  protected WertSpielzug ermittleBestenAZug(int restTiefe, 
                                            WertSpielbrett brett) {
    Spielzug besterSpielzug = null;
    int besteBewertung = WertSpielbrett.MIN_WERT-1;
    Spielzug[] zuege = this.ermittleFolgeZuege(true, brett);
    for (int z=0; z<zuege.length; z++) {
      WertSpielbrett brettKopie = new WertSpielbrett(brett);
      Spielregeln regelKopie = new Spielregeln(brettKopie);
      int letzteMulde = brettKopie.fuehreSpielzugAus(true, zuege[z]);
      boolean naechsterIstA = regelKopie.istAAmZug(true, letzteMulde);
      boolean spielBeendet = regelKopie.istSpielBeendet(naechsterIstA);
      int zugWert = 0;
      if (restTiefe <= 1 || spielBeendet) {
        zugWert = brettKopie.bewerteStellung(spielBeendet);
      } else if (naechsterIstA) {
        WertSpielzug zug = 
          ermittleBestenAZug(restTiefe - 1, brettKopie);
        zugWert = zug.getWert();
      } else {
        WertSpielzug zug = 
          ermittleBestenBZug(restTiefe - 1, brettKopie);
        zugWert = zug.getWert();
      }
      int zufall = (int)(Math.random()*2); // 0 oder 1
      if (zugWert > besteBewertung || 
          (zugWert == besteBewertung && zufall == 0)) {
        besteBewertung = zugWert;
        besterSpielzug = zuege[z];
      }
    }
    return new WertSpielzug(besterSpielzug, besteBewertung);
  }

  // ermittelt den besten Spielzug von Spieler B;
  protected WertSpielzug ermittleBestenBZug(int restTiefe, 
                                            WertSpielbrett brett) {
    Spielzug besterSpielzug = null;
    int besteBewertung = WertSpielbrett.MAX_WERT+1;
    Spielzug[] zuege = this.ermittleFolgeZuege(false, brett);
    for (int z=0; z<zuege.length; z++) {
      WertSpielbrett brettKopie = new WertSpielbrett(brett);
      Spielregeln regelKopie = new Spielregeln(brettKopie);
      int letzteMulde = brettKopie.fuehreSpielzugAus(false, zuege[z]);
      boolean naechsterIstA = regelKopie.istAAmZug(false, letzteMulde);
      boolean spielBeendet = regelKopie.istSpielBeendet(naechsterIstA);
      int zugWert = 0;
      if (restTiefe <= 1 || spielBeendet) {
        zugWert = brettKopie.bewerteStellung(spielBeendet);
      } else if (naechsterIstA) {
        WertSpielzug zug = 
          ermittleBestenAZug(restTiefe - 1, brettKopie);
        zugWert = zug.getWert();
      } else {
        WertSpielzug zug = 
          ermittleBestenBZug(restTiefe - 1, brettKopie);
        zugWert = zug.getWert();
      }
      int zufall = (int)(Math.random()*2); // 0 oder 1
      if (zugWert < besteBewertung || 
          (zugWert == besteBewertung && zufall == 0)) {
        besteBewertung = zugWert;
        besterSpielzug = zuege[z];
      }
    }
    return new WertSpielzug(besterSpielzug, besteBewertung);
  }

  // ermittelt alle moeglichen Folgezuege
  protected Spielzug[] ermittleFolgeZuege(boolean istSpielerA, 
                                          Spielbrett brett) {
    int[] mulden = new int[Spielbrett.ANZAHL_MULDEN_PRO_SPIELER];
    int nummer = 0;
    if (istSpielerA) {
      for (int mulde=0; mulde<Spielbrett.KALAH_A; mulde++) {
        if (brett.liefereAnzahlKoerner(mulde) > 0) {
          mulden[nummer] = mulde;
          nummer = nummer + 1;
        }
      }
    } else {
      for (int mulde=Spielbrett.KALAH_A+1; 
           mulde<Spielbrett.KALAH_B; 
           mulde++) {
        if (brett.liefereAnzahlKoerner(mulde) > 0) {
          mulden[nummer] = mulde;
          nummer = nummer + 1;
        }
      }
    }

    Spielzug[] zuege = new Spielzug[nummer];
    for (int i=0; i<nummer; i++) {
      zuege[i] = new Spielzug(mulden[i]);
    }
    return zuege;
  }

}
