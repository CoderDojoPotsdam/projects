import java.util.Calendar;

import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;public class mittag2 implements de.hamster.model.HamsterProgram {public void main() {
    // repraesentiert Mittags 12.00 Uhr
    Calendar mittag = Calendar.getInstance();
    mittag.set(Calendar.HOUR_OF_DAY, 12);
    mittag.set(Calendar.MINUTE, 0);
    mittag.set(Calendar.SECOND, 0);
    mittag.set(Calendar.MILLISECOND, 0);

    Calendar uhr = Calendar.getInstance();
    if (uhr.before(mittag)) {
        Hamster.getStandardHamster().schreib(
                "Es ist noch kein Mittag!");
    } else {
        Hamster.getStandardHamster().schreib(
                "Mittag ist bereits vorbei!");
    }
}}