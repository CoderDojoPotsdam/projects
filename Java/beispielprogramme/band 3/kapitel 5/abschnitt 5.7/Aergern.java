import de.hamster.debugger.model.Territorium;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.debugger.model.Hamster;public class Aergern implements de.hamster.model.HamsterProgram {class MuederHamster extends Hamster {

    final static int VERDAUUNGSZEIT = 1000;

    MuederHamster(Hamster hamster) {
        super(hamster);
    }

    public void run() {
        this.sammle();
        while (this.vornFrei()) {
            this.vor();
            this.sammle();
        }
    }

   private void sammle() {
       while (this.kornDa()) {
           this.nimm();
           this.verdauen();
       }
    }

    private void verdauen() {
        try {
            Thread.sleep(VERDAUUNGSZEIT);
        } catch (InterruptedException exc) {
            // nicht genuegend Zeit zum Verdauen;
            // das Korn wird wieder ausgespuckt
            this.gib();
        }
    }  

    public void stoeren() {
        this.interrupt();
    }
}

public void main() {
    MuederHamster faulpelz = new MuederHamster(Hamster.getStandardHamster());
    faulpelz.start();

    // Main-Thread aergert den Faulpelz
    while (faulpelz.isAlive()) {
        try {
            Thread.sleep((int)(Math.random() * 2000));
        } catch (InterruptedException exc) {
        }
        faulpelz.stoeren();
    }
}}