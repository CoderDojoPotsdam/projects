import de.hamster.debugger.model.Territorium;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.debugger.model.Hamster;class SammelHamster extends Hamster {
    int anzahl;

    SammelHamster(int s) {
      super(0, s, Hamster.SUED, 0);
      this.anzahl = 0;
    }

    void sammle() {
      while (this.kornDa()) {
        this.nimm();
        this.anzahl = this.anzahl + 1;
      }
    }

    void legAb() {
      while (this.anzahl > 0) {
        this.gib();
        this.anzahl = this.anzahl - 1;
      }
    }
}