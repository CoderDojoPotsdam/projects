import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;interface Vergleichbar {
    // ueberprueft, ob das aufgerufene Objekt und das als
    // Parameter uebergebene Objekt bezueglich einer bestimmten
    // Metrik gleich sind
    public abstract boolean gleich(Vergleichbar obj);

    // ueberprueft, ob das aufgerufene Objekt bezueglich einer
    // bestimmten Metrik kleiner als das als Parameter
    // uebergebene Objekt ist
    public abstract boolean kleiner(Vergleichbar obj);

    // ueberprueft, ob das aufgerufene Objekt bezueglich einer
    // bestimmten Metrik groesser als das als Parameter
    // uebergebene Objekt ist
    public abstract boolean groesser(Vergleichbar obj);
}