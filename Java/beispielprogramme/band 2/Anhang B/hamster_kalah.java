/*
Windows:
  CLASSPATH: .;Programme\beispielprogramme\band 2\Anhang B
Linux, Solaris:
  CLASSPATH: .:Programme/beispielprogramme/band 2/Anhang B
*/
import kalah.*;
import hamsterkalah.*;

// Hauptprogramm
import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;public class hamster_kalah implements de.hamster.model.HamsterProgram {public void main() {
    SchiedsrichterHamster schiedsrichter = new AbfrageSchiedsrichterHamster();
    KalahSpiel spiel = new KalahSpiel(schiedsrichter);
    spiel.spielen();
}
}