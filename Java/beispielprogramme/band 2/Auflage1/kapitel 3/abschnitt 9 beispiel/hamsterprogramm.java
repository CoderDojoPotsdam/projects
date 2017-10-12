import de.hamster.debugger.model.Territorium;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.debugger.model.Hamster;public class hamsterprogramm implements de.hamster.model.HamsterProgram {public void main() {
    Hamster paul = Hamster.getStandardHamster();

    // paul laeuft bis zur naechsten Mauer
    while (paul.vornFrei()) {
      paul.vor(); 
    }

    // ein neuer Hamster wird auf der Kachel erzeugt, 
    // auf der sich paul nun aktuell befindet
    Hamster willi = new Hamster();
    willi.init(paul.getReihe(), 
               paul.getSpalte(), 
               (paul.getBlickrichtung()+2) % 4, // entgegengesetzte 
                                                // Richtung
               0);
    // willi laeuft den Weg zurueck
    while (willi.vornFrei()) {
      willi.vor(); 
    }
}
}