import de.hamster.debugger.model.Territorium;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.debugger.model.Hamster;public class DaemonenWettrennen implements de.hamster.model.HamsterProgram {class LaufHamster extends Hamster {

    LaufHamster(int r, int s) {
        super(r, s, Hamster.OST, 0);
    }

    public void run() {
        while (this.vornFrei()) {
            this.vor();
        }
    }
}

class FaulerLaufHamster extends LaufHamster {

    FaulerLaufHamster(int r, int s) {
        super(r, s);
        this.setDaemon(true);
    }
}


public void main() {
    LaufHamster paul = new LaufHamster(0, 0);
    LaufHamster heidi = new FaulerLaufHamster(1, 0);
    paul.start();
    heidi.start();
}}