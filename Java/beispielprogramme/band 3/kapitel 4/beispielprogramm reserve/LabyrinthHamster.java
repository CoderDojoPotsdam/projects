import de.hamster.debugger.model.Territorium;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.debugger.model.Hamster;class LabyrinthHamster extends AllroundHamster {

  LabyrinthHamster(Hamster existierenderHamster) {
    super(existierenderHamster);
  }

  public void run() {
    this.sucheKoernerHaufen();
    // gefunden, aber genau in diesem Moment
    // bricht sich der Hamster ein Bein
    this.rufeUmHilfe();
  }

  void sucheKoernerHaufen() {
    boolean gefunden = false;
    while (!gefunden) {
      while (this.vornFrei() && !this.rechtsFrei() && !this.kornDa()) {
        vor();
      }
      if (this.kornDa()) { // Koernerhaufen gefunden
        gefunden = true;
      } else if (this.rechtsFrei()) { // rechts ist frei
        this.rechtsUm();
        this.vor();
      } else { // vorne und rechts stehen Mauern
        this.linksUm();
      }
    }
  }

  void rufeUmHilfe() {
    while (this.kornDa()) {
      this.nimm();
      this.schreib("Hilfe!");
      try {
        Thread.sleep(5000);
      } catch (Exception exc) {}
    }
  }
}

      
  
  