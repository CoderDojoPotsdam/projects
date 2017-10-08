import de.hamster.debugger.model.Territorium;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.debugger.model.Hamster;public class hamsterprogramm implements de.hamster.model.HamsterProgram {class KachelIstLeerException extends Exception { }
class MaulIstLeerException extends Exception { }

class MeinHamster extends Hamster {

    MeinHamster(int r, int s, int b, int k) {
      super(r, s, b, k);
    }

    MeinHamster(Hamster hamster) {
      super(hamster);
    }

    void kehrt() {
      this.linksUm();
      this.linksUm();
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
    MeinHamster paul = null, willi = null;

    try {
      paul = new MeinHamster(7, 6, Hamster.NORD, 0);
      paul.vorsichtigesNimm();
      while (paul.vornFrei()) {
        paul.vor();
        paul.vorsichtigesNimm();
      }
      paul.kehrt();
      willi = new MeinHamster(paul);
      if (!willi.kornDa()) {
        willi.vorsichtigesGib();
      }
      while (willi.vornFrei()) {
        willi.vor();
        if (!willi.kornDa()) {
          willi.vorsichtigesGib();
        }
      }
    } catch (KachelIstLeerException exc) {
      paul.schreib("Fehler auf dem Hinweg!");
    } catch (MaulIstLeerException exc) {
      willi.schreib("Fehler auf dem Rueckweg!");
    }
}
}