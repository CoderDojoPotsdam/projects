import de.hamster.debugger.model.Territorium;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.debugger.model.Hamster;class LaufendeHamsterGM extends Hamster {

    static int aktiveNummer = 0;
    static int anzahlLaufendeHamster = 0;

    int meineNummer;

    LaufendeHamsterGM(int r, int s, int b, int k) {
        super(r, s, b, k);
        this.meineNummer = LaufendeHamsterGM.anzahlLaufendeHamster;
        LaufendeHamsterGM.anzahlLaufendeHamster++;
    }

    public void run() {
        while (this.vornFrei()) {
            while (LaufendeHamsterGM.aktiveNummer != meineNummer) {
                // warten
            }

            //jetzt bin ich dran
            this.vor();

            // der Naechste bitte!
            LaufendeHamsterGM.aktiveNummer = 
                (LaufendeHamsterGM.aktiveNummer + 1) %
                    LaufendeHamsterGM.anzahlLaufendeHamster;
        }
    }
}