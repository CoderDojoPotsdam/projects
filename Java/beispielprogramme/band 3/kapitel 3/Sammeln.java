import de.hamster.debugger.model.Territorium;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.debugger.model.Hamster;public class Sammeln implements de.hamster.model.HamsterProgram {class SammelHamster extends Hamster {

  SammelHamster(int r, int s, int b, int k) {
    super(r, s, b, k);
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
  SammelHamster heidi = new SammelHamster(1, 0, Hamster.OST, 0);
  SammelHamster maria = new SammelHamster(2, 0, Hamster.OST, 0);
  heidi.laufBisZurMauerUndSammle();
  maria.laufBisZurMauerUndSammle();
}
}