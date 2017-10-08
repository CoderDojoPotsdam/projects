// die Klasse erweitert den Befehlssatz eines normalen
// Hamsters um viele nuetzliche Befehle
import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;public class AllroundSHamster extends SHamster {

    // Singleton-Muster

    private static AllroundSHamster standardHamster = new AllroundSHamster(
            true);

    protected AllroundSHamster(boolean dummy) {
        super(dummy);
    }

    public static AllroundSHamster getStandardHamsterAlsAllroundSHamster() {
        return standardHamster;
    }

    // normale Konstruktoren und Methoden

    // initialisiert einen neuen AllroundSHamster mit den
    // uebergebenen Werten
    public AllroundSHamster(int r, int s, int b, int k) {
        super(r, s, b, k);
    }

    // initialisiert einen neuen AllroundSHamster mit den
    // Attributwerten eines bereits existierenden Hamsters
    public AllroundSHamster(Hamster existierenderHamster) {
        super(existierenderHamster);
    }

    // der Hamster dreht sich um 180 Grad
    public void kehrt() {
        this.linksUm();
        this.linksUm();
    }

    // der Hamster dreht sich nach rechts
    public void rechtsUm() {
        this.kehrt();
        this.linksUm();
    }

    // der Hamster laeuft "anzahl" Schritte, maximal jedoch
    // bis zur naechsten Mauer;
    // geliefert wird die tatsaechliche Anzahl gelaufener
    // Schritte
    public int vor(int anzahl) {
        int schritte = 0;
        while (this.vornFrei() && anzahl > 0) {
            this.vor();
            schritte = schritte + 1;
            anzahl = anzahl - 1;
        }
        return schritte;
    }

    // der Hamster legt "anzahl" Koerner ab, maximal jedoch
    // so viele, wie er im Maul hat;
    // geliefert wird die tatsaechliche Anzahl abgelegter
    // Koerner
    public int gib(int anzahl) {
        int abgelegteKoerner = 0;
        while (!this.maulLeer() && anzahl > 0) {
            this.gib();
            abgelegteKoerner = abgelegteKoerner + 1;
            anzahl = anzahl - 1;
        }
        return abgelegteKoerner;
    }

    // der Hamster frisst "anzahl" Koerner, maximal jedoch
    // so viele, wie auf der aktuellen Kachel liegen
    public int nimm(int anzahl) {
        int gefresseneKoerner = 0;
        while (this.kornDa() && anzahl > 0) {
            this.nimm();
            gefresseneKoerner = gefresseneKoerner + 1;
            anzahl = anzahl - 1;
        }
        return gefresseneKoerner;
    }

    // der Hamster legt alle Koerner, die er im Maul hat,
    // auf der aktuellen Kachel ab;
    // geliefert wird die Anzahl abgelegter Koerner
    public int gibAlle() {
        int abgelegteKoerner = 0;
        while (!this.maulLeer()) {
            this.gib();
            abgelegteKoerner = abgelegteKoerner + 1;
        }
        return abgelegteKoerner;
    }

    // der Hamster frisst alle Koerner auf der aktuellen Kachel;
    // geliefert wird die Anzahl gefressener Koerner
    public int nimmAlle() {
        int gefresseneKoerner = 0;
        while (this.kornDa()) {
            this.nimm();
            gefresseneKoerner = gefresseneKoerner + 1;
        }
        return gefresseneKoerner;
    }

    // der Hamster laeuft bis zur naechsten Mauer;
    // geliefert wird die Anzahl ausgefuehrter Schritte
    public int laufeZurWand() {
        int schritte = 0;
        while (this.vornFrei()) {
            this.vor();
            schritte = schritte + 1;
        }
        return schritte;
    }

    // der Hamster testet, ob links von ihm die Kachel frei ist
    public boolean linksFrei() {
        this.linksUm();
        boolean frei = this.vornFrei();
        this.rechtsUm();
        return frei;
    }

    // der Hamster testet, ob rechts von ihm die Kachel frei ist
    public boolean rechtsFrei() {
        this.rechtsUm();
        boolean frei = this.vornFrei();
        this.linksUm();
        return frei;
    }

    // der Hamster testet, ob hinter ihm die Kachel frei ist
    public boolean hintenFrei() {
        this.kehrt();
        boolean frei = this.vornFrei();
        this.kehrt();
        return frei;
    }

    // der Hamster dreht sich so lange um, bis er in die
    // uebergebene Blickrichtung schaut
    public void setzeBlickrichtung(int richtung) {
        while (this.getBlickrichtung() != richtung) {
            this.linksUm();
        }
    }

    // der Hamster laeuft in der Spalte, in der er
    // gerade steht, zur angegebenen Reihe;
    // Voraussetzung: die Reihe existiert und
    // es befinden sich keine Mauern
    // im Territorium bzw. auf dem gewaehlten Weg
    public void laufeZuReihe(int reihe) {
        if (reihe == this.getReihe())
            return;
        if (reihe > this.getReihe()) {
            this.setzeBlickrichtung(Hamster.SUED);
        } else {
            this.setzeBlickrichtung(Hamster.NORD);
        }
        while (reihe != this.getReihe()) {
            this.vor();
        }
    }

    // der Hamster laeuft in der Reihe, in der er
    // gerade steht, zur angegebenen Spalte;
    // Voraussetzung: die Spalte existiert und
    // es befinden sich keine Mauern
    // im Territorium bzw. auf dem gewaehlten Weg
    public void laufeZuSpalte(int spalte) {
        if (spalte == this.getSpalte())
            return;
        if (spalte > this.getSpalte()) {
            this.setzeBlickrichtung(Hamster.OST);
        } else {
            this.setzeBlickrichtung(Hamster.WEST);
        }
        while (spalte != this.getSpalte()) {
            this.vor();
        }
    }

    // der Hamster laeuft zur Kachel (reihe/spalte);
    // Voraussetzung: die Kachel existiert und
    // es befinden sich keine Mauern
    // im Territorium bzw. auf dem gewaehlten Weg
    public void laufeZuKachel(int reihe, int spalte) {
        laufeZuReihe(reihe);
        laufeZuSpalte(spalte);
    }
}