import java.util.Random;
import java.util.Stack;

import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;public class stackprogramm implements de.hamster.model.HamsterProgram {public void main() {
    AllroundHamster paul = new AllroundHamster(Hamster
            .getStandardHamster());

    Stack<Kachel> kachelSpeicher = new Stack<Kachel>();

    Random zufall = new Random();
    while (!paul.maulLeer()) {
        int reihe = zufall.nextInt(Territorium
                .getAnzahlReihen());
        int spalte = zufall.nextInt(Territorium
                .getAnzahlSpalten());
        paul.laufeZuKachel(reihe, spalte);
        paul.gib();
        kachelSpeicher.push(new Kachel(reihe, spalte));
    }

    AllroundHamster willi = new AllroundHamster(Hamster
            .getStandardHamster());

    while (!kachelSpeicher.isEmpty()) {
        Kachel kachel = kachelSpeicher.pop();
        willi.laufeZuKachel(kachel.getReihe(), kachel
                .getSpalte());
        willi.nimm();
    }
}}