import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;public class hamsterprogramm extends de.hamster.debugger.model.IHamster implements de.hamster.model.HamsterProgram {public void main() {
    laufeZumBerg();
    erklimmeGipfel();
}

void laufeZumBerg() {
    while (vornFrei()) {
        vor();
    }
}

void erklimmeGipfel() {
    do {
        erklimmeEineStufe();
    } while (!vornFrei());
}

void erklimmeEineStufe() {
    linksUm(); 
    vor(); 
    rechtsUm(); 
    vor();
}

void rechtsUm() { 
    kehrt(); 
    linksUm(); 
}

void kehrt() { 
    linksUm(); 
    linksUm(); 
}}