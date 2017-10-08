import de.hamster.debugger.model.Territorium;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.debugger.model.Hamster;public class hamsterprogramm implements de.hamster.model.HamsterProgram {public void main() {
  AbgrasExceptionHamster paul = 
    new AbgrasExceptionHamster(0, 0, Hamster.OST, 0);
  paul.ernteEineReihe();
  while (paul.weitereReiheExistiert()) {
    paul.begibDichInNaechsteReihe();
    paul.ernteEineReihe();
  }
}
}