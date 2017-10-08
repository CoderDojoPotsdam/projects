import de.hamster.debugger.model.Territorium;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.debugger.model.Hamster;public class hamsterprogramm implements de.hamster.model.HamsterProgram {public void main() {
  Hamster paul = Hamster.getStandardHamster();
  int spielrunden = paul.liesZahl("Wie viele Spielrunden?");
  BeuteHamster hase = 
    new BeuteHamster(Hamster.getStandardHamster(), spielrunden);
  RaeuberHamster fuchs = 
    new RaeuberHamster(0, 0, Hamster.OST, 0);
  Spiel spiel = new Spiel(hase, fuchs);
  Spieler sieger = spiel.spielen();
  if (sieger == hase) {
    hase.schreib("Beute hat gewonnen!");
  } else {
    fuchs.schreib("Raeuber hat gewonnen!");
  }
}
}