/*
Windows:
  CLASSPATH: .;Programme\beispielprogramme\band 3
Linux, Solaris:
  CLASSPATH: .:Programme/beispielprogramme/band 3
*/
import util.AllroundHamster;

import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;public class ParallelSlalom implements de.hamster.model.HamsterProgram {class SkiHamster extends AllroundHamster {

    private boolean linksHerum;
    // Flag, der anzeigt, ob der Hamster links oder rechts
    // herum um die naechste Stangen fahren muss

    SkiHamster(int reihe) {
        super(reihe, 0, Hamster.OST, 0);
        this.linksHerum = true; // beginne mit links herum
    }

    public void run() {
        this.fahreSlalom();
    }

    void fahreSlalom() {
        while (!this.kornDa()) {
            this.fahrBisZurNaechstenStange();
            if (this.linksHerum) {
                this.umfahreStangenLinksHerum();
                this.linksHerum = false;
            } else {
                this.umfahreStangenRechtsHerum();
                this.linksHerum = true;
            }
        }
        this.nimm();
    }

    void fahrBisZurNaechstenStange() {
        while (this.vornFrei()) {
            this.vor();
        }
    }

    void umfahreStangenLinksHerum() {
        this.linksUm();
        this.vor();
        this.rechtsUm();
        this.vor();
        while (!this.rechtsFrei()) {
            this.vor();
        }
        this.rechtsUm();
        this.vor();
        this.linksUm();
    }

    void umfahreStangenRechtsHerum() {
        this.rechtsUm();
        this.vor();
        this.linksUm();
        this.vor();
        while (!this.linksFrei()) {
            this.vor();
        }
        this.linksUm();
        this.vor();
        this.rechtsUm();
    }
}

public void main() {
    SkiHamster paul = new SkiHamster(1);
    SkiHamster willi = new SkiHamster(4);
    paul.start();
    willi.start();
}
}