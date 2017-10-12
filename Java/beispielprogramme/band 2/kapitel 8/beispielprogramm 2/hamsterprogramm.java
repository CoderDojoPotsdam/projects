import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;public class hamsterprogramm implements de.hamster.model.HamsterProgram {public void main() {

    // Erzeugung der Hamster
    RennHamster[] hamster = new RennHamster[Territorium
            .getAnzahlReihen()];
    for (int r = 0; r < Territorium.getAnzahlReihen(); r++) {
        hamster[r] = new RennHamster(r);
    }

    // in diesem Array wird vermerkt, welche Hamster das Ziel
    // erreicht haben
    boolean[] geschafft = new boolean[hamster.length];
    for (int b = 0; b < geschafft.length; b++) {
        geschafft[b] = false;
    }

    // nun gehts los
    boolean ende = false;
    while (!ende) {
        for (int r = 0; r < hamster.length; r++) {
            geschafft[r] = hamster[r].renn();
            ende = ende || geschafft[r];
        }
    }

    // alle Sieger duerfen jubeln
    for (int b = 0; b < geschafft.length; b++) {
        if (geschafft[b]) {
            hamster[b].jubeln();
        }
    }
}}