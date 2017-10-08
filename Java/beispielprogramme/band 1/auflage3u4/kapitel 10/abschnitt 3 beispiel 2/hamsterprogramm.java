import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;public class hamsterprogramm extends de.hamster.debugger.model.IHamster implements de.hamster.model.HamsterProgram {public void main() {
    laufeInDieNaechsteEckeUndSammle();
    linksUm();
    laufeInDieNaechsteEckeUndSammle();
    linksUm();
    laufeInDieNaechsteEckeUndSammle();
    linksUm();
    laufeInDieNaechsteEckeUndSammle();
    legAb();
}

void laufeInDieNaechsteEckeUndSammle() {
    do {
        vor();
        sammle();
    } while (vornFrei());
}

void sammle() {
    do {
        nimm();
    } while (kornDa());
}

void legAb() {
    do {
        gib();
    } while (!maulLeer());
}}