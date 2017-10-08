import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;public class client implements de.hamster.model.HamsterProgram {public void main() {
    try {
        // lokalen Hamster ermitteln
        Hamster willi = Hamster.getStandardHamster();

        // RemoteHamster ermitteln
        Registry registry = LocateRegistry.getRegistry(2345);
        RemoteHamster paul = (RemoteHamster) registry
                .lookup("Hamster paul");

        // lokalen Hamster und RemoteHamster steuern
        while (willi.vornFrei() && paul.vornFrei()) {
            willi.vor();
            paul.vor();
            if (willi.kornDa()) {
                willi.nimm();
            }
            if (paul.kornDa()) {
                paul.nimm();
            }
        }
        int zahl1 = willi.liesZahl("Zahl eingeben: ");
        int zahl2 = paul.liesZahl("Zahl eingeben: ");
        willi.schreib("Summe der Zahlen = "
                + (zahl1 + zahl2));
        paul.schreib("Produkt der Zahlen = "
                + (zahl1 * zahl2));

    } catch (Exception exc) {
        Hamster.getStandardHamster().schreib(
                exc.getMessage());
    }
}}