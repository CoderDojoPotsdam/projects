import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;class Zwillinge {

    Hamster aelterer;

    Hamster juengerer;

    boolean aeltererHatGenommen;

    Zwillinge(int r, int s, int b, int k) {
        this.aelterer = new Hamster(r, s, b, k);
        this.juengerer = new Hamster(r, s, b, k);
        this.aeltererHatGenommen = false;
    }

    boolean vornFrei() {
        return this.aelterer.vornFrei();
    }

    boolean kornDa() {
        return this.aelterer.kornDa();
    }

    boolean maulLeer() {
        return this.juengerer.maulLeer()
                && this.aelterer.maulLeer();
    }

    void vor() {
        this.aelterer.vor();
        this.juengerer.vor();
    }

    void linksUm() {
        this.aelterer.linksUm();
        this.juengerer.linksUm();
    }

    void nimm() {
        if (!this.aelterer.kornDa())
            return;
        if (!aeltererHatGenommen) {
            this.aelterer.nimm();
            this.aeltererHatGenommen = true;
        } else {
            this.juengerer.nimm();
            this.aeltererHatGenommen = false;
        }
    }

    void gib() {
        if (!this.juengerer.maulLeer()) {
            this.juengerer.gib();
        } else if (!this.aelterer.maulLeer()) {
            this.aelterer.gib();
        }
    }
}