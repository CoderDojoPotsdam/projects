import java.io.BufferedReader;

import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;public class NachmachHamster extends AllroundHamster {

    protected BufferedReader quelle;

    protected NachmachHamster(Hamster hamster) {
        super(hamster);
        this.quelle = null;
    }

    public void macheNach() {
        try {
            String befehl = this.quelle.readLine();
            while (befehl != null) {
                if (befehl.equals("vor")) {
                    this.vor();
                } else if (befehl.equals("linksUm")) {
                    this.linksUm();
                } else if (befehl.equals("gib")) {
                    this.gib();
                }
                befehl = this.quelle.readLine();
            }
            this.quelle.close();
        } catch (Exception exc) {
            this.schreib("Fehler beim Lesen!");
        } finally {
            if (this.quelle != null) {
                try {
                    this.quelle.close();
                } catch (Exception exc) {
                }
            }
        }
    }
}