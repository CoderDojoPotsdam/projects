import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;class Sammeln {
    static void sammeln(int reihe, int spalte) {
        Hamster[] alleHamster = Territorium.getHamster();
        for (int h = 0; h < alleHamster.length; h++) {
            if (alleHamster[h] instanceof AllroundHamster) { // Zeile
                                                             // 3
                // jetzt ist eine Typumwandlung ungefaehrlich
                AllroundHamster alleskoenner = (AllroundHamster) alleHamster[h];
                alleskoenner.laufeZuKachel(reihe, spalte);
            }
        }
    }
}