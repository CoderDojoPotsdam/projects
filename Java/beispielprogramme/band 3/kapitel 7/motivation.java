import de.hamster.debugger.model.Territorium;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.debugger.model.Hamster;public class motivation implements de.hamster.model.HamsterProgram {class SammelHamster extends Hamster {

    SammelHamster(Hamster hamster) {
        super(hamster);
    }

    public void run() {
        if (kornDa()) {
            nimm();
        }
    }
}

public void main() {
    Hamster paul = new SammelHamster(Hamster.getStandardHamster());
    Hamster karl = new SammelHamster(Hamster.getStandardHamster());
    paul.start();
    karl.start();
}}