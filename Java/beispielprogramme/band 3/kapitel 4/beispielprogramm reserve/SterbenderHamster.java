import de.hamster.debugger.model.Territorium;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.debugger.model.Hamster;class SterbenderHamster extends Hamster {

  SterbenderHamster() {
    super();
    // der Hamster wird irgendwo im Labyrinth platziert
    int reihe = (int)(Math.random() * Territorium.getAnzahlReihen());
    int spalte = (int)(Math.random() * Territorium.getAnzahlSpalten());
    while (Territorium.mauerDa(reihe, spalte)) {
      reihe = (int)(Math.random() * Territorium.getAnzahlReihen());
      spalte = (int)(Math.random() * Territorium.getAnzahlSpalten());
    }
    int blickrichtung = (int)(Math.random() * 4);
    int koerner = (int)(Math.random() * 10 + 10);
    this.init(reihe, spalte, blickrichtung, koerner);
  }

  public void run() {
    // der Hamster hat sich ein Bein gebrochen
    this.rufeUmHilfe();
  }

  void rufeUmHilfe() {
    // so lange der Hamster noch Koerner zum Lutschen im Maul hat,
    // kann er um Hilfe rufen; dies tut er alle 5 Sekunden
    while (!this.maulLeer() &&
           Territorium.getAnzahlHamster(this.getReihe(), this.getSpalte()) < 2) {
      this.gib(); // das Korn ist "verbraucht"
        new SchreibThread(this,
          "Hilfe! Mir bleiben nur noch " +
          (this.getAnzahlKoerner() * 5) +
          " Sekunden zum Leben.\nSonst verhungere ich!");
      try {
        Thread.sleep(5000);
      } catch (Exception exc) {}
    }
    if (Territorium.getAnzahlHamster(this.getReihe(), this.getSpalte()) == 2) {
      new SchreibThread(this, "Juchu! Gerettet!");
    } else {
      new SchreibThread(this, "Das wars! Ich bin erledigt!");
    }
  }
}

      
  
  