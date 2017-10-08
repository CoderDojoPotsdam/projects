import de.hamster.debugger.model.Territorium;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.debugger.model.Hamster;public class beispiel1 implements de.hamster.model.HamsterProgram {public void main() {
  Hamster paul = new Hamster(1, 0, Hamster.OST, 0);
  Hamster willi = new Hamster(2, 0, Hamster.OST, 0);

  // paul und willi laufen so lange abwechselnd nach
  // vorne, bis einer bei einer Mauer angelangt ist
  while (paul.vornFrei() && willi.vornFrei()) {
    paul.vor();
    willi.vor();
  }

  // evtl. hat paul noch nicht die naechste Mauer erreicht
  while (paul.vornFrei()) {
    paul.vor();
  }

  // evtl. hat willi noch nicht die naechste Mauer erreicht
  while (willi.vornFrei()) {
    willi.vor();
  }

}}