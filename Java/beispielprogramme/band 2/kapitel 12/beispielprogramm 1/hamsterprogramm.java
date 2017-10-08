import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;public class hamsterprogramm implements de.hamster.model.HamsterProgram {class QuadratFunktion implements Funktion {
    public int f(int x) {
        return x * x;
    }
}

class Polynom implements Funktion {
    public int f(int x) {
        return -1 * x * x * x + 10 * x * x - 27 * x + 18;
    }
}

public void main() {
    FunktionenHamster paul = new FunktionenHamster(Hamster
            .getStandardHamster());
    Funktion funk = new QuadratFunktion();
    paul.loeschen();
    paul.zeichneGraph(funk);
    paul.loeschen();
    funk = new Polynom();
    paul.zeichneGraph(funk);
}
}