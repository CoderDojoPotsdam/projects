import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;public class hamsterprogramm implements de.hamster.model.HamsterProgram {public void main() {
    AbgrassHamster paul = new AbgrassHamster();
    paul.init(0, 0, Hamster.OST, 0);
    paul.ernteEineReiheUndLaufeZurueck();
    while (paul.weitereReiheExistiert()) {
        paul.begibDichInNaechsteReihe();
        paul.ernteEineReiheUndLaufeZurueck();
    }
}

class AbgrassHamster extends Hamster {

    boolean weitereReiheExistiert() {
        this.linksUm();
        if (this.vornFrei()) {
            this.rechtsUm();
            return true;
        } else {
            this.rechtsUm();
            return false;
        }
    }

    void begibDichInNaechsteReihe() {
        this.linksUm();
        this.vor();
        this.linksUm();
    }

    void ernteEineReiheUndLaufeZurueck() {
        this.ernteEineReihe();
        this.kehrt();
        this.laufeZurueck();
    }

    void ernteEineReihe() {
        this.sammle();
        while (this.vornFrei()) {
            this.vor();
            this.sammle();
        }
    }

    void laufeZurueck() {
        while (this.vornFrei()) {
            this.vor();
        }
    }

    void sammle() {
        while (this.kornDa()) {
            this.nimm();
        }
    }

    void rechtsUm() {
        this.kehrt();
        this.linksUm();
    }

    void kehrt() {
        this.linksUm();
        this.linksUm();
    }
}
}