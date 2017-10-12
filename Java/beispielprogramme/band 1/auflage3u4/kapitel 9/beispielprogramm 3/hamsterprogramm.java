import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;public class hamsterprogramm extends de.hamster.debugger.model.IHamster implements de.hamster.model.HamsterProgram {public void main() {

    // untere Reihe
    ueberpruefeEineReihe();
    linksUm(); 
    vor(); 
    linksUm();

    // zweite Reihe von unten
    ueberpruefeEineReihe();
    rechtsUm(); 
    vor(); 
    rechtsUm();

    // dritte Reihe von unten
    ueberpruefeEineReihe();
    linksUm(); 
    vor(); 
    linksUm();

    // vierte Reihe von unten
    ueberpruefeEineReihe();
    rechtsUm(); 
    vor(); 
    rechtsUm();

    // obere Reihe
    ueberpruefeEineReihe();
}

void ueberpruefeEineReihe() {
    evtlFressen(); 
    vor();
    evtlFressen(); 
    vor();
    evtlFressen(); 
    vor();
    evtlFressen(); 
    vor();
    evtlFressen(); 
}

void evtlFressen() {

    // erstmal ein Korn fressen
    nimm();

    /*
     * falls es das einzige Korn auf dem Feld war, 
     * muss es wieder abgelegt werden
     */
    if (!kornDa()) {
        gib();
    }
}

void rechtsUm() { 
    linksUm(); 
    linksUm(); 
    linksUm(); 
}}