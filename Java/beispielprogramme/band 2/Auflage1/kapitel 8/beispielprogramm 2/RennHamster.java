import de.hamster.debugger.model.Territorium;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.debugger.model.Hamster;class RennHamster extends AllroundHamster {
  
  RennHamster(int reihe) {
    super(reihe, 0, Hamster.OST, 0);
  }
  
  boolean renn() {
    int rennSchritte = 
      Territorium.getAnzahlKoerner(this.getReihe(), 
                                   this.getSpalte());
    if (rennSchritte == 0) {
      if (this.vornFrei()) {
        this.vor();
      }
      return !this.vornFrei();
    }
    for (int i=0; 
         i < rennSchritte;
         i++) {
      if (this.vornFrei()) {
        this.vor();
      } else {
        // geschafft
        return true;
      }
    }
    return !this.vornFrei();
  }
  
  void jubeln() {
    for (int i=0; i<8; i++) {
      this.linksUm();
    }
  }
}
