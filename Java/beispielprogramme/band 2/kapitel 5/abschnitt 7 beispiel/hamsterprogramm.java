import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;public class hamsterprogramm implements de.hamster.model.HamsterProgram {public void main() {
    // Erzeugung und Initial. zweier erweiterter Hamster
    MeinHamster paul = new MeinHamster();
    MeinHamster willi = new MeinHamster();
    paul.init(2, 2, Hamster.NORD, 4);
    willi.init(3, 4, Hamster.NORD, 7);

    paul.sammle(); // Aufruf der neuen Methode sammle
    willi.sammle();
    while (paul.vornFrei() && // Aufruf des
            willi.vornFrei()) { // normalen Hamster-Befehls
        paul.vor();
        paul.sammle();
        willi.vor();
        willi.sammle();
    }
    paul.legeGesammelteKoernerAb();
    willi.legeGesammelteKoernerAb();
}
}