import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;class SchiedsrichterHamster extends Hamster {

    SchiedsrichterHamster(int r, int s) {
        super(r, s, Hamster.OST, 0);
    }

    Wuerfel liefereWuerfel() {
        // erzeugt und liefert einen neuen Wuerfel
        return new Wuerfel();
    }

    int wuerfeln(Wuerfel wuerfel) {
        // wuerfelt mit dem ihm uebergebenen Wuerfel
        return wuerfel.wuerfeln();
    }
}