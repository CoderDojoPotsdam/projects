import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;public class hamsterprogramm implements de.hamster.model.HamsterProgram {public void main() {
    CheckUndSammelHamster paul = new CheckUndSammelHamster(
            0, 0, Hamster.OST, 9);
    if (paul.hintenFrei()) {
        paul.kehrt();
        paul.vor();
        paul.sammle();
    }
    CheckHamster willi = paul;
    if (willi.hintenFrei()) {
        // willi.kehrt(); // Fehler
    }
    SammelHamster karin = paul;
    karin.sammle();
    // karin.vor(); // Fehler
}}