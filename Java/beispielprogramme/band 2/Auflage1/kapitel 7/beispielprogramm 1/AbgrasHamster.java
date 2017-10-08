import de.hamster.debugger.model.Territorium;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.debugger.model.Hamster;class AbgrasHamster extends AllroundHamster {
  
  AbgrasHamster(Hamster hamster) {
    super(hamster);
  }
  
  // grast das komplette Territorium ab
  void abgrasen() {
    int r = 0;
    while (r < Territorium.getAnzahlReihen()) {
      int s = 0;
      while (s < Territorium.getAnzahlSpalten()) {
        if (Territorium.getAnzahlKoerner(r, s) > 0) {
          this.gotoKachel(r, s);
          this.nimm(Territorium.getAnzahlKoerner(r, s));
        }
        s = s + 1;
      }
      r = r + 1;
    }
  }

}