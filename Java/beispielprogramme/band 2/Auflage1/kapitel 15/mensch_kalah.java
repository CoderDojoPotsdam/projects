/*
Windows:
  CLASSPATH: .;Programme\beispielprogramme\band 2\kapitel 15
Linux, Solaris:
  CLASSPATH: .:Programme/beispielprogramme/band 2/kapitel 15
*/
import kalah.*;

// Hauptprogramm
import de.hamster.debugger.model.Territorium;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.debugger.model.Hamster;public class mensch_kalah implements de.hamster.model.HamsterProgram {public void main() {
  SchiedsrichterHamster schiedsrichter = new SchiedsrichterHamster();
  KalahSpiel spiel = new KalahSpiel(schiedsrichter);
  spiel.spielen();
}
}