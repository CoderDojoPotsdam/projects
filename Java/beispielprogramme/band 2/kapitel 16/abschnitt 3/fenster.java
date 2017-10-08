import javax.swing.JFrame;
import javax.swing.JLabel;

import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;public class fenster implements de.hamster.model.HamsterProgram {class SammelHamster extends Hamster {

    SammelHamster(int r, int s, int b) {
        super(r, s, b, 0);
    }

    public void schreib(String zeichenkette) {
        JFrame fenster = new JFrame("Schreib-Fenster");
        fenster
                .setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JLabel ausgabe = new JLabel(zeichenkette);
        fenster.add(ausgabe);
        fenster.setLocation(100, 200);
        fenster.pack();
        fenster.setVisible(true);
    }

    void laufeUndSammle() {
        while (this.vornFrei()) {
            this.vor();
            this.sammle();
        }
    }

    void sammle() {
        while (this.kornDa()) {
            this.nimm();
        }
    }
}

public void main() {
    SammelHamster paul = new SammelHamster(0, 0, Hamster.OST);
    paul.laufeUndSammle();
    paul.schreib("Ich habe " + paul.getAnzahlKoerner()
            + " Koerner im Maul!");

    Hamster willi = Hamster.getStandardHamster();
    willi.schreib("Ich habe " + willi.getAnzahlKoerner()
            + " Koerner im Maul!");
}}