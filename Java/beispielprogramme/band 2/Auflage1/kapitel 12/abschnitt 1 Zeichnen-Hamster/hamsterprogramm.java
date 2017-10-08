import de.hamster.debugger.model.Territorium;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.debugger.model.Hamster;public class hamsterprogramm implements de.hamster.model.HamsterProgram {public void main() {
    ZeichneZahlHamster paul = 
      new ZeichneZahlHamster(0, 0, Hamster.OST, 1000);
    int zahl = paul.liesZahl("Welche Zahl soll ich zeichnen?");
    paul.zeichne(zahl);
}
}