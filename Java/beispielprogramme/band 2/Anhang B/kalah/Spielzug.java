/*
Windows:
  CLASSPATH: Programme\beispielprogramme\band 2\Anhang B
Linux, Solaris:
  CLASSPATH: Programme/beispielprogramme/band 2/Anhang B
*/
package kalah;

// repraesentiert einen Spielzug beim Kalah-Spiel
import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;public class Spielzug {

    private int mulde; // Nummer einer Mulde

    // initialisiert ein Spielzug-Objekt
    public Spielzug(int muldeNummer) {
        this.mulde = muldeNummer;
    }

    // liefert die Muldennummer
    public int liefereMulde() {
        return this.mulde;
    }
}