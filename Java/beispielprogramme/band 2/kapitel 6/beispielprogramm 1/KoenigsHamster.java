import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;class KoenigsHamster extends Hamster {

    // alle KoenigsHamster teilen sich einen BotschaftsHamster
    static BotschaftsHamster botschafter = new BotschaftsHamster(
            Territorium.getAnzahlReihen() / 2, Territorium
                    .getAnzahlSpalten() / 3, Hamster.SUED);

    KoenigsHamster(int r, int s, int b, int k) {
        this.init(r, s, b, k);
    }

    void schickeBotschafter() {
        KoenigsHamster.botschafter.ueberbringeBotschaft();
    }

    static BotschaftsHamster getBotschafter() {
        return KoenigsHamster.botschafter;
    }
}