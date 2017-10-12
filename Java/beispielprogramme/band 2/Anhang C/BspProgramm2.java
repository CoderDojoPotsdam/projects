import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;public class BspProgramm2 implements de.hamster.model.HamsterProgram {public void main() {
    // Standard-Hamster als AllroundSHamster
    AllroundSHamster paul = AllroundSHamster
            .getStandardHamsterAlsAllroundSHamster();
    int reihe = paul.liesZahl("Welche Reihe?");
    int spalte = paul.liesZahl("Welche Spalte?");
    paul.laufeZuKachel(reihe, spalte);
}}