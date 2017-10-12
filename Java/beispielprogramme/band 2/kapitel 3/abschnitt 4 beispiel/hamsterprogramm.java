import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;public class hamsterprogramm implements de.hamster.model.HamsterProgram {public void main() {
    // dem Standard-Hamster wird der Name willi zugeordnet
    Hamster willi = Hamster.getStandardHamster();

    // willi erledigt seine Arbeit
    if (willi.kornDa()) {
        willi.nimm();
    }
    while (willi.vornFrei()) {
        willi.vor();
        if (willi.kornDa()) {
            willi.nimm();
        }
    }
}}