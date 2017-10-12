import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;public class hamsterprogramm extends de.hamster.debugger.model.IHamster implements de.hamster.model.HamsterProgram {void rechtsUm() {
    linksUm();
    linksUm();
    linksUm();
}

boolean rechtsFrei() { // Definition einer booleschen Funktion
    rechtsUm();
    if (vornFrei()) {
        linksUm();
        return true; // boolesche return-Anweisung
    } else {
        linksUm();
        return false; // boolesche return-Anweisung
    }
}

public void main() {
    while (vornFrei() && 
           !rechtsFrei()) { // Aufruf einer booleschen Funktion
        vor();
    }
    
    if (rechtsFrei()) { // Aufruf einer booleschen Funktion
        rechtsUm();
        vor();
    }
}
}