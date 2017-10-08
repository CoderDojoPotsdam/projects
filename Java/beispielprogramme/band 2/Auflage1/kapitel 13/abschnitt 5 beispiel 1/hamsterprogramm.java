import de.hamster.debugger.model.Territorium;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.debugger.model.Hamster;public class hamsterprogramm implements de.hamster.model.HamsterProgram {class KachelIstLeerException extends Exception {

    int reihe, spalte;

    KachelIstLeerException(int r, int s) {
      super("Die Kachel an der Position " +
            r + "/" + s + " ist leer!");
      this.reihe = r; 
      this.spalte = s; 
    }

    int getReihe() { return this.reihe; }
    int getSpalte() { return this.spalte; }
}

class MeinHamster extends Hamster {

    MeinHamster(int r, int s, int b, int k) {
      super(r, s, b, k);
    }

    void kehrt() {
      this.linksUm();
      this.linksUm();
    }

    void sammle() throws KachelIstLeerException {
      if (!this.kornDa()) {
        throw new KachelIstLeerException(this.getReihe(), 
                                         this.getSpalte());
      }
      while (this.kornDa()) {
        this.nimm();
      }
    }

    void graseReiheAb() {
      this.schreib("Ich starte!");

      try { // Standardsituation
        this.sammle();
        while (this.vornFrei()) {
          this.vor();
          this.sammle();
        }
      } catch (KachelIstLeerException exc) { // Fehlerbehandlung
        this.schreib("Ich bin sauer, denn die Kachel " + 
                     exc.getReihe() + "/" + exc.getSpalte() + 
                     " ist leer!");
        while (this.vornFrei()) {
          this.vor();
        }
      }

      this.schreib("Ich bin fertig!");
    }
}

public void main() {
    MeinHamster paul = new MeinHamster(3, 4, Hamster.NORD, 4);
    paul.graseReiheAb();
}
}