import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;public class HamsterKonstruktoren implements de.hamster.model.HamsterProgram {public void main() {
    // Aufruf des Konstruktors in Zeile 6
    Hamster paul = new Hamster(1, 0, Hamster.NORD, 3);
    paul.vor(); // ok
    
    // Aufruf des Copy-Konstruktors in Zeile 14
    Hamster manfred = new Hamster(paul);
    paul.vor(); // ok

    // Aufruf des Konstruktors in Zeile 10
    Hamster willi = new Hamster();
    willi.vor(); // Programmabbruch, da willi nicht 
                 // initialisiert wurde
}}