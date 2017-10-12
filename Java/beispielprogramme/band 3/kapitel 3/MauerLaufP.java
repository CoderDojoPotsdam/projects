import de.hamster.debugger.model.Territorium;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.debugger.model.Hamster;public class MauerLaufP implements de.hamster.model.HamsterProgram {class LaufHamsterP extends Hamster {

  LaufHamsterP(int r, int s, int b, int k) {
    super(r, s, b, k);
  }

  public void run() {
    while (this.vornFrei()) {
      this.vor();
    }
  }
}

public void main() {
  LaufHamsterP paul = new LaufHamsterP(1, 0, Hamster.OST, 0);
  LaufHamsterP willi = new LaufHamsterP(2, 0, Hamster.OST, 0);

  paul.start();
  willi.start();
}
}