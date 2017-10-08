import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;public class hamsterprogramm extends de.hamster.debugger.model.IHamster implements de.hamster.model.HamsterProgram {public void main() {
    ernteEineReiheUndLaufeZurueck();
    while (weitereReiheExistiert()) {
        begibDichInNaechsteReihe();
        ernteEineReiheUndLaufeZurueck();
    }    
}
    
boolean weitereReiheExistiert() {
    rechtsUm();
    if (vornFrei()) {

        /*
         * Achtung: Der Hamster muss sich wieder in seine
         * Ausgangsstellung begeben
         */
        linksUm(); 
        return true;
    } else {
        linksUm(); 
        return false;
    }
}  

void ernteEineReiheUndLaufeZurueck() {
    ernteEineReihe(); 
    kehrt(); 
    laufeZurueck();
}
 
void ernteEineReihe() {
    sammle();
    while (vornFrei()) {    
        vor();
        sammle();
    }    
}
    
void begibDichInNaechsteReihe() {
    rechtsUm(); 
    vor(); 
    rechtsUm();
}

void laufeZurueck() {
    while (vornFrei()) { 
        vor(); 
    }
}
    
void sammle() {
    while (kornDa()) { 
        nimm(); 
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