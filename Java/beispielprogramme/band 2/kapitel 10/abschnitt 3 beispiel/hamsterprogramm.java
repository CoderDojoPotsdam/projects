import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;public class hamsterprogramm implements de.hamster.model.HamsterProgram {public void main() {
    Hamster paul = Hamster.getStandardHamster();
    String antwort;
    do {
        int anzahl = paul.liesZahl("Anzahl:");
        while (anzahl > 0) {
            paul.linksUm();
            anzahl = anzahl - 1;
        }
        antwort = paul
                .liesZeichenkette("Noch einmal (ja/nein)?");
    } while (antwort.equals("ja"));
}}