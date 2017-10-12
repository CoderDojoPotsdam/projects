import de.hamster.debugger.model.Territorium;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.debugger.model.Hamster;public class hamsterprogramm implements de.hamster.model.HamsterProgram {public void main() {
  Superhirn paul = new Superhirn();
  if (!paul.ueberpruefeSpielfeld()) {
    paul.schreib("Das Territorium ist nicht gross genug!");
  } else {
    paul.spiele();
  }
}
}