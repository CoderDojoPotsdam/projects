import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;public class fressendeHamster implements de.hamster.model.HamsterProgram {class FressHamster extends Hamster {

    int gesammelteKoerner = 0;

    void friss() {
        if (this.gesammelteKoerner < 7 && // neues Attribut
                this.getAnzahlKoerner() < 10 &&
                    // geerbte Methode
                this.kornDa()) { // geerbte Methode
            this.nimm(); // geerbte Methode
            this.gesammelteKoerner = this.gesammelteKoerner + 1;
        }
    }
}

public void main() {
    FressHamster paul = new FressHamster();
    paul.init(0, 0, Hamster.NORD, 4);
    paul.friss();
    while (paul.vornFrei()) {
        paul.friss();
        paul.vor();
    }
}}