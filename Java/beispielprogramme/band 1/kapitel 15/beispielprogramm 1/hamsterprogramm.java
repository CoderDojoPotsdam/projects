import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;public class hamsterprogramm extends de.hamster.debugger.model.IHamster implements de.hamster.model.HamsterProgram {public void main() {
    int stufenAnzahl = zaehleStufen();

    // nimm genuegend Koerner ins Maul
    while ((stufenAnzahl > 0) && kornDa()) {
        nimm();
        stufenAnzahl--;
    }

    erklimmeBerg();
}

// ermittle die Hoehe des Berges (ohne Seiteneffekte)
int zaehleStufen() {

    // erklimme die einzelnen Stufen und vermerke die Anzahl
    int anzahl = 0;
    while (!gipfelErreicht()) {
        erklimmeStufe();
        anzahl++;
    }

    // und wieder hinunter (Vermeidung von Seiteneffekten)
    kehrt();
    int schritte = anzahl;
    while (schritte > 0) {
        klettereStufeHinunter();
        schritte--;
    }
    kehrt();
    return anzahl;
}

boolean gipfelErreicht() {
    return vornFrei();
}

void erklimmeStufe() {
    linksUm(); 
    vor(); 
    rechtsUm(); 
    vor();
}

void klettereStufeHinunter() {
    vor(); 
    linksUm(); 
    vor(); 
    rechtsUm();
}

void erklimmeBerg() {
    while (!gipfelErreicht()) {
        erklimmeStufe();
        if (!maulLeer()) {
            gib();
        }
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