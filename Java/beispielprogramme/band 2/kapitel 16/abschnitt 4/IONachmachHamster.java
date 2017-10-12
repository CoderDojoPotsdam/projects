import java.io.BufferedReader;
import java.io.FileReader;

import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;public class IONachmachHamster extends NachmachHamster {

    public IONachmachHamster(Hamster hamster, String dateiName) {
        super(hamster);
        try {
            this.quelle = new BufferedReader(new FileReader(
                    dateiName));
        } catch (Exception exc) {
            this.quelle = null;
        }
    }
}