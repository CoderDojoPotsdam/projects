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

class DummerHamster extends DrehHamster {
    DummerHamster(int r, int s, int b, int k) {
        super(r, s, b, k);
    }

    void rechtsUm() {
        this.linksUm();
        this.linksUm();
        this.linksUm();
        this.linksUm();
        this.linksUm();
        this.linksUm();
        this.linksUm();
    }
}

public void main() {
    /* 1 */ DrehHamster paul = new DrehHamster(0, 0,
                Hamster.OST, 0);
    /* 2 */ paul.rechtsUm();

    /* 3 */ paul = new DummerHamster(1, 1, Hamster.OST, 0);
    /* 4 */ paul.rechtsUm();
}}