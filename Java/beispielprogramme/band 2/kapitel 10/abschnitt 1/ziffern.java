import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;public class ziffern implements de.hamster.model.HamsterProgram {public void main() {
    Hamster paul = Hamster.getStandardHamster();
    String zeichenkette = "Der Februar hat 28 oder 29 Tage!";
    for (int i = 0; i < zeichenkette.length(); i++) {
        String zeichen = zeichenkette.substring(i, i + 1);
        if (zeichen.compareTo("0") >= 0
                && zeichen.compareTo("9") <= 0) {
            paul.linksUm();
        }
    }
}}