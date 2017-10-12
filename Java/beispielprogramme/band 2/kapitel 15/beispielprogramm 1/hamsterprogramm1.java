import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;public class hamsterprogramm1 implements de.hamster.model.HamsterProgram {public void main() {
    AllroundHamster julia = new AllroundHamster(Hamster
            .getStandardHamster());
    Speicher<Integer> kacheln = new Speicher<Integer>();
    kacheln.hinzufuegen(julia.getReihe());
    kacheln.hinzufuegen(julia.getSpalte());

    // zunaechst laeuft Julia
    while (!julia.maulLeer()) {
        julia.gib();
        int reihe = Zufall.naechsteZahl(Territorium
                .getAnzahlReihen() - 1);
        int spalte = Zufall.naechsteZahl(Territorium
                .getAnzahlSpalten() - 1);
        julia.laufeZuKachel(reihe, spalte);
        kacheln.hinzufuegen(reihe);
        kacheln.hinzufuegen(spalte);
    }

    kacheln.beginnDurchlauf();
    int reihe = kacheln.liefereNaechstenWert();
    int spalte = kacheln.liefereNaechstenWert();
    AllroundHamster romeo = new AllroundHamster(reihe,
            spalte, Hamster.OST, 0);

    // Romeo laeuft Julia hinterher
    while (!kacheln.endeErreicht()) {
        romeo.nimm();
        reihe = kacheln.liefereNaechstenWert();
        spalte = kacheln.liefereNaechstenWert();
        romeo.laufeZuKachel(reihe, spalte);
    }

    // Romeo uebergibt Julia die Koerner
    while (!romeo.maulLeer()) {
        romeo.gib();
        julia.nimm();
    }
}}