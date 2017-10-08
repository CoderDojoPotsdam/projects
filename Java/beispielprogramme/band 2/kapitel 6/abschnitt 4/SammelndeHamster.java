import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;public class SammelndeHamster implements de.hamster.model.HamsterProgram {public void main() {
    SammelHamster paul = new SammelHamster(0, 0,
            Hamster.OST, 0);
    paul.laufeUndSammle();

    SammelHamster willi = new SammelHamster(1, 0,
            Hamster.OST, 0);
    willi.laufeUndSammle();

    SammelHamster heidi = new SammelHamster(2, 0,
            Hamster.OST, 0);
    heidi.laufeUndSammle(); // Anweisung 6
}
}