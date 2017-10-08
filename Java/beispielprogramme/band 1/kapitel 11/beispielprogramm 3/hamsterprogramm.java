import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;public class hamsterprogramm extends de.hamster.debugger.model.IHamster implements de.hamster.model.HamsterProgram {public void main() {
    gib(); // markiere Ausgangsposition
    vor();

    /*
     * irgendwann kehrt der Hamster in seine
     * Ausgangsposition zurueck
     */
    while (!kornDa()) {
        if (rechtsFrei()) {
            rechtsUm();
            vor();
        } else if (vornFrei()) {
            vor();
        } else if (linksFrei()) {
            linksUm();
            vor();
        } else {
            kehrt();
            vor();
        }
    }
}

boolean rechtsFrei() {
    rechtsUm();
    if (vornFrei()) {
        linksUm(); 
        return true;
    } else {   
        linksUm(); 
        return false;
    }
}  

boolean linksFrei() {
    linksUm();
    if (vornFrei()) {
        rechtsUm(); 
        return true;
    } else {   
        rechtsUm(); 
        return false;
    }
}  

void rechtsUm() { 
    kehrt(); 
    linksUm(); 
}

void kehrt() { 
    linksUm(); 
    linksUm(); 
}}