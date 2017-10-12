import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;public class hamsterprogramm implements de.hamster.model.HamsterProgram {public void main() {
    Hamster paul = Hamster.getStandardHamster();
    SortierHamster willi = new SortierHamster(paul
            .getReihe(), paul.getSpalte(), paul
            .getBlickrichtung(), 0);
    willi.laufNachUntenLinks();
    int spalten = willi.zaehleSpalten();
    int[] koerner = new int[spalten];
    willi.zaehleUndSammleKoerner(koerner);
    willi.sortiereKoerner(koerner);
    willi.legeAlleKoernerAb(koerner);
}}