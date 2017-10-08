import java.io.PrintWriter;

import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;public class VormachHamster extends AllroundHamster {

    protected PrintWriter senke;

    protected VormachHamster(Hamster hamster) {
        super(hamster);
        this.senke = null;
    }

    public void vor() {
        super.vor();
        if (this.senke != null) {
            this.senke.println("vor");
        }
    }

    public void linksUm() {
        super.linksUm();
        if (this.senke != null) {
            this.senke.println("linksUm");
        }
    }

    public void gib() {
        super.gib();
        if (this.senke != null) {
            this.senke.println("gib");
        }
    }

    public void nimm() {
        super.nimm();
        if (this.senke != null) {
            this.senke.println("nimm");
        }
    }

    public void macheVor() {
        while (!this.maulLeer()) {
            int reihe = this.zufallsZahl(Territorium
                    .getAnzahlReihen());
            int spalte = this.zufallsZahl(Territorium
                    .getAnzahlSpalten());
            this.laufeZuKachel(reihe, spalte);
            this.gib();
        }
    }

    public void beendeArbeit() {
        if (this.senke != null) {
            this.senke.close();
        }
    }

    // erzeugt Zufallszahlen zwischen 0 und max-1
    private int zufallsZahl(int max) {
        return (int) (Math.random() * max);
    }
}