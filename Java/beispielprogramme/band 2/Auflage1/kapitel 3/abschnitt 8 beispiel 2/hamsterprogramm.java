import de.hamster.debugger.model.Territorium;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.debugger.model.Hamster;public class hamsterprogramm implements de.hamster.model.HamsterProgram {public void main() {
    // ein Hamster namens paul wird erzeugt und initialisiert
    Hamster paul = new Hamster();
    paul.init(0, 0, Hamster.OST, 0);

    // paul erledigt seine Arbeit
    if (paul.kornDa()) {
      paul.nimm();
    }
    while (paul.vornFrei()) {
      paul.vor();
      if (paul.kornDa()) {
        paul.nimm();
      }
    }

    // ein Hamster namens willi wird erzeugt und initialisiert
    Hamster willi = new Hamster();
    willi.init(0, 9, Hamster.WEST, 0);

    // willi erledigt seine Arbeit
    if (willi.kornDa()) {
      willi.nimm();
    }
    while (willi.vornFrei()) {
      willi.vor();
      if (willi.kornDa()) {
        willi.nimm();
      }
    }
 }}