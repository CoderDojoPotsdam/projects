import de.hamster.debugger.model.Territorium;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.debugger.model.Hamster;public class holdsLock implements de.hamster.model.HamsterProgram {public void main() {
    Hamster paul = Hamster.getStandardHamster();
    Object sperrObjekt = new Object();

    if (Thread.holdsLock(sperrObjekt)) {
        paul.schreib("Ich halte den Lock!");
    } else {
        paul.schreib("Ich halte den Lock nicht!");
    }

    synchronized (sperrObjekt) {
        if (Thread.holdsLock(sperrObjekt)) {
            paul.schreib("Ich halte den Lock!");
        } else {
            paul.schreib("Ich halte den Lock nicht!");
        }
    }
}}