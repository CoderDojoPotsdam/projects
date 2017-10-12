import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;public class beispiel2 implements de.hamster.model.HamsterProgram {enum Richtung {
    NORD, WEST, OST, SUED
}

class RichtungsHamster extends Hamster {

    RichtungsHamster(int r, int s, Richtung b, int k) {
        super();
        if (b == Richtung.NORD) {
            this.init(r, s, Hamster.NORD, k);
        } else if (b == Richtung.WEST) {
            this.init(r, s, Hamster.WEST, k);
        } else if (b == Richtung.SUED) {
            this.init(r, s, Hamster.SUED, k);
        } else {
            this.init(r, s, Hamster.OST, k);
        }

    }
}

public void main() {
    RichtungsHamster paul = 
        new RichtungsHamster(0, 0, Richtung.OST, 0); // ok
    // RichtungsHamster willi = 
        // new RichtungsHamster(3, 2, 1, 7); // Syntaxfehler
    // RichtungsHamster karin = 
        // new RichtungsHamster(2, 2, 8, 2); // Syntaxfehler
}}