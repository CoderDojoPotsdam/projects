import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;public class queueprogramm implements de.hamster.model.HamsterProgram {public void main() {
    AllroundHamster paul = new AllroundHamster(Hamster
            .getStandardHamster());

    Queue<Kachel> kachelSpeicher = new LinkedList<Kachel>();

    Random zufall = new Random();
    while (!paul.maulLeer()) {
        int reihe = zufall.nextInt(Territorium
                .getAnzahlReihen());
        int spalte = zufall.nextInt(Territorium
                .getAnzahlSpalten());
        paul.laufeZuKachel(reihe, spalte);
        paul.gib();
        kachelSpeicher.offer(new Kachel(reihe, spalte));
    }

    AllroundHamster willi = new AllroundHamster(Hamster
            .getStandardHamster());

    Kachel kachel = kachelSpeicher.poll();
    while (kachel != null) {
        willi.laufeZuKachel(kachel.getReihe(), kachel
                .getSpalte());
        willi.nimm();
        kachel = kachelSpeicher.poll();
    }
}}