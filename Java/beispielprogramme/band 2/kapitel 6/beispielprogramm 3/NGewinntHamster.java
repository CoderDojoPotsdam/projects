// realisiert die spielenden Hamster
import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;class NGewinntHamster extends Hamster {

    // Farben der Scheiben
    final static int ROT = 1;

    final static int GELB = 2;

    // Farbe des Spielers
    int farbe;

    NGewinntHamster(int farbe) {
        this.init(RegelHamster.FELD_GROESSE - 1, 0, Hamster.OST,
                RegelHamster.FELD_GROESSE
                        * RegelHamster.FELD_GROESSE * farbe);
        // die Anzahl der Koerner im Maul der Hamster reicht auf
        // jeden
        // Fall aus
        this.farbe = farbe;
    }

    void fuehreNaechstenSpielzugAus() {
        // die Hamster verfolgen keine Strategie; die
        // Spaltenauswahl geschieht per Zufall
        int spalte = this.spaltenAuswahl();
        this.laufeZurSpalte(spalte);
        this.linksUm();
        boolean abgelegt = this.legeScheibeAb();
        this.linksUm();
        this.laufeZumStartpunkt(spalte);
        this.kehrt();

        // falls die gewaehlte Spalte schon voll war, muss
        // der Hamster nochmal ran
        if (!abgelegt) {
            this.fuehreNaechstenSpielzugAus();
        }
    }

    void laufeZurSpalte(int schritte) {
        while (schritte > 0) {
            this.vor();
            schritte = schritte - 1;
        }
    }

    void laufeZumStartpunkt(int schritte) {
        while (schritte > 0) {
            this.vor();
            schritte = schritte - 1;
        }
    }

    boolean legeScheibeAb() {
        // legt oberhalb der letzten Scheibe eine weitere Scheibe
        // ab; falls die Spalte schon voll ist, wird false
        // geliefert
        boolean abgelegt = false;

        if (!this.kornDa()) {
            int anzahl = 0;
            while (anzahl < this.farbe) {
                this.gib();
                anzahl = anzahl + 1;
            }
            abgelegt = true;
        }

        int schritte = 0;
        while (schritte < RegelHamster.FELD_GROESSE && !abgelegt
                && this.vornFrei()) {
            this.vor();
            schritte = schritte + 1;
            if (!this.kornDa()) {
                int anzahl = 0;
                while (anzahl < this.farbe) {
                    this.gib();
                    anzahl = anzahl + 1;
                }
                abgelegt = true;
            }
        }

        // und zurueck
        this.kehrt();
        while (schritte > 0) {
            this.vor();
            schritte = schritte - 1;
        }
        this.kehrt();

        return abgelegt;
    }

    void jubeln() {
        // laeuft alle Spalten ab und tanzt dabei
        int schritte = 0;
        while (schritte < RegelHamster.FELD_GROESSE - 1) {
            this.vor();
            this.drehDich(4);
            schritte = schritte + 1;
        }
    }

    void drehDich(int anzahl) {
        while (anzahl > 0) {
            this.linksUm();
            anzahl = anzahl - 1;
        }
    }

    void rechtsUm() {
        this.drehDich(3);
    }

    void kehrt() {
        this.drehDich(2);
    }

    // erzeugt Zufallszahl zwischen 0 und FELD_GROESSE-1
    int spaltenAuswahl() {
        return (int) (Math.random() * RegelHamster.FELD_GROESSE);
    }
}