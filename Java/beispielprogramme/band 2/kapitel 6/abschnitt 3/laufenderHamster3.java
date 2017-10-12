import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;public class laufenderHamster3 implements de.hamster.model.HamsterProgram {public void main() {
    LaufHamster3 paul = new LaufHamster3(0, 0, Hamster.OST,
            0, 9);
    while (paul.vornFrei()) {
        paul.lauf();
    }

    Hamster heidi = Hamster.getStandardHamster();

    LaufHamster3 willi = new LaufHamster3(2, 0, Hamster.OST,
            0, heidi.getAnzahlKoerner());
    while (willi.vornFrei()) {
        willi.lauf();
    }

    // LaufHamster3 karl = new LaufHamster3(); // Fehler!
}
}