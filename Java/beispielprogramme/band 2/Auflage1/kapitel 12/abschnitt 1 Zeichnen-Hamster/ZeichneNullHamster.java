import de.hamster.debugger.model.Territorium;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.debugger.model.Hamster;class ZeichneNullHamster extends ZeichneZifferHamster {
    ZeichneNullHamster(int r, int s, int b, int k) {
      super(r, s, b, k);
    }

    // zeichnet die Ziffer 0 mit Koernern ins Territorium
    void zeichne() {  // ueberschriebene und implementierte Methode
      this.vorUndGib(3);
      this.rechtsUm();
      this.vorUndGib(4);
      this.rechtsUm();
      this.vorUndGib(2);
      this.rechtsUm();
      this.vorUndGib(3);
      this.vor();
      this.linksUm();
      this.vor();
      this.kehrt();
    }
}