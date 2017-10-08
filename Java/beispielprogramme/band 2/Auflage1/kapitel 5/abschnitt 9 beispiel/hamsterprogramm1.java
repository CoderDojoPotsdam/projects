import de.hamster.debugger.model.Territorium;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.debugger.model.Hamster;public class hamsterprogramm1 implements de.hamster.model.HamsterProgram {public void main() {
    int schritte = 0;
    DrehHamster paul = new DrehHamster();
    paul.init(1, 0, Hamster.OST, 0);

    while (paul.vornFrei()) {
      paul.vor();
      schritte = schritte + 1;
    }

    paul.kehrt();

    while (schritte > 0) {
      paul.vor();
      schritte = schritte - 1;
    }
}}