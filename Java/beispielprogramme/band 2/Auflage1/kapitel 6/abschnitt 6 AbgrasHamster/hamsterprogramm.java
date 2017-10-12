import de.hamster.debugger.model.Territorium;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.debugger.model.Hamster;public class hamsterprogramm implements de.hamster.model.HamsterProgram {class AbgrasHamster extends Hamster {
    AbgrasHamster(int r, int s, int b, int k) {
      this.init(r, s, b, k);
    }

    void sammle() {
      while (this.kornDa()) {
        this.nimm();
      }
    }

    void laufeUndSammle() {
      this.sammle();
      while (this.vornFrei()) {
        this.vor();
        this.sammle();
      }
    }
}

public void main() {
    int zeile = 0;
    while (!Territorium.mauerDa(zeile, 0)) {
      AbgrasHamster paul = 
        new AbgrasHamster(zeile, 0, Hamster.OST, 0);
      paul.laufeUndSammle();
      zeile = zeile + 1;
    }
}
}