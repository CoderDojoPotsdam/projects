import de.hamster.debugger.model.Territorium;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.debugger.model.Hamster;public class hamsterprogramm implements de.hamster.model.HamsterProgram {abstract class HamsterBefehlException extends Exception {
    abstract String getFehlermeldung();
}

class KachelIstLeerException extends HamsterBefehlException { 
    String getFehlermeldung() {
      return "Leere Kachel!";
    }
}

class MaulIstLeerException extends HamsterBefehlException { 
    String getFehlermeldung() {
      return "Leeres Maul!";
    }
}

class MeinHamster extends Hamster {

    MeinHamster(int r, int s, int b, int k) {
      super(r, s, b, k);
    }

    void vorsichtigesNimm() throws KachelIstLeerException {
      if (!this.kornDa()) {
        throw new KachelIstLeerException();
      }
      this.nimm();
    }

    void vorsichtigesGib() throws MaulIstLeerException {
      if (this.maulLeer()) {
        throw new MaulIstLeerException();
      }
      this.gib();
    }
}

public void main() {
    MeinHamster paul = new MeinHamster(3, 5, Hamster.OST, 5);
    try {
      boolean gerade = true;
      while (paul.vornFrei()) {
        if (gerade) {
          paul.vorsichtigesNimm();
        } else {
          paul.vorsichtigesGib();
          paul.vorsichtigesGib();
        }
        gerade = !gerade;
        paul.vor();
      }
    } catch (HamsterBefehlException hamsterFehler) {
      paul.schreib(hamsterFehler.getFehlermeldung());
    }
}
}