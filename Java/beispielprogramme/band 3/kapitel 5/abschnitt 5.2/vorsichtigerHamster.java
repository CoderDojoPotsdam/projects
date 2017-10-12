import de.hamster.debugger.model.Territorium;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.debugger.model.Hamster;public class vorsichtigerHamster implements de.hamster.model.HamsterProgram {class RHamster extends Hamster {

    public RHamster(int r, int s, int b, int k) {
        super(r, s, b, k);
    }

    public void vor() {
        if (Thread.currentThread() == this) {
            super.vor();
        } else {
            throw new RuntimeException();
        }
    }

    public void linksUm() {
        if (Thread.currentThread() == this) {
            super.linksUm();
        } else {
            throw new RuntimeException();
        }
    }

    // ... weitere Methoden analog

    public void run() {
        while (vornFrei()) {
            vor();
        }
    }
}

public void main() {
    RHamster h = new RHamster(0, 0, Hamster.OST, 0);
    h.start();
    h.vor();       // es wird eine RuntimeException geworfen
    h.linksUm();   // wird nicht mehr ausgefuehrt
}}