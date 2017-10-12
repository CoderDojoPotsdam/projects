import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;public class foreach_setprogramm implements de.hamster.model.HamsterProgram {public void main() {
    AllroundHamster paul = new AllroundHamster(Hamster
            .getStandardHamster());

    Set<Kachel> kachelSpeicher = new HashSet<Kachel>();

    Random zufall = new Random();
    while (!paul.maulLeer()) {
        int reihe = zufall.nextInt(Territorium
                .getAnzahlReihen());
        int spalte = zufall.nextInt(Territorium
                .getAnzahlSpalten());
        paul.laufeZuKachel(reihe, spalte);
        paul.gib();
        kachelSpeicher.add(new Kachel(reihe, spalte));
    }

    AllroundHamster willi = new AllroundHamster(Hamster
            .getStandardHamster());

    for (Kachel kachel : kachelSpeicher) {
        willi.laufeZuKachel(kachel.getReihe(), kachel
                .getSpalte());
        willi.nimm();
    }
}}