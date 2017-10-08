/*
Windows:
  CLASSPATH: Programme\beispielprogramme\band 2\Anhang B
Linux, Solaris:
  CLASSPATH: Programme/beispielprogramme/band 2/Anhang B
 */
package hamsterkalah;

import kalah.*;

// Hilfsklasse der Klasse StrategieHamster, die einen 
// Spielzug plus Bewertung repraesentiert
import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;class WertSpielzug {

    private Spielzug zug;

    private int wert;

    WertSpielzug(Spielzug z, int w) {
        this.zug = z;
        this.wert = w;
    }

    Spielzug getZug() {
        return this.zug;
    }

    int getWert() {
        return this.wert;
    }
}
