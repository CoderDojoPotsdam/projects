/*
 Windows:
 CLASSPATH: .;Programme\beispielprogramme\band 3
 Linux, Solaris:
 CLASSPATH: .:Programme/beispielprogramme/band 3
 */
import util.AllroundHamster;

import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;public class MaxKoernerAnzahl implements de.hamster.model.HamsterProgram {class InfoHamster extends AllroundHamster {

    InfoHamster(Hamster existierenderHamster) {
        super(existierenderHamster.getReihe(),
                existierenderHamster.getSpalte(), Hamster.NORD,
                0);
    }

    public void run() {
        // zwei helfende Hamster werden auf die Suche geschickt;
        // einer nach links, einer nach rechts
        ErmittlungsHamster helferLinks = new ErmittlungsHamster(
                this.getReihe(), this.getSpalte(), Hamster.WEST,
                0);
        helferLinks.start();
        ErmittlungsHamster helferRechts = new ErmittlungsHamster(
                this.getReihe(), this.getSpalte(), Hamster.OST,
                0);
        helferRechts.start();

        // die Kachel, auf der der Hamster steht uebernimmt der
        // Hamster selber
        int maxHoehe = this.nimmAlle();
        this.gib(maxHoehe);

        // nun wartet der Hamster darauf,
        // dass die beiden Helfer fertig werden
        while (!(helferLinks.auftragErledigt() && helferRechts
                .auftragErledigt())) {
            // nichts tun ("aktives Warten")
        }

        // nun sind beide fertig und das Endergebnis kann
        // ermittelt und verkuendet werden
        if (helferLinks.hoeheDesGroesstenHaufens() > maxHoehe) {
            maxHoehe = helferLinks.hoeheDesGroesstenHaufens();
        }
        if (helferRechts.hoeheDesGroesstenHaufens() > maxHoehe) {
            maxHoehe = helferRechts.hoeheDesGroesstenHaufens();
        }
        this.schreib("Die maximale Anzahl an Koernern "
                + "auf Kacheln in\n"
                + "der Reihe, in der ich stehe, betraegt "
                + maxHoehe + "!");
    }
}

class ErmittlungsHamster extends AllroundHamster {

    private int maxHoehe;

    private boolean auftragErledigt;

    ErmittlungsHamster(int r, int s, int b, int k) {
        super(r, s, b, k);
        this.maxHoehe = -1;
        this.auftragErledigt = false;
    }

    int hoeheDesGroesstenHaufens() {
        return this.maxHoehe;
    }

    boolean auftragErledigt() {
        return this.auftragErledigt;
    }

    public void run() {
        while (this.vornFrei()) {
            this.vor();
            this.bearbeiteKachel();
        }
        ;
        this.auftragErledigt = true;
        // Auftrag erledigt! Das Ergebnis kann ueber die Methode
        // hoeheDesGroesstenHaufens abgefragt werden
    }

    private void bearbeiteKachel() {
        int koerner = this.nimmAlle();
        if (koerner > this.maxHoehe) {
            this.maxHoehe = koerner;
        }
        this.gib(koerner); // Vermeidung von Seiteneffekten
    }
}

public void main() {
    Hamster paul = Hamster.getStandardHamster();
    paul.schreib("Meine Helfer und ich ermitteln "
            + "die maximale Anzahl an Koernern\n"
            + "auf Kacheln in der Reihe, in der ich stehe.");
    InfoHamster willi = new InfoHamster(paul);

    // der Vertretungs-Hamster wird auf die Suche geschickt
    willi.start();
}}