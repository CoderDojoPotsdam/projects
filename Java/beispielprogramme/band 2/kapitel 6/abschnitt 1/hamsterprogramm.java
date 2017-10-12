import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;public class hamsterprogramm implements de.hamster.model.HamsterProgram {class MeinHamster extends Hamster {

    void vor(int anzahl) {
        while (this.vornFrei() && anzahl > 0) {
            this.vor();
            anzahl = anzahl - 1;
        }
    }

    void vor(boolean kehrtWende) {
        if (kehrtWende)
            this.kehrt();
        this.vor();
    }

    void kehrt() {
        this.linksUm();
        this.linksUm();
    }
}

public void main() {
    MeinHamster paul = new MeinHamster();
    paul.init(0, 0, Hamster.OST, 0);
    paul.vor();
    paul.vor(10);
    paul.vor(!paul.vornFrei());
}}