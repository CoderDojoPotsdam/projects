/*
Windows:
  CLASSPATH: Programme\beispielprogramme\band 2\Anhang B
Linux, Solaris:
  CLASSPATH: Programme/beispielprogramme/band 2/Anhang B
 */
package hamsterkalah;

import kalah.*;

// repraesentiert ein Kalah-Spielbrett mit Stellungsbewerter
import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;public class WertSpielbrett extends Spielbrett {

    // Konstanten
    public final static int MAX_WERT = Spielbrett.ANZAHL_KOERNER;

    public final static int MIN_WERT = -MAX_WERT;

    public final static int MITTEL_WERT = 0;

    // Konstruktor; erzeugt eine Kopie des uebergebenen
    // Spielbrettes
    public WertSpielbrett(Spielbrett brett) {
        super(brett);
    }

    // einfacher Stellungsbewerter; je groesser der gelieferte
    // Wert, desto besser steht Spieler A; je kleiner der
    // gelieferte Wert, desto besser steht Spieler B
    public int bewerteStellung(boolean spielBeendet) {
        if (!spielBeendet) {
            return this.liefereAnzahlKoernerInKalahA()
                    - this.liefereAnzahlKoernerInKalahB();
        }

        // Spiel ist beendet; also muessen auch noch die "Reste"
        // betrachtet werden
        int diff = (this.liefereAnzahlKoernerInKalahA() + this
                .liefereAnzahlKoernerVonSpielerA())
                - (this.liefereAnzahlKoernerInKalahB() + this
                        .liefereAnzahlKoernerVonSpielerB());
        if (diff > 0) { // Spieler A hat gewonnen
            return WertSpielbrett.MAX_WERT;
        } else if (diff < 0) { // Spieler B hat gewonnen
            return WertSpielbrett.MIN_WERT;
        } else { // Unentschieden
            return WertSpielbrett.MITTEL_WERT;
        }
    }
}
