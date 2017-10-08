import de.hamster.debugger.model.Territorium;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.debugger.model.Hamster;class Bundeswehr {
  static SoldatenHamster[] erzeugeSoldaten(int anzahl) {
    SoldatenHamster[] soldaten = new SoldatenHamster[anzahl];
    for (int i=0; i<anzahl; i++) {
      soldaten[i] = new SoldatenHamster(0, i, Hamster.SUED, 0);
    }
    // ein Verweigerer schleicht sich unter die Soldaten
    soldaten[anzahl-1] = 
      new VerweigererHamster(0, anzahl-1, Hamster.SUED, 0);
    return soldaten;
  }
}
