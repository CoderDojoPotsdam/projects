import de.hamster.debugger.model.Territorium;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.debugger.model.Hamster;class HelferHamster extends AllroundHamster {

  HelferHamster(Hamster existierenderHamster) {
    super(existierenderHamster);
  }

  public void run() {
    this.findeSterbendenHamster();
  }

  void findeSterbendenHamster() {
    do {
      if (this.rechtsFrei()) {
        this.rechtsUm();
        this.vor();
      } else if (this.vornFrei()) {
        this.vor();
      } else if (this.linksFrei()) {
        this.linksUm();
        this.vor();
      } else if (this.hintenFrei()) {
        this.kehrt();
        this.vor();
      }
    } while (Territorium.getAnzahlHamster(this.getReihe(), this.getSpalte()) < 2);
  }
	
}
