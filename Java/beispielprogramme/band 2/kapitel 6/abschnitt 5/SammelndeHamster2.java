import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;public class SammelndeHamster2 implements de.hamster.model.HamsterProgram {public void main() {
    SammelHamster2 paul = new SammelHamster2(0, 0,
            Hamster.OST, 0);
    paul.laufeUndSammle();

    SammelHamster2 willi = new SammelHamster2(1, 0,
            Hamster.OST, 0);
    willi.laufeUndSammle();

    // Aufruf der Klassenmethode
    if (SammelHamster2.getGemeinsamGesammelteKoerner() < 10) {
        SammelHamster2 heidi = new SammelHamster2(2, 0,
                Hamster.OST, 0);
        heidi.laufeUndSammle();
        // ...
    }
}
}