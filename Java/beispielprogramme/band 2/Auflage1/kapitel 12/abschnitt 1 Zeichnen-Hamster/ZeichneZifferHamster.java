import de.hamster.debugger.model.Territorium;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.debugger.model.Hamster;abstract class ZeichneZifferHamster   // abstrakte Klasse
    extends Hamster 
{

    ZeichneZifferHamster(int r, int s, int b, int k) {
      super(r, s, b, k);
    }

    // zeichnet eine Ziffer mit Koernern ins Territorium
    abstract void zeichne();  // abstrakte Methode

    void kehrt() {
      this.linksUm();
      this.linksUm();
    }

    void rechtsUm() {
      this.kehrt();
      this.linksUm();
    }

    void vor(int anzahl) {
      while (anzahl > 0) {
        this.vor();
        anzahl = anzahl - 1;
      }
    }

    void vorUndGib() {
      this.vor();
      this.gib();
    }

    void vorUndGib(int anzahl) {
      while (anzahl > 0) {
        this.vorUndGib();
        anzahl = anzahl - 1;
      }
    }
}
