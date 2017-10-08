// ein Superhirn-Hamster
import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;class Superhirn extends AllroundHamster {

    // durch Aendern dieser Konstanten koennen die entsprechenden
    // Spielregeln einfach geaendert werden
    final static int ANZAHL_ZAHLEN = 4; // Anzahl zu erratender
                                        // Zahlen

    final static int RUNDEN = 10; // Anzahl an Spielrunden

    final static int MAX_ZAHL = 9; // Zahlen zwischen 0 und
                                   // MAX_ZAHL

    int[] geheimeZahlen; // hier werden die geheimen Zahlen
                         // gespeichert

    int[] benutzerZahlen; // hier werden vom Benutzer eingegebene
                          // Zahlen gespeichert

    int korrektePosition; // Anzahl an erratenen Zahlen mit
                          // korrekten Positionen

    int korrektesVorkommen; // Anzahl an erratenen Zahlen mit
                            // korrekten Vorkommen

    Superhirn() {
        super(0, 0, Hamster.OST,
                Superhirn.RUNDEN
                        * (Superhirn.ANZAHL_ZAHLEN
                                * Superhirn.MAX_ZAHL + 4));
        // das sind genuegend Koerner
        // der Hamster denkt sich die zu erratenen Zahlen aus
        this.geheimeZahlen = new int[Superhirn.ANZAHL_ZAHLEN];
        for (int z = 0; z < Superhirn.ANZAHL_ZAHLEN; z++) {
            this.geheimeZahlen[z] = Zufall
                    .naechsteZahl(Superhirn.MAX_ZAHL);
        }

        this.benutzerZahlen = new int[Superhirn.ANZAHL_ZAHLEN];
    }

    boolean ueberpruefeSpielfeld() {
        return Territorium.getAnzahlReihen() >= Superhirn.RUNDEN
                && Territorium.getAnzahlSpalten() >= Superhirn.ANZAHL_ZAHLEN + 4;
    }

    void spiele() {
        boolean beendet = false;
        for (int r = 1; r <= Superhirn.RUNDEN && !beendet; r++) {
            this.schreib("Runde " + r);
            this.zahlenAbfragen();
            this.ergebnisBerechnen();
            beendet = this.ergebnisAuslegen(r);
        }
    }

    void zahlenAbfragen() {
        for (int z = 0; z < Superhirn.ANZAHL_ZAHLEN; z++) {
            this.benutzerZahlen[z] = this.liesZahl("Zahl "
                    + (z + 1) + " zwischen 0 und "
                    + Superhirn.MAX_ZAHL + " eingeben !");
            while (this.benutzerZahlen[z] < 0
                    || this.benutzerZahlen[z] > Superhirn.MAX_ZAHL) {
                this.benutzerZahlen[z] = this
                        .liesZahl("Fehler!\nZahl " + (z + 1)
                                + " zwischen 0 und "
                                + Superhirn.MAX_ZAHL
                                + " eingeben !");
            }
        }
    }

    void ergebnisBerechnen() {
        // nach richtigen Positionen (korrektePosition) suchen
        boolean[] posErledigt = new boolean[Superhirn.ANZAHL_ZAHLEN];
        this.korrektePosition = 0;
        for (int i = 0; i < Superhirn.ANZAHL_ZAHLEN; i++) {
            if (this.geheimeZahlen[i] == this.benutzerZahlen[i]) {
                this.korrektePosition = this.korrektePosition + 1;
                posErledigt[i] = true;
            }
        }

        // nach richtigen Zahlen (korrektesVorkommen) suchen
        boolean[] vorErledigt = new boolean[Superhirn.ANZAHL_ZAHLEN];
        for (int i = 0; i < Superhirn.ANZAHL_ZAHLEN; i++) {
            vorErledigt[i] = posErledigt[i];
        }
        this.korrektesVorkommen = 0;
        for (int i = 0; i < Superhirn.ANZAHL_ZAHLEN; i++) {
            if (!posErledigt[i]) {
                boolean jErledigt = false;
                for (int j = 0; j < Superhirn.ANZAHL_ZAHLEN
                        && !jErledigt; j++) {
                    if (i != j
                            && !vorErledigt[j]
                            && this.benutzerZahlen[i] == this.geheimeZahlen[j]) {
                        this.korrektesVorkommen = this.korrektesVorkommen + 1;
                        vorErledigt[j] = true;
                        jErledigt = true;
                    }
                }
            }
        }
    }

    boolean ergebnisAuslegen(int runde) {
        this.vor();

        // zunaechst werden die vom Benutzer eingegebenen Zahlen
        // als Koernerhaufen ausgelegt
        for (int z = 0; z < Superhirn.ANZAHL_ZAHLEN; z++) {
            this.gib(this.benutzerZahlen[z]);
            this.vor();
        }
        this.vor();

        // dann werden so viele Koerner ausgelegt, wie
        // Zahlen korrekt sind und an der korrekten Position
        // stehen
        this.gib(this.korrektePosition);
        this.schreib(this.korrektePosition
                + " korrekte Positionen");
        this.vor();

        // dann werden so viele Koerner ausgelegt, wie
        // Zahlen korrekt sind, aber an der falschen Position
        // stehen
        this.gib(this.korrektesVorkommen);
        this.schreib(this.korrektesVorkommen
                + " korrekte Vorkommen");

        if (this.korrektePosition == Superhirn.ANZAHL_ZAHLEN) {
            this
                    .schreib("Herzlichen Glueckwunsch. Du hast gewonnen!");
            return true;
        } else if (runde == Superhirn.RUNDEN) {
            String zahlen = "";
            for (int z = 0; z < Superhirn.ANZAHL_ZAHLEN; z++) {
                zahlen = zahlen + this.geheimeZahlen[z] + " ";
            }
            this.schreib("Aetsch, ich habe gewonnen.\n"
                    + "Meine Zahlen lauten " + zahlen + "!");
            return true;
        } else {
            // bereitmachen zur naechsten Runde
            this.rechtsUm();
            this.vor();
            this.rechtsUm();
            this.vor(3 + Superhirn.ANZAHL_ZAHLEN);
            this.kehrt();
            return false;
        }
    }
}
