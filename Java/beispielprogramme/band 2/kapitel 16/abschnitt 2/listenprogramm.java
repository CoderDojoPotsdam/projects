import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;public class listenprogramm implements de.hamster.model.HamsterProgram {public void main() {
    AllroundHamster paul = new AllroundHamster(Hamster
            .getStandardHamster());

    List<Kachel> kachelSpeicher = new ArrayList<Kachel>();

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

    while (!kachelSpeicher.isEmpty()) {
        int index = zufall.nextInt(kachelSpeicher.size());
        Kachel kachel = kachelSpeicher.get(index);
        kachelSpeicher.remove(index);
        willi.laufeZuKachel(kachel.getReihe(), kachel
                .getSpalte());
        willi.nimm();
    }
}}