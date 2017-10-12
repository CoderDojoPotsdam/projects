import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;public class mapprogramm implements de.hamster.model.HamsterProgram {public void main() {
    AllroundHamster paul = new AllroundHamster(Hamster
            .getStandardHamster());

    Map<Integer, Kachel> kachelSpeicher = new HashMap<Integer, Kachel>();

    Random zufall = new Random();
    while (!paul.maulLeer()) {
        int reihe = zufall.nextInt(Territorium
                .getAnzahlReihen());
        int spalte = zufall.nextInt(Territorium
                .getAnzahlSpalten());
        paul.laufeZuKachel(reihe, spalte);
        paul.gib();
        int id = paul.liesZahl("Identifikator: ");
        while (kachelSpeicher.containsKey(id)) {
            id = paul
                    .liesZahl("Identifikator bereits vergeben, neue Eingabe: ");
        }
        kachelSpeicher.put(id, new Kachel(reihe, spalte));
    }

    AllroundHamster willi = new AllroundHamster(Hamster
            .getStandardHamster());

    while (!kachelSpeicher.isEmpty()) {
        int id = willi.liesZahl("Identifikator: ");
        Kachel kachel = kachelSpeicher.get(id);
        if (kachel != null) {
            willi.laufeZuKachel(kachel.getReihe(), kachel
                    .getSpalte());
            willi.nimm();
            kachelSpeicher.remove(id);
        } else {
            willi.schreib("Ungueltiger Identifikator!");
        }
    }
}}