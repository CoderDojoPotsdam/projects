import reversi.ReversiHamster;
import reversi.Spielbrett;
import reversi.Spielzug;
import reversi.Regeln;
import static reversi.Regeln.spielzugOk; // static import

import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;public class programm4 implements de.hamster.model.HamsterProgram {public void main() {
    ReversiHamster paul = new ReversiHamster();
    Spielbrett brett = new Spielbrett();
    Spielzug zug = paul.liefereSpielzug();
    if (spielzugOk(zug)) {  // Weglassen des Klassenamens
       // ...
    }
    // ...
}}