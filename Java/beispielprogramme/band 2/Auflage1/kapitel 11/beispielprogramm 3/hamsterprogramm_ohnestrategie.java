import de.hamster.debugger.model.Territorium;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.debugger.model.Hamster;public class hamsterprogramm_ohnestrategie implements de.hamster.model.HamsterProgram {public void main() {
  Hamster karl = Hamster.getStandardHamster();
  int anzahl = karl.liesZahl("Laenge der Koernerreihe?");
  SpielHamster paul = 
    new SpielHamster(0, 0, Hamster.OST, 0, anzahl);
  SpielHamster willi = 
    new SpielHamster(0, 0, Hamster.OST, 0, anzahl);

  NimmSpiel spiel = new NimmSpiel(paul, willi, anzahl);
  SpielHamster sieger = spiel.spielen();

  // der Sieger darf eine Ehrenrunde laufen
  sieger.laufeEhrenrunde();
}
}