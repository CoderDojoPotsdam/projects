import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;public class SocketVormachHamster extends VormachHamster {

    public SocketVormachHamster(Hamster hamster, int port) {
        super(hamster);
        try {
            ServerSocket serverSock = new ServerSocket(port);
            Socket socket = serverSock.accept();
            this.senke = new PrintWriter(new OutputStreamWriter(
                    socket.getOutputStream()), true);
        } catch (Exception exc) {
            this.senke = null;
        }
    }
}