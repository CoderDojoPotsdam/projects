import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;public class sammelnUndLegen implements de.hamster.model.HamsterProgram {public void main() {
    SammelUndLegHamster paul = new SammelUndLegHamster();
    paul.init(2, 3, Hamster.NORD, 9);
    SammelUndLegAlleHamster willi = new SammelUndLegAlleHamster();
    willi.init(2, 5, Hamster.NORD, 4);

    while (paul.vornFrei() && willi.vornFrei()) {
        paul.sammle();
        paul.vor();
        willi.sammle();
        willi.vor();
    }
    paul.legAb();  // Ausfuehrung der Methode in der
                   // Klasse SammelUndLegHamster
    willi.legAb(); // Ausfuehrung der Methode in der
                   // Klasse SammelUndLegAlleHamster
}}