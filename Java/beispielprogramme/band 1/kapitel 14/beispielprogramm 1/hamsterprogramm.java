import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;public class hamsterprogramm extends de.hamster.debugger.model.IHamster implements de.hamster.model.HamsterProgram {public void main() {

    // zum Abspeichern der gelaufenen Schritte
    int schritte = 0;  

    // laufe bis zur Wand
    while (vornFrei()) {
        vor();
        schritte++;  // Schritte werden vermerkt
    }

    // kehre um
    kehrt(); 

    /*
     * laufe zurueck:
     * die Schleife wird so oft durchlaufen, wie der
     * Hamster Schritte bis zur Wand benoetigt hat
     */
    while (schritte > 0)  {                     
        vor();
        schritte--;
    }
}

void kehrt() {
    linksUm();
    linksUm();
}}