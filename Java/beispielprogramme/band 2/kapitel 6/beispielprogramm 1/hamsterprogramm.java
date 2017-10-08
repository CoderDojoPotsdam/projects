import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;public class hamsterprogramm implements de.hamster.model.HamsterProgram {public void main() {
    // in den vier Ecken des Territoriums werden vier
    // KoenigsHamster platziert
    KoenigsHamster paul = new KoenigsHamster(0, 0,
            Hamster.OST, 1);
    KoenigsHamster willi = new KoenigsHamster(Territorium
            .getAnzahlReihen() - 1, 0, Hamster.OST, 0);
    KoenigsHamster heidi = new KoenigsHamster(Territorium
            .getAnzahlReihen() - 1, Territorium
            .getAnzahlSpalten() - 1, Hamster.WEST, 0);
    KoenigsHamster maria = new KoenigsHamster(0, Territorium
            .getAnzahlSpalten() - 1, Hamster.WEST, 0);

    BotschaftsHamster botschafter = KoenigsHamster
            .getBotschafter();
    KoenigsHamster aktuellerKoenig = paul;
    do {
        // schreiben und weiterleiten der Botschaft
        aktuellerKoenig.gib();
        aktuellerKoenig.schickeBotschafter();

        // bei wem haelt sich aktuell der Botschaftshamster
        // auf
        if (aktuellerKoenig == paul) {
            aktuellerKoenig = willi;
        } else if (aktuellerKoenig == willi) {
            aktuellerKoenig = heidi;
        } else if (aktuellerKoenig == heidi) {
            aktuellerKoenig = maria;
        } else {
            aktuellerKoenig = paul;
        }

        // aufnehmen und bearbeiten der Botschaft
        aktuellerKoenig.nimm();
    } while (!botschafter.istAmEnde());
}}