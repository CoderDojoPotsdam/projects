import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;public class eingabe implements de.hamster.model.HamsterProgram {class QuellenHamster extends AllroundHamster {

    QuellenHamster(Hamster hamster) {
        super(hamster);

    }

    void macheNach(String dateiName) {
        try {
            BufferedReader quelle = new BufferedReader(
                    new FileReader(dateiName));
            String befehl = quelle.readLine();
            while (befehl != null) {
                if (befehl.equals("vor")) {
                    this.vor();
                } else if (befehl.equals("linksUm")) {
                    this.linksUm();
                } else if (befehl.equals("gib")) {
                    this.nimm();
                }
                befehl = quelle.readLine();
            }
            quelle.close();
        } catch (Exception exc) {
            schreib("Fehler beim Lesen!");
        }
    }
}

public void main() {
    QuellenHamster paul = new QuellenHamster(Hamster
            .getStandardHamster());
    paul.macheNach("weg.txt");
}}