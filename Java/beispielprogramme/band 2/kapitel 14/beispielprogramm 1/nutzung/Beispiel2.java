/*
Windows:
  CLASSPATH: Programme\beispielprogramme\band 2\kapitel 14\beispielprogramm 1
Linux, Solaris:
  CLASSPATH: Programme/beispielprogramme/band 2/kapitel 14/beispielprogramm 1
*/
package nutzung;

import beispiel.Beispiel;

import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;public class Beispiel2 {
    public Beispiel2() {
        Beispiel bsp = new Beispiel();
        bsp.iPrivate = 8;   // Fehler
        bsp.iOhne = 9;      // Fehler
        bsp.iProtected = 7; // Fehler
        bsp.iPublic = 5;
    }
}
