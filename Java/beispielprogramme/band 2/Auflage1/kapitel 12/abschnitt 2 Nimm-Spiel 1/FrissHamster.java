import de.hamster.debugger.model.Territorium;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.debugger.model.Hamster;interface FrissHamster {

    // die Methode zum Fressen;
    // uebergeben wird, wie viele Koerner der Gegner gefressen hat;
    // geliefert wird, wie viele Koerner der Hamster gefressen hat
    public abstract int friss(int gegnerAnzahl);
}