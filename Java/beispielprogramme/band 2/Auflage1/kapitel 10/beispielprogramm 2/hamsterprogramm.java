import de.hamster.debugger.model.Territorium;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.debugger.model.Hamster;public class hamsterprogramm implements de.hamster.model.HamsterProgram {public void main() {
  Hamster willi = Hamster.getStandardHamster();
  BergHamster paul = new BergHamster(willi);
                    
  // zunaechst erklimmt paul den Berg
  do {
    paul.erklimmeStufe();
  } while (!paul.gipfelErreicht() &&
           !paul.hoeheErfahren());
  
  paul.kehrt();
  
  // nun klettert er wieder herunter
  while (!paul.talErreicht()) {
    paul.klettereStufeHinab();
  }
  
  // nun teilt er stolz die Hoehe des Berges mit
  paul.schreib("Der Berg ist " + paul.getBergHoehe() +
               " Stufen hoch!");
}
}