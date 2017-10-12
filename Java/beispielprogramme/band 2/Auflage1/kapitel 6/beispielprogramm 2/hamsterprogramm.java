import de.hamster.debugger.model.Territorium;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.debugger.model.Hamster;public class hamsterprogramm implements de.hamster.model.HamsterProgram {public void main() {
  // zwei ZufallsHamster werden erzeugt, im Konstruktor
  // der Klasse zufallsmaessig initialisiert und so lange auf die
  // Paarungsreise geschickt, bis es mehr als 8 Hamster 
  // (inkl. Standard-Hamster) gibt
  ZufallsHamster paul = new ZufallsHamster();
  ZufallsHamster heidi = new ZufallsHamster();
  while (Hamster.getAnzahlHamster() <= 8) {
    paul.lauf();
    heidi.lauf();
  }
}}