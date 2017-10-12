import de.hamster.debugger.model.Territorium;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.debugger.model.Hamster;public class SammelnP implements de.hamster.model.HamsterProgram {class SammelHamsterP extends Hamster {

  SammelHamsterP(int r, int s, int b, int k) {
    super(r, s, b, k);
  }

  public void run() {
    this.laufBisZurMauerUndSammle();
  }

  void laufBisZurMauerUndSammle() {
    this.sammle();
    while (this.vornFrei()) {
      this.vor();
      this.sammle();
    }
  }

  void sammle() {
    while (this.kornDa()) {
      this.nimm();
    }
  }
}

public void main() {
  SammelHamsterP heidi = new SammelHamsterP(1, 0, Hamster.OST, 0);
  SammelHamsterP maria = new SammelHamsterP(2, 0, Hamster.OST, 0);
  heidi.start();
  maria.start();
}
}