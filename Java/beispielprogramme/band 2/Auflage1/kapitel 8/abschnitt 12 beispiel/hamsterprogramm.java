import de.hamster.debugger.model.Territorium;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.debugger.model.Hamster;public class hamsterprogramm implements de.hamster.model.HamsterProgram {class SortierHamster extends AllroundHamster {

    int[] speicher; // Array als Attribut

    SortierHamster(Hamster existierenderHamster) {
      super(existierenderHamster);
      this.speicher = null;
    }

    void sortiereKoernerhaufen() {
      int anzahl = this.zaehleKacheln();
      // der Hamster erzeugt fuer sich ein Array, dass er seiner
      // Array-Variablen speicher zuordnet
      this.speicher = new int[anzahl];
      this.sammleKoerner();
      this.sortiereArray();
      this.legeKoernerSortiertAb();
    }

    // zaehlt die Anzahl an Kacheln vor ihm bis zur naechsten Wand
    int zaehleKacheln() {
      int anzahlKacheln = 1;
      while (this.vornFrei()) {
        this.vor();
        anzahlKacheln++;
      }
      this.kehrt();
      int schritte = anzahlKacheln - 1;
      while (schritte > 0) {
        this.vor();
        schritte = schritte - 1;
      }
      this.kehrt();
      return anzahlKacheln;
    }

    // frisst alle Koerner bis zur Wand und vermerkt die
    // jeweilige Anzahl im Array
    void sammleKoerner() {
      this.speicher[0] = this.nimmAlle();
      for (int zaehler=1; zaehler<this.speicher.length; zaehler++) {
        this.vor();
        this.speicher[zaehler] = this.nimmAlle();
      }
      this.kehrt();
    }

    // sortiert das Array in aufsteigender Reihenfolge 
    // der gespeicherten Werte
    void sortiereArray() {
      boolean getauscht;
      do {
        getauscht = false;
        for (int zaehler=1; 
             zaehler<this.speicher.length; 
             zaehler++) {
          if (this.speicher[zaehler-1] > this.speicher[zaehler]) {
            // tauschen
            int ablage = this.speicher[zaehler-1];
            this.speicher[zaehler-1] = this.speicher[zaehler];
            this.speicher[zaehler] = ablage;
            getauscht = true;
          }
        }
      } while (getauscht);
    }

    // legt die aufgesammelten Koerner entsprechend der im Array
    // gespeicherten Werte wieder ab
    void legeKoernerSortiertAb() {
      this.gib(this.speicher[0]);
      for (int zaehler=1; zaehler<this.speicher.length; zaehler++) {
        this.vor();
        this.gib(this.speicher[zaehler]);
      }
    }
}

public void main() {
    SortierHamster paul = 
      new SortierHamster(Hamster.getStandardHamster());
    paul.sortiereKoernerhaufen();
}}