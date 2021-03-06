/*
Windows:
  CLASSPATH: Programme\beispielprogramme\band 2\kapitel 14\beispielprogramm 1
Linux, Solaris:
  CLASSPATH: Programme/beispielprogramme/band 2/kapitel 14/beispielprogramm 1
*/
package nutzung;

import beispiel.Beispiel;

import de.hamster.debugger.model.Territorium;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.debugger.model.Hamster;public class Beispiel4 extends Beispiel {
  public Beispiel4() {
    this.iPrivate = 6;   // Fehler
    this.iOhne = 2;      // Fehler
    this.iProtected = 9; // ok
    this.iPublic = 1;

    Beispiel bsp = new Beispiel();
    bsp.iPrivate = 5;   // Fehler
    bsp.iOhne = 6;      // Fehler
    bsp.iProtected = 7; // Fehler
    bsp.iPublic = 8;
  }
}