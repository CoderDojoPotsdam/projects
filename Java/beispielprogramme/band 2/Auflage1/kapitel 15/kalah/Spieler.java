/*
Windows:
  CLASSPATH: Programme\beispielprogramme\band 2\kapitel 15
Linux, Solaris:
  CLASSPATH: Programme/beispielprogramme/band 2/kapitel 15
*/
package kalah;

// repraesentiert einen Kalah-Spieler
import de.hamster.debugger.model.Territorium;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.debugger.model.Hamster;public interface Spieler {
  
  // Ueberpruefung, welcher Spieler es ist
  public boolean istSpielerA();
  
  // liefert A oder B, je nachdem, welcher Spielertyp es ist
  public String liefereSpielerTyp();
  
  // ermittelt den naechsten Spielzug, fuehrt ihn aus und liefert ihn
  public Spielzug naechsterSpielzug();
  
  // sammelt uebrig gebliebene Koerner ein und packt sie ins eigene
  // Kalah
  public void sammleResteUndBringSieZumKalah();

  // beliebige Aktion, die ein Spieler nach Ende des Spiels durchfuehrt;
  // uebergeben wird die Information, ob der Spieler gewonnen hat
  public void spielBeenden(boolean istSieger);
}
