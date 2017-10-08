import java.util.Calendar;

import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;public class mittag1 implements de.hamster.model.HamsterProgram {public void main() {
    Calendar uhr = Calendar.getInstance();
    int aktuelleStunde = uhr.get(Calendar.HOUR_OF_DAY);
    if (aktuelleStunde < 12) {
        Hamster.getStandardHamster().schreib(
                "Es ist noch kein Mittag!");
    } else {
        Hamster.getStandardHamster().schreib(
                "Mittag ist bereits vorbei!");
    }
}}