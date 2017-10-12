// globale Variable
import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;public class hamsterprogramm2 extends de.hamster.debugger.model.IHamster implements de.hamster.model.HamsterProgram {boolean geradeAnzahl = true; // 0 Koerner eingesammelt

public void main()  {
    sammle();
    while (vornFrei()) {
        vor();
        sammle();
    }
    if (geradeAnzahl) {
        while (!maulLeer()) {  
            gib();   
        }
    } 
}   
    
// sammle alle Koerner auf aktuellem Feld auf
void sammle() {
    while (kornDa()) {
        nimm();
      
        /*
         * auf jede gerade folgt eine ungerade 
         * Zahl und umgekehrt
         */
        geradeAnzahl = !geradeAnzahl;  
    }
}}