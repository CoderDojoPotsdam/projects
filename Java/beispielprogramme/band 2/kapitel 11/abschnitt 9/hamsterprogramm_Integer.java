import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;public class hamsterprogramm_Integer implements de.hamster.model.HamsterProgram {public void main() {
    Hamster paul = Hamster.getStandardHamster();
    Stapel haufen = new Stapel(Mathematik.max(Territorium
            .getAnzahlReihen(), Territorium
            .getAnzahlSpalten()));
    // damit ist der Stapel gross genug, egal in welche
    // Blickrichtung der Hamster schaut

    // Paul rennt bis zur naechsten Mauer
    while (paul.vornFrei()) {
        paul.vor();
        int anzahl = 0;
        while (paul.kornDa()) {
            paul.nimm();
            anzahl = anzahl + 1;
        }
        haufen.drauflegen(new Integer(anzahl));
    }

    // Paul dreht sich um
    paul.linksUm();
    paul.linksUm();

    // Paul rennt zurueck
    while (!haufen.istLeer()) {
        Integer intObjekt = (Integer) haufen
                .herunternehmen();
        int anzahl = intObjekt.intValue();
        while (anzahl > 0) {
            paul.gib();
            anzahl = anzahl - 1;
        }
        paul.vor();
    }
}}