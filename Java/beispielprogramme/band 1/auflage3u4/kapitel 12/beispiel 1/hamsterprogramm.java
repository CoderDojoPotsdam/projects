/*
 * der Hamster soll zunaechst bis zum Berg laufen
 * und dann den Berg erklimmen
 */
import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;public class hamsterprogramm extends de.hamster.debugger.model.IHamster implements de.hamster.model.HamsterProgram {public void main() {
    laufeZumBerg();
    erklimmeDenBerg();
}

// der Hamster soll zum Berg laufen
void laufeZumBerg() {
    while (vornFrei()) {
        vor();
    }
    gib(); // am Fusse des Berges legt der Hamster ein Korn ab
}

// der Hamster soll den Berg erklimmen
void erklimmeDenBerg() {
    do {
        erklimmeEineStufe();
    } while (!gipfelErreicht());
}

// der Hamster soll eine Stufe erklimmen
void erklimmeEineStufe() {
    linksUm();  // nun schaut der Hamster nach oben
    vor();      // der Hamster erklimmt die Mauer
    rechtsUm(); // der Hamster wendet sich wieder dem Berg zu
    vor();      // der Hamster springt auf den Vorsprung
    gib();      // der Hamster legt ein Korn ab
}

// der Hamster dreht sich nach rechts um
void rechtsUm() { 
    linksUm(); 
    linksUm(); 
    linksUm(); 
}

// hat der Hamster den Gipfel erreicht?
boolean gipfelErreicht() {
    return vornFrei();
}}