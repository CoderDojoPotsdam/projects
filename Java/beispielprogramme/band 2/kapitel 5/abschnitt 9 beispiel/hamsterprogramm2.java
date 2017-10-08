import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;public class hamsterprogramm2 implements de.hamster.model.HamsterProgram {public void main() {
    DrehHamster maria = new DrehHamster();
    maria.init(3, 5, Hamster.OST, 0);

    while (maria.vornFrei()) {
        maria.vor();
    }

    maria.rechtsUm();

    while (maria.vornFrei()) {
        maria.vor();
    }
}
}