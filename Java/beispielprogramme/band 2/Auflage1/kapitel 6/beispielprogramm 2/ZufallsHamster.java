import de.hamster.debugger.model.Territorium;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.debugger.model.Hamster;class ZufallsHamster extends Hamster {

  // Subobjekt
  ZufallsHamster nachwuchs;
  
  // Konstruktor
  ZufallsHamster() {
    // ein neuer Hamster wird zufaellig irgendwo im
    // Territorium erzeugt
    int r = ZufallsHamster.erzeugeZufallsZahl(
              Territorium.getAnzahlReihen()-1);
    int s = ZufallsHamster.erzeugeZufallsZahl(
              Territorium.getAnzahlSpalten()-1);
    int b = ZufallsHamster.erzeugeZufallsZahl(3);
    this.init(r, s, b, 0);
    this.nachwuchs = null;
  }
  
  void lauf() {
    // der Hamster laeuft zufaellig irgendwohin
    int zahl = ZufallsHamster.erzeugeZufallsZahl(3);
    if (zahl == 0) {
      if (this.vornFrei()) this.vor();
    } else if (zahl == 1) {
      this.linksUm();
      if (this.vornFrei()) this.vor();
    } else if (zahl == 2) {
      this.kehrt();
      if (this.vornFrei()) this.vor();
    } else {
      this.rechtsUm();
      if (this.vornFrei()) this.vor();
    }

    // falls Nachwuchs vorhanden ist, darf dieser auch laufen
    if (this.nachwuchs != null) {
      this.nachwuchs.lauf();
    }
    
    // falls sich auf der neuen Kachel schon Hamster befinden,
    // und der Hamster noch keinen Nachwuchs hat,
    // "paart" er sich und erzeugt Nachwuchs
    if (Territorium.getAnzahlHamster(this.getReihe(),
                                     this.getSpalte()) > 1 &&
        this.nachwuchs == null
       ) {
      this.nachwuchs = new ZufallsHamster();
        // Aufruf des obigen Konstruktors und damit 
        // "Zufallsinitialisierung"
    }
  }

  void rechtsUm() {
    this.kehrt();
    this.linksUm();
  }

  void kehrt() {
    this.linksUm();
    this.linksUm();
  }
  
  // erzeugt Zufallszahl zwischen 0 und max
  static int erzeugeZufallsZahl(int max) {
    return (int)(Math.random() * (max+1));
  }
}
