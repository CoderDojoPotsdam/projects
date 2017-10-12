import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;public class programm1 implements de.hamster.model.HamsterProgram {public void main() {
    reversi.ReversiHamster paul = new reversi.ReversiHamster();
    reversi.Spielbrett brett = new reversi.Spielbrett();
    reversi.Spielzug zug = paul.liefereSpielzug();
    if (reversi.Regeln.spielzugOk(zug)) {
        //...
    }
    //...
}
}