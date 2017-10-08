import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;public class SHamster extends Hamster {

    private Hamster sHamster;

    protected SHamster(boolean dummy) {
        this.sHamster = Hamster.getStandardHamster();
    }

    public SHamster() {
        super();
        this.sHamster = null;
    }

    public SHamster(int reihe, int spalte, int blickrichtung,
            int anzahlKoerner) {
        super(reihe, spalte, blickrichtung, anzahlKoerner);
        this.sHamster = null;
    }

    public SHamster(Hamster hamster) {
        super(hamster.getReihe(), hamster.getSpalte(), hamster
                .getBlickrichtung(), hamster.getAnzahlKoerner());
        this.sHamster = null;
    }

    public void init(int reihe, int spalte, int blickrichtung,
            int anzahlKoerner) {
        if (this.sHamster == null) {
            super.init(reihe, spalte, blickrichtung,
                    anzahlKoerner);
        } else {
            this.sHamster.init(reihe, spalte, blickrichtung,
                    anzahlKoerner);
        }
    }

    public void vor() {
        if (this.sHamster == null) {
            super.vor();
        } else {
            this.sHamster.vor();
        }
    }

    public void linksUm() {
        if (this.sHamster == null) {
            super.linksUm();
        } else {
            this.sHamster.linksUm();
        }
    }

    public void gib() {
        if (this.sHamster == null) {
            super.gib();
        } else {
            this.sHamster.gib();
        }
    }

    public void nimm() {
        if (this.sHamster == null) {
            super.nimm();
        } else {
            this.sHamster.nimm();
        }
    }

    public boolean vornFrei() {
        if (this.sHamster == null) {
            return super.vornFrei();
        } else {
            return this.sHamster.vornFrei();
        }
    }

    public boolean maulLeer() {
        if (this.sHamster == null) {
            return super.maulLeer();
        } else {
            return this.sHamster.maulLeer();
        }
    }

    public boolean kornDa() {
        if (this.sHamster == null) {
            return super.kornDa();
        } else {
            return this.sHamster.kornDa();
        }
    }

    public void schreib(String zeichenkette) {
        if (this.sHamster == null) {
            super.schreib(zeichenkette);
        } else {
            this.sHamster.schreib(zeichenkette);
        }
    }

    public String liesZeichenkette(String aufforderung) {
        if (this.sHamster == null) {
            return super.liesZeichenkette(aufforderung);
        } else {
            return this.sHamster.liesZeichenkette(aufforderung);
        }
    }

    public int liesZahl(String aufforderung) {
        if (this.sHamster == null) {
            return super.liesZahl(aufforderung);
        } else {
            return this.sHamster.liesZahl(aufforderung);
        }
    }

    public int getReihe() {
        if (this.sHamster == null) {
            return super.getReihe();
        } else {
            return this.sHamster.getReihe();
        }
    }

    public int getSpalte() {
        if (this.sHamster == null) {
            return super.getSpalte();
        } else {
            return this.sHamster.getSpalte();
        }
    }

    public int getBlickrichtung() {
        if (this.sHamster == null) {
            return super.getBlickrichtung();
        } else {
            return this.sHamster.getBlickrichtung();
        }
    }

    public int getAnzahlKoerner() {
        if (this.sHamster == null) {
            return super.getAnzahlKoerner();
        } else {
            return this.sHamster.getAnzahlKoerner();
        }
    }

    protected Object clone() {
        if (this.sHamster == null) {
            return new SHamster(this);
        } else {
            return new SHamster(this.sHamster);
        }
    }

    public boolean equals(Object hamster) {
        if (this.sHamster == null) {
            return super.equals(hamster);
        } else {
            return this.sHamster.equals(hamster);
        }
    }

    public String toString() {
        if (this.sHamster == null) {
            return super.toString();
        } else {
            return this.sHamster.toString();
        }
    }
}