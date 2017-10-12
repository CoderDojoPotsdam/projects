import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;public class hamsterprogramm implements de.hamster.model.HamsterProgram {public void main() {
    Hamster[] hamster = new Hamster[3];
    hamster[0] = new Hamster(0, 0, Hamster.OST, 0);
    hamster[1] = new Hamster(1, 0, Hamster.OST, 0);
    hamster[2] = new Hamster(2, 0, Hamster.OST, 0);
    hamster[2] = new DopingHamster(2, 0, Hamster.OST, 0);
    // hier schmuggelt sich ein DopingHamster in die
    // Laeuferschar
    
    Hamster sieger = Wettlauf.durchfuehren(hamster);

    // der Sieger darf sich einmal im Kreis drehen!
    sieger.linksUm();
    sieger.linksUm();
    sieger.linksUm();
    sieger.linksUm();
}}