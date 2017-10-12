/*
Windows:
  CLASSPATH: Programme\beispielprogramme\band 2\Anhang B
Linux, Solaris:
  CLASSPATH: Programme/beispielprogramme/band 2/Anhang B
*/
package kalah;

// repraesentiert einen von einem Menschen gesteuerten
// Kalah-spielenden Hamster
import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;public class MenschHamster extends AllroundHamster implements
        Spieler {
    // Attribute
    protected boolean istSpielerA; // Spieler A oder B?

    protected Spielregeln regeln; // die Spielregeln

    // initialisiert einen SpielHamster; uebergeben werden die
    // Spielregeln sowie die Information, ob der Hamster
    // Spieler A oder B ist,
    public MenschHamster(boolean istSpielerA, Spielregeln regeln) {
        // interne Initialisierungen
        super(0, 0, Hamster.OST, 0);
        this.istSpielerA = istSpielerA;
        this.regeln = regeln;

        // in Ausgangsposition begeben
        this.begibDichAufAusgangsKachel();
    }

    // Ueberpruefung, welcher Spieler es ist
    public boolean istSpielerA() {
        return this.istSpielerA;
    }

    // liefert A oder B, je nachdem, welcher Spielertyp es ist
    public String liefereSpielerTyp() {
        if (this.istSpielerA) {
            return "A";
        } else {
            return "B";
        }
    }

    // ermittelt den naechsten Spielzug, fuehrt ihn aus und
    // liefert ihn
    public Spielzug naechsterSpielzug() {
        // naechsten Spielzug beim Benutzer erfragen
        int mulde = this.liesZahl("Spieler "
                + this.liefereSpielerTyp() + ": Welche Mulde?");
        Spielzug zug = new Spielzug(mulde);
        boolean ok = this.regeln.istSpielzugOk(this.istSpielerA,
                zug);
        while (!ok) {
            mulde = this.liesZahl("Fehler!\n Spieler "
                    + this.liefereSpielerTyp()
                    + ": Bitte korrekte Mulde angeben!");
            zug = new Spielzug(mulde);
            ok = this.regeln
                    .istSpielzugOk(this.istSpielerA, zug);
        }

        // anschliessend wird der Spielzug im Hamster-Territorium
        // ausgefuehrt
        this.fuehreSpielzugAus(zug);

        // der ausgefuehrte Spielzug wird geliefert
        return zug;
    }

    // sammelt uebrig gebliebene Koerner ein und packt sie ins
    // eigene Kalah
    public void sammleResteUndBringSieZumKalah() {
        this.vor();
        int anzahl = 0;
        for (int i = 0; i < Spielbrett.ANZAHL_MULDEN_PRO_SPIELER; i++) {
            anzahl = anzahl + this.nimmAlle();
            this.vor();
        }
        this.linksUm();
        this.vor();
        this.gibAlle();
    }

    // frisst zur Belohung alle Koerner seiner Kalah
    public void spielBeenden(boolean istSieger) {
        // sitzt bereits im Kalah
        this.nimmAlle(); // auch wenn er nicht gewonnen hat
    }

    // interne Methoden

    // der Spielzug wird im Hamster-Territorium ausgefuehrt
    protected void fuehreSpielzugAus(Spielzug zug) {
        this.gotoMulde(zug.liefereMulde());
        int anzahl = this.nimmAlle();
        this.verteileKoerner(anzahl, zug.liefereMulde());
        this.begibDichAufAusgangsKachel();
    }

    // laeuft zur angegebenen Mulde
    protected void gotoMulde(int muldenNummer) {
        if (this.istSpielerA) {
            this.vor(muldenNummer + 1);
        } else {
            this.vor(muldenNummer
                    - Spielbrett.ANZAHL_MULDEN_PRO_SPIELER);
        }
    }

    // verteilt die aufgenommenen Koerner gemaess der
    // Kalah-Spielregeln
    protected void verteileKoerner(int anzahl, int aktuelleMulde) {
        // zunaechst entgegen dem Uhrzeigersinn jeweils ein Korn
        // pro Mulde ablegen
        while (anzahl > 0) {
            if (aktuelleMulde == Spielbrett.KALAH_A - 1
                    || aktuelleMulde == Spielbrett.KALAH_B - 1) {
                this.vor();
                this.linksUm();
                this.vor();
                if (this.istSpielerA
                        && aktuelleMulde == Spielbrett.KALAH_A - 1
                        || !this.istSpielerA
                        && aktuelleMulde == Spielbrett.KALAH_B - 1) {
                    // Kalah des Gegners auslassen
                    this.gib();
                    anzahl = anzahl - 1;
                }
            } else if (aktuelleMulde == Spielbrett.KALAH_A
                    || aktuelleMulde == Spielbrett.KALAH_B) {
                this.vor();
                this.linksUm();
                this.vor();
                this.gib();
                anzahl = anzahl - 1;
            } else {
                this.vor();
                this.gib();
                anzahl = anzahl - 1;
            }
            aktuelleMulde = (aktuelleMulde + 1)
                    % Spielbrett.ANZAHL_MULDEN;
        }

        // nun ueberpruefen, ob evtl. einige Koerner ins eigene
        // Kalah abgelegt werden duerfen
        if (this.istSpielerA
                && 0 <= aktuelleMulde
                && aktuelleMulde < Spielbrett.KALAH_A
                && Territorium.getAnzahlKoerner(this.getReihe(),
                        this.getSpalte()) == 1
                && Territorium.getAnzahlKoerner(
                        this.getReihe() + 2, this.getSpalte()) > 0) {
            this.nimm(); // das eine Korn der aktuellen Mulde
            // fressen
            this.linksUm();
            this.vor();
            this.vor();
            // gegenueberliegende Mulde leer fressen
            this.nimmAlle();
            this.gotoKalahA();
            this.gibAlle(); // in eigenes Kalah ablegen
        } else if (!this.istSpielerA
                && Spielbrett.KALAH_A < aktuelleMulde
                && aktuelleMulde < Spielbrett.KALAH_B
                && Territorium.getAnzahlKoerner(this.getReihe(),
                        this.getSpalte()) == 1
                && Territorium.getAnzahlKoerner(
                        this.getReihe() - 2, this.getSpalte()) > 0) {
            this.nimm(); // das eine Korn der aktuellen Mulde
            // fressen
            this.linksUm();
            this.vor();
            this.vor();
            // gegenueberliegende Mulde leer fressen
            this.nimmAlle();
            this.gotoKalahB();
            this.gibAlle(); // in eigenes Kalah ablegen
        }
    }

    // in Ausgangsposition begeben
    protected void begibDichAufAusgangsKachel() {
        if (this.istSpielerA) {
            this.gotoKachel(0,
                    Spielbrett.ANZAHL_MULDEN_PRO_SPIELER + 1);
            this.setzeBlickrichtung(Hamster.WEST);
        } else {
            this.gotoKachel(2, 0);
            this.setzeBlickrichtung(Hamster.OST);
        }
    }

    // nach Kalah A laufen
    protected void gotoKalahA() {
        this.gotoKachel(1, 0);
    }

    // nach Kalah B laufen
    protected void gotoKalahB() {
        this.gotoKachel(1,
                Spielbrett.ANZAHL_MULDEN_PRO_SPIELER + 1);
    }
}