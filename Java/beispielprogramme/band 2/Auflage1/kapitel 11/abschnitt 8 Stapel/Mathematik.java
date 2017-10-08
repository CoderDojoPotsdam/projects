import de.hamster.debugger.model.Territorium;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.debugger.model.Hamster;class Mathematik {
    static int max(int zahl1, int zahl2) {
      if (zahl1 > zahl2) {
        return zahl1;
      } else {
        return zahl2;
      }
    }
}
