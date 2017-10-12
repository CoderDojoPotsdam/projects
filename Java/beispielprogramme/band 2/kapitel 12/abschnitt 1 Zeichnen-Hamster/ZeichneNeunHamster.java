import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;class ZeichneNeunHamster extends ZeichneZifferHamster {
    ZeichneNeunHamster(int r, int s, int b, int k) {
        super(r, s, b, k);
    }

    // zeichnet die Ziffer 9 mit Koernern ins Territorium
    void zeichne() { // ueberschriebene und implementierte
                     // Methode
        this.vorUndGib(3);
        this.kehrt();
        this.vor(2);
        this.linksUm();
        this.vorUndGib(2);
        this.linksUm();
        this.vorUndGib();
        this.vor();
        this.linksUm();
        this.vor(2);
        this.kehrt();
        this.vorUndGib(4);
        this.rechtsUm();
        this.vorUndGib(2);
        this.rechtsUm();
        this.vor(4);
        this.linksUm();
        this.vor();
        this.kehrt();
    }
}