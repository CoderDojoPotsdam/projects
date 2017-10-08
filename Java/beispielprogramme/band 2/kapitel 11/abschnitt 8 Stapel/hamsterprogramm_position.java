import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;public class hamsterprogramm_position implements de.hamster.model.HamsterProgram {public void main() {
    AllroundHamster willi = new AllroundHamster(Hamster
            .getStandardHamster());
    Stapel haufen = new Stapel(willi.getAnzahlKoerner());

    // zunaechst irrt Willi durchs Territorium
    while (!willi.maulLeer() && !haufen.istVoll()) {
        int reihe = Zufall.naechsteZahl(Territorium
                .getAnzahlReihen() - 1);
        int spalte = Zufall.naechsteZahl(Territorium
                .getAnzahlSpalten() - 1);
        willi.laufeZuKachel(reihe, spalte);
        willi.gib();
        haufen.drauflegen(new Position(reihe, spalte));
    }

    AllroundHamster james = new AllroundHamster(willi);

    // James laeuft zurueck und sammelt die Koerner wieder
    // ein
    while (!haufen.istLeer()) {
        Object objekt = haufen.herunternehmen();
        Position naechsteKachel = (Position) objekt;
        // Typumwandlung erforderlich!
        james.laufeZuKachel(naechsteKachel.getReihe(),
                naechsteKachel.getSpalte());
        james.nimm();
    }
}}