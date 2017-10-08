import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;public class hamsterprogramm1 extends de.hamster.debugger.model.IHamster implements de.hamster.model.HamsterProgram {public void main() {
    boolean geradeAnzahl = true; // 0 Koerner eingesammelt
    geradeAnzahl = sammle();
    while (vornFrei()) {
        vor();
        boolean gesammelt = sammle();

        /*
         * gerade Zahl + gerade Zahl = gerade Zahl
         * ungerade Zahl + ungerade Zahl = gerade Zahl
         * alle anderen Faelle ergeben eine ungerade Zahl
         */
        geradeAnzahl = 
            (geradeAnzahl && gesammelt) || 
            (!geradeAnzahl && !gesammelt);
    }

    /*
     * falls gerade Anzahl an Koernern gefunden: 
     * alle Koerner ablegen
     */
    if (geradeAnzahl) {
        while (!maulLeer()) {
            gib();
        }
    }
}

/*
 * sammle alle Koerner auf aktuellem Feld auf; falls gerade 
 * Anzahl an Koernern eingesammelt wurde, liefere true;
 * ansonsten liefere false
 */
boolean sammle() {
    boolean geradeAnzahl = true;  // 0 Koerner eingesammelt
    while (kornDa()) {
        nimm();
        
        /*
         * auf jede gerade folgt eine ungerade 
         * Zahl und umgekehrt
         */
        geradeAnzahl = !geradeAnzahl;  
    }
    return geradeAnzahl;
}}