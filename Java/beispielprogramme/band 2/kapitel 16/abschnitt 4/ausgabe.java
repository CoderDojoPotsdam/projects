import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;public class ausgabe implements de.hamster.model.HamsterProgram {class SenkenHamster extends AllroundHamster {

    PrintWriter senke;

    SenkenHamster(Hamster hamster, String dateiName) {
        super(hamster);
        try {
            senke = new PrintWriter(new FileWriter(dateiName));
        } catch (Exception exc) {
            senke = null;
        }
    }

    public void vor() {
        super.vor();
        if (senke != null) {
            senke.println("vor");
        }
    }

    public void linksUm() {
        super.linksUm();
        if (senke != null) {
            senke.println("linksUm");
        }
    }

    public void gib() {
        super.gib();
        if (senke != null) {
            senke.println("gib");
        }
    }

    void macheVor() {
        while (!maulLeer()) {
            int reihe = zufallsZahl(Territorium
                    .getAnzahlReihen());
            int spalte = zufallsZahl(Territorium
                    .getAnzahlSpalten());
            this.gotoKachel(reihe, spalte);
            this.gib();
        }
    }

    void beendeArbeit() {
        if (senke != null) {
            senke.close();
        }
    }

    // erzeugt Zufallszahlen zwischen 0 und max-1
    int zufallsZahl(int max) {
        return (int) (Math.random() * max);
    }
}

public void main() {
    SenkenHamster paul = new SenkenHamster(Hamster
            .getStandardHamster(), "weg.txt");
    paul.macheVor();
    paul.beendeArbeit();
}}