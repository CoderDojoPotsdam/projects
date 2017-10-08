import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;class DeinHamster extends MeinHamster {
    void kehrt(boolean wirklich) { // Ueberladen
        if (wirklich) {
            super.kehrt();
        }
    }

    void kehrt() { // Ueberschreiben
        this.linksUm();
        this.linksUm();
        this.linksUm();
        this.linksUm();
        this.linksUm();
        this.linksUm();
    }
}