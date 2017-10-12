import de.hamster.debugger.model.Territorium;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.debugger.model.Hamster;public class Prioritaeten1 implements de.hamster.model.HamsterProgram {class LaufHamster extends Hamster {

    LaufHamster(int r, int s, int b, int k) {
        super(r, s, b, k);
    }

    public void run() {
        while (this.vornFrei()) {
            this.vor();
        }
    }
}

public void main() {
    LaufHamster paul = new LaufHamster(0, 0, Hamster.OST, 0);
    LaufHamster heidi = new LaufHamster(1, 0, Hamster.OST, 0);
    paul.setPriority((Thread.MAX_PRIORITY + Thread.MIN_PRIORITY) / 2);
    heidi.setPriority(paul.getPriority() - 1);
    paul.start();
    heidi.start();
}}