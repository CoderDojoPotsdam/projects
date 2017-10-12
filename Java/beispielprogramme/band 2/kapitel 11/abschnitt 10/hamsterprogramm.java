import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;public class hamsterprogramm implements de.hamster.model.HamsterProgram {class MeinHamster extends Hamster {

    MeinHamster(int r, int s, int b, int k) {
        super(r, s, b, k);
    }

    void rechtsUm() {
        this.linksUm();
        this.linksUm();
        this.linksUm();
    }
}

class EinsamerHamster extends AllroundHamster {
    EinsamerHamster(int r, int s, int b, int k) {
        super(r, s, b, k);
    }

    void suchen() {
        this.schreib("Ich suche eine Frau!");
    }
}

public void main() {
    AllroundHamster julia = new AllroundHamster(5, 2,
            Hamster.SUED, 0);
    MeinHamster paul = new MeinHamster(2, 6, Hamster.NORD, 0);
    EinsamerHamster romeo = new EinsamerHamster(3, 4,
            Hamster.OST, 0);
    Sammeln.sammeln(0, 0);
}
}