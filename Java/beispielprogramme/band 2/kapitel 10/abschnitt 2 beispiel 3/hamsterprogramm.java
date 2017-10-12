import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;public class hamsterprogramm implements de.hamster.model.HamsterProgram {class SammelHamster extends Hamster {
    int gesamtAnzahl;

    SammelHamster(int r, int s, int b, int k) {
        super(r, s, b, k);
        this.gesamtAnzahl = 0;
    }

    void sammle() {
        int anzahl = 0;
        while (this.kornDa()) {
            this.nimm();
            anzahl = anzahl + 1;
        }
        this.schreib("Ich habe gerade " + anzahl
                + " Koerner gefressen!");
        this.gesamtAnzahl = this.gesamtAnzahl + anzahl;
    }

    void graseReiheAb() {
        this.sammle();
        while (this.vornFrei()) {
            this.vor();
            this.sammle();
        }
        this.schreib("Ich habe insgesamt " + this.gesamtAnzahl
                + " Koerner gefressen!");
    }
}

public void main() {
    SammelHamster paul = new SammelHamster(2, 0,
            Hamster.OST, 3);
    paul.graseReiheAb();
}}