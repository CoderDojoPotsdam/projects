import java.io.FileWriter;
import java.io.PrintWriter;

import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;public class IOVormachHamster extends VormachHamster {

    public IOVormachHamster(Hamster hamster, String dateiName) {
        super(hamster);
        try {
            this.senke = new PrintWriter(new FileWriter(
                    dateiName));
        } catch (Exception exc) {
            this.senke = null;
        }
    }
}