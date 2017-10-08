import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;public class beispiel implements de.hamster.model.HamsterProgram {class DrehHamster extends Hamster {
    DrehHamster(int r, int s, int b, int k) {
        super(r, s, b, k);
    }

    void rechtsUm() {
        this.linksUm();
        this.linksUm();
        this.linksUm();
    }
}

public void main() {
    /* 1 */ Hamster paul = new DrehHamster(0, 0, Hamster.OST,
                0);
    /* 2 */ // paul.rechtsUm(); // Fehlermeldung des Compilers

    /* 3 */ DrehHamster willi = (DrehHamster) paul;
    /* 4 */ willi.rechtsUm();

    /* 5 */ ((DrehHamster) paul).rechtsUm();
}}