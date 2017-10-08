/*
 * repraesentiert eine der vier moeglichen
 * Richtungen durch die Werte 0, 1, 2 oder 3
 */
import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;public class hamsterprogramm extends de.hamster.debugger.model.IHamster implements de.hamster.model.HamsterProgram {int richtung = 0;         

/*
 * repraesentiert die Position des Hamsters
 * in einer Richtung (horizontal / vertikal)
 */
int eineDimension = 0;   

/*
 * repraesentiert die Position des Hamsters 
 * in der anderen Richtung
 */
int andereDimension = 0; 

public void main() {
    neuesVor();
    while (!ausgangspunktErreicht()) {
        if (rechtsFrei()) {
            neuesRechtsUm();
            neuesVor();
        } else if (vornFrei()) {
            neuesVor();
        } else if (linksFrei()) {
            neuesLinksUm();
            neuesVor();
        } else {
            neuesKehrt();
            neuesVor();
        }
    }
}

boolean ausgangspunktErreicht() {

    /*
     * der Ausgangspunkt ist erreicht, wenn beide
     * Richtungsvariablen wieder ihren Initialwert 
     * enthalten
     */
    return (andereDimension == 0) && (eineDimension == 0);
}

void neuesLinksUm() {
    linksUm();
    richtung = (richtung + 1) % 4;
    /*
     * einmal  linksUm: richtung == 1
     * zweimal linksUm: richtung == 2
     * dreimal linksUm: richtung == 3
     * viermal linksUm: richtung == 0
     */
}

void neuesKehrt() {
    neuesLinksUm(); 
    neuesLinksUm();
}

void neuesRechtsUm() {
    neuesKehrt(); 
    neuesLinksUm();
}

void neuesVor() {
    vor();
    if (richtung == 0) {
        eineDimension++;
    } else if (richtung == 1) {
        andereDimension++;
    } else if (richtung == 2) {
        eineDimension--;
    } else /* (richtung == 3) */ {
        andereDimension--;
    }
  }

boolean linksFrei() {
    linksUm();
    boolean frei = vornFrei();
    rechtsUm();
    return frei;
} 

boolean rechtsFrei() {
    rechtsUm();
    boolean frei = vornFrei();
    linksUm();
    return frei;
} 

void rechtsUm() {
    linksUm(); 
    linksUm(); 
    linksUm();
}}