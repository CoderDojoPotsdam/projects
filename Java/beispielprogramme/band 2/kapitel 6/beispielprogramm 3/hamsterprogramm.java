import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;public class hamsterprogramm implements de.hamster.model.HamsterProgram {public void main() {
    // zunaechst Kontrolle des Spielfeldes
    if (Territorium.getAnzahlReihen() < RegelHamster.FELD_GROESSE
            || Territorium.getAnzahlSpalten() < RegelHamster.FELD_GROESSE) {
        return;
    }

    // zwei Spieler und ein Schiedsrichter werden erzeugt
    NGewinntHamster paul = new NGewinntHamster(
            NGewinntHamster.GELB);
    NGewinntHamster willi = new NGewinntHamster(
            NGewinntHamster.ROT);
    RegelHamster heidi = new RegelHamster();

    // paul beginnt
    NGewinntHamster spieler = paul;
    while (!heidi.spielEnde()) {
        spieler.fuehreNaechstenSpielzugAus();

        // die beiden Hamster ziehen abwechselnd
        if (spieler == paul) {
            spieler = willi;
        } else {
            spieler = paul;
        }
    }

    // Spielende
    int sieger = heidi.ermittleSieger();
    if (sieger == NGewinntHamster.GELB) {
        paul.jubeln();
    } else if (sieger == NGewinntHamster.ROT) {
        willi.jubeln();
    } else { // Unentschieden
        paul.jubeln();
        willi.jubeln();
    }
}}