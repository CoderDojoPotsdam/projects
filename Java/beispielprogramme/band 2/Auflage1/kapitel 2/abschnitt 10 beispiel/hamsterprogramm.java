import de.hamster.debugger.model.Territorium;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;public class hamsterprogramm extends de.hamster.debugger.model.IHamster implements de.hamster.model.HamsterProgram {void hinUndZurueck() {
    if (vornFrei()) {
      vor();
      hinUndZurueck();  // rekursiver Funktionsaufruf
      vor();
    } else {
      linksUm(); linksUm();
    }
}

public void main() {
    // der Hamster laeuft zur naechsten Wand und zurueck
    hinUndZurueck();
}
}