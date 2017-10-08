import java.util.Observable;
import java.util.Observer;

import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;public class observerprogramm implements de.hamster.model.HamsterProgram {class SuchHamster extends Observable {
    Hamster hamster;

    SuchHamster(Hamster ham) {
        this.hamster = new Hamster(ham);
    }

    void reiheAbsuchen() {
        while (this.hamster.vornFrei()) {
            this.hamster.vor();
            if (this.hamster.kornDa()) {
                this.setChanged();
                this.notifyObservers(new Kachel(this.hamster
                        .getReihe(), this.hamster.getSpalte()));
            }
        }
    }
}

class FaulerHamster extends AllroundHamster implements Observer {

    FaulerHamster(int r, int s, int b, int k) {
        super(r, s, b, k);
    }

    public void update(Observable o, Object arg) {
        SuchHamster suchHamster = (SuchHamster) o;
        Kachel kachel = (Kachel) arg;
        this.laufeZuKachel(kachel.getReihe(), kachel.getSpalte());
        if (this.kornDa()) {
            this.nimm();
        }
    }

}

public void main() {
    SuchHamster paul = new SuchHamster(Hamster
            .getStandardHamster());
    FaulerHamster willi = new FaulerHamster(0, 0,
            Hamster.OST, 0);
    paul.addObserver(willi);
    FaulerHamster karl = new FaulerHamster(Territorium
            .getAnzahlReihen() - 1, Territorium
            .getAnzahlSpalten() - 1, Hamster.NORD, 0);
    paul.addObserver(karl);

    paul.reiheAbsuchen();
}}