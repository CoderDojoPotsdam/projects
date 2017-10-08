// Fehlertyp: ein String repraesentiert keine Zahl
import de.hamster.debugger.model.Territorium;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.debugger.model.Hamster;class KeineZahlException extends Exception {
  
  String eingabe;
  
  KeineZahlException() {
    super();
    this.eingabe = null;
  }
  
  KeineZahlException(String str) {
    super(str);
    this.eingabe = str;
  }
  
  String getEingabe() {
    return this.eingabe;
  }
}
