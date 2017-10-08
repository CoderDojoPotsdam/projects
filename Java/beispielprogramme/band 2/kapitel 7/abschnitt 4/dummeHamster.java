import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;public class dummeHamster implements de.hamster.model.HamsterProgram {class DummerHamster extends Hamster {

    // Ueberschreiben des Hamster-Befehls
    public void linksUm() {
        super.linksUm();
        super.linksUm();
        super.linksUm();
    }

    // Ueberschreiben des Hamster-Testbefehls
    public boolean kornDa() {
        return false;
    }

    // Definition einer neuen Methode
    void rechtsUm() {
        super.linksUm();
    }
}

public void main() {
    DummerHamster idiot = new DummerHamster();
    idiot.init(0, 0, Hamster.OST, 0);

    while (idiot.vornFrei()) {
        idiot.vor();
        if (idiot.kornDa()) { // Aufruf der ueberschriebenen
                              // Methode
            idiot.nimm();
        }
    }

    idiot.linksUm(); // Aufruf der ueberschriebenen Methode,
                     // d.h. der Hamster dreht sich nach rechts
    while (idiot.vornFrei()) {
        idiot.vor();
    }
}
}