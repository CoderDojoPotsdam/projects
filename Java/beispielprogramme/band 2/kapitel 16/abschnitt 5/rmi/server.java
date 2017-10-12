import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;public class server implements de.hamster.model.HamsterProgram {public void main() {
    try {
        // Server-Objekt sowie Stub erzeugen
        RemoteHamster hamster = new RemoteHamsterImpl(0, 0,
                Hamster.OST, 0);
        RemoteHamster hamsterStub = (RemoteHamster) UnicastRemoteObject
                .exportObject(hamster, 0);

        // rmiregistry starten (Port 2345)
        Registry registry = LocateRegistry.createRegistry(2345);

        // Objekt registrieren
        registry.rebind("Hamster paul", hamsterStub);
    } catch (Exception exc) {
        Hamster.getStandardHamster().schreib(
                exc.getMessage());
    }
}}