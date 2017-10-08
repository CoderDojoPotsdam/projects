import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;interface HamsterAktion {
    public void ausfuehren(Hamster hamster);
}

class VorAktion implements HamsterAktion {
    public void ausfuehren(Hamster hamster) {
        hamster.vor();
    }
}

class LinksUmAktion implements HamsterAktion {
    public void ausfuehren(Hamster hamster) {
        hamster.linksUm();
    }
}

class NimmAktion implements HamsterAktion {
    public void ausfuehren(Hamster hamster) {
        hamster.nimm();
    }
}

class GibAktion implements HamsterAktion {
    public void ausfuehren(Hamster hamster) {
        hamster.gib();
    }
}