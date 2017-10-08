package landschaft;

import de.hamster.debugger.model.Territorium;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.debugger.model.Hamster;public class Landschaft {

    private static Landschaft landschaft = new Landschaft();

    private Landschaft() { } 

    public static Landschaft getLandschaft() {
      return Landschaft.landschaft;
    }

    public int getAnzahlReihen() {
      return Territorium.getAnzahlReihen();
    }

    public int getAnzahlSpalten() {
      return Territorium.getAnzahlSpalten();
    }

    public boolean mauerDa(int reihe, int spalte)  {
      return Territorium.mauerDa(reihe, spalte);
    }

    public int getAnzahlKoerner()  {
      return Territorium.getAnzahlKoerner();
    }
    
    public int getAnzahlKoerner(int reihe, int spalte) {
      return Territorium.getAnzahlKoerner(reihe, spalte);
    }

    public int getAnzahlHamster() {
      return Territorium.getAnzahlHamster();
    }
    
    public Hamster[] getHamster() {
      return Territorium.getHamster();
    }

    public int getAnzahlHamster(int reihe, int spalte) {
      return Territorium.getAnzahlHamster(reihe, spalte);
    }

    public Hamster[] getHamster(int reihe, int spalte) {
      return Territorium.getHamster(reihe, spalte);
    }
}