import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;public class hamsterprogramm implements de.hamster.model.HamsterProgram {class LangsamerHamster extends Hamster {

    void lauf() {
        if (!this.vornFrei()) {
            this.linksUm();
        }
        this.vor();
    }
}

class SchnellerHamster extends Hamster {

    int schritte = 0;

    void lauf() {
        this.laufEinenSchritt();
        this.laufEinenSchritt();
    }

    void laufEinenSchritt() {
        if (!this.vornFrei()) {
            this.linksUm();
        }
        this.vor();
        this.schritte = this.schritte + 1;
    }

    void jubeln() {
        this.kehrt();
        while (this.schritte > 0) {
            if (!this.vornFrei()) {
                this.rechtsUm();
            }
            this.vor();
            this.schritte = this.schritte - 1;
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

public void main() {
    Hamster paul = Hamster.getStandardHamster();
    LangsamerHamster schnecke = new LangsamerHamster();
    schnecke.init(paul.getReihe(), paul.getSpalte(), paul
            .getBlickrichtung(), paul.getAnzahlKoerner());
    SchnellerHamster speedy = new SchnellerHamster();
    speedy.init(0, 0, Hamster.SUED, 0);

    while (!(speedy.getReihe() == schnecke.getReihe() && speedy
            .getSpalte() == schnecke.getSpalte())) {
        schnecke.lauf();
        speedy.lauf();
    }
    speedy.jubeln();
}}