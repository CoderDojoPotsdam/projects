import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;public class SocketNachmachHamster extends NachmachHamster {

    public SocketNachmachHamster(Hamster hamster, String host,
            int port) {
        super(hamster);
        try {
            Socket socket = new Socket(host, port);
            this.quelle = new BufferedReader(
                    new InputStreamReader(socket
                            .getInputStream()));
        } catch (Exception exc) {
            this.quelle = null;
        }
    }
}