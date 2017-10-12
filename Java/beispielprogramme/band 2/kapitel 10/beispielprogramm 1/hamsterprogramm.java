import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;public class hamsterprogramm implements de.hamster.model.HamsterProgram {public void main() {
    AllroundHamster paul = new AllroundHamster(0, 0,
            Hamster.OST, 0);
    int reihe = 0;
    int spalte = 0;
    do {
        reihe = paul
                .liesZahl("Bitte teile mir die r-Koordinate einer "
                        + "Kachel mit, auf der ein Korn liegt,\n oder "
                        + "gib -1 ein, wenn es keine Koerner mehr im "
                        + "Territorium gibt!");
        if (reihe == -1) {
            paul
                    .schreib("Jetzt bin ich satt! Danke fuer Deine Hilfe!");
        } else {
            spalte = paul
                    .liesZahl("Bitte teile mir nun die s-Koordinate der "
                            + "Kachel mit!");
            paul.laufeZuKachel(reihe, spalte);
            paul.nimm(); // bitte paul nicht durch falsche
                         // Eingaben
            // enttaeuschen, sonst stirbt er!
            paul.schreib("Schmatz! Das hat gut geschmeckt!");
        }
    } while (reihe != -1);
}}