import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;public class HamsterKlassenmethoden implements de.hamster.model.HamsterProgram {public void main() {
    Hamster paul = Hamster.getStandardHamster();
    while (Hamster.getAnzahlHamster() <= 5) {
        paul = new Hamster(paul.getReihe(),
                paul.getSpalte(), paul.getBlickrichtung(), 0);
        if (paul.kornDa()) {
            paul.nimm();
        }
        while (paul.vornFrei()) {
            paul.vor();
            if (paul.kornDa()) {
                paul.nimm();
            }
        }
        paul.linksUm();
        paul.linksUm();
    }
}
}