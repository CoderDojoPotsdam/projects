import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;class Spiel {

    Spieler[] spieler;

    // Spiel mit mehreren Spielern
    Spiel(Spieler[] spieler) {
        this.spieler = spieler;
    }

    // Spiel mit zwei Spielern
    Spiel(Spieler spieler1, Spieler spieler2) {
        this.spieler = new Spieler[2];
        this.spieler[0] = spieler1;
        this.spieler[1] = spieler2;
    }

    // ein Spiel durchfuehren; geliefert wird der Sieger
    Spieler spielen() {
        while (true) {
            for (int s = 0; s < this.spieler.length; s++) {
                boolean gewonnen = this.spieler[s].spielzug();
                // die Methode spielzug wird dynamisch gebunden
                if (gewonnen) {
                    return this.spieler[s];
                }
            }
        }
    }
}