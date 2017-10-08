import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;public class DrehHamster extends Hamster {

    private static DrehHamster drehHamster = new DrehHamster();
    // erzeugt wird der Hamster genau dann, wenn in einem
    // Programm die Klasse DrehHamster geladen wird

    private DrehHamster() {
        super(0, 0, Hamster.OST, 0);
    }

    public static DrehHamster getDrehHamster() {
        return DrehHamster.drehHamster;
    }

    // public Methoden

    public void drehDich(int anzahl) {
        while (anzahl > 0) {
            this.linksUm();
            anzahl = anzahl - 1;
        }
    }
}