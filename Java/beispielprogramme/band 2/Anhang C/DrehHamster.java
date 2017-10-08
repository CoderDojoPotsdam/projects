import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;public class DrehHamster extends SHamster {

    // Singleton-Muster

    private static DrehHamster standardHamster = new DrehHamster(
            true);

    protected DrehHamster(boolean dummy) {
        super(dummy);
    }

    public static DrehHamster getStandardHamsterAlsDrehHamster() {
        return standardHamster;
    }

    // normale Konstruktoren und Methoden

    public DrehHamster(int r, int s, int b, int k) {
        super(r, s, b, k);
    }

    public DrehHamster(Hamster ham) {
        super(ham);
    }

    public void kehrt() {
        this.linksUm();
        this.linksUm();
    }

    public void rechtsUm() {
        this.kehrt();
        this.linksUm();
    }

}