import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;class RaeuberHamster extends AllroundHamster implements Spieler {
    BeuteHamster beute;

    RaeuberHamster(int r, int s, int b, int k) {
        super(r, s, b, k);
        // der RaeuberHamster haelt Ausschau nach einer
        // Beute im Territorium
        Hamster[] hamster = Territorium.getHamster();
        for (int i = 0; i < hamster.length; i++) {
            if (hamster[i] instanceof BeuteHamster) {
                this.beute = (BeuteHamster) hamster[i];
                return;
            }
        }
        this.beute = null;
    }

    public boolean spielzug() {
        if (this.beute != null) {
            // der RaeuberHamster darf bei jedem Spielzug zweimal
            // ziehen
            if (this.beuteGefasst()) {
                // kann vorkommen, wenn der BeuteHamster
                // (dummerweise) auf die Kachel des Raeubers
                // gesprungen ist
                return true;
            }

            this.angreifen();
            if (this.beuteGefasst()) {
                return true;
            }

            this.angreifen();
            if (this.beuteGefasst()) {
                return true;
            }
        }
        return false;
    }

    void angreifen() {
        if (this.getReihe() < this.beute.getReihe()) {
            if (this.getSpalte() < this.beute.getSpalte()) {
                this.laufeZuKachel(this.getReihe() + 1, this
                        .getSpalte() + 1);
            } else if (this.getSpalte() > this.beute.getSpalte()) {
                this.laufeZuKachel(this.getReihe() + 1, this
                        .getSpalte() - 1);
            } else {
                this.laufeZuKachel(this.getReihe() + 1, this
                        .getSpalte());
            }
        } else if (this.getReihe() > this.beute.getReihe()) {
            if (this.getSpalte() < this.beute.getSpalte()) {
                this.laufeZuKachel(this.getReihe() - 1, this
                        .getSpalte() + 1);
            } else if (this.getSpalte() > this.beute.getSpalte()) {
                this.laufeZuKachel(this.getReihe() - 1, this
                        .getSpalte() - 1);
            } else {
                this.laufeZuKachel(this.getReihe() - 1, this
                        .getSpalte());
            }
        } else {
            if (this.getSpalte() < this.beute.getSpalte()) {
                this.laufeZuKachel(this.getReihe(), this
                        .getSpalte() + 1);
            } else if (this.getSpalte() > this.beute.getSpalte()) {
                this.laufeZuKachel(this.getReihe(), this
                        .getSpalte() - 1);
            } else {
                // Raeuber und Beute stehen auf derselben Kachel
            }
        }
    }

    boolean beuteGefasst() {
        return this.getReihe() == this.beute.getReihe()
                && this.getSpalte() == this.beute.getSpalte();
    }
}