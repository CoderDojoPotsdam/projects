// Testprogramm
import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;public class hamsterprogramm implements de.hamster.model.HamsterProgram {public void main() {
    QuadratHamster heidi = new QuadratHamster(0, 0,
            Hamster.OST, 100000);
    GefuelltesQuadratHamster maria = new GefuelltesQuadratHamster(
            10, 10, Hamster.OST, 100000);

    heidi.zeichne(0, 0, 6);
    maria.zeichne(7, 7, 11);
}}