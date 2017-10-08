import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;public class hamsterprogramm2 implements de.hamster.model.HamsterProgram {public void main() {
    AllroundHamster julia = new AllroundHamster(Hamster
            .getStandardHamster());
    Speicher<Position> kacheln = new Speicher<Position>();
    kacheln.hinzufuegen(new Position(julia.getReihe(), julia
            .getSpalte()));

    // zunaechst laeuft Julia
    while (!julia.maulLeer()) {
        julia.gib();
        int reihe = Zufall.naechsteZahl(Territorium
                .getAnzahlReihen() - 1);
        int spalte = Zufall.naechsteZahl(Territorium
                .getAnzahlSpalten() - 1);
        julia.laufeZuKachel(reihe, spalte);
        kacheln.hinzufuegen(new Position(reihe, spalte));
    }

    kacheln.beginnDurchlauf();
    Position pos = kacheln.liefereNaechstenWert();
    AllroundHamster romeo = new AllroundHamster(pos
            .getReihe(), pos.getSpalte(), Hamster.OST, 0);

    // Romeo laeuft Julia hinterher
    while (!kacheln.endeErreicht()) {
        romeo.nimm();
        pos = kacheln.liefereNaechstenWert();
        romeo.laufeZuKachel(pos.getReihe(), pos.getSpalte());
    }

    // Romeo uebergibt Julia die Koerner
    while (!romeo.maulLeer()) {
        romeo.gib();
        julia.nimm();
    }
}}