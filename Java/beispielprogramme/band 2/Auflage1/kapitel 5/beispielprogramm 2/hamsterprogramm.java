import de.hamster.debugger.model.Territorium;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.debugger.model.Hamster;public class hamsterprogramm implements de.hamster.model.HamsterProgram {public void main() {
  Hamster paul = Hamster.getStandardHamster();

  // Erzeugung eines Vertretungshamsters
  KletterHamster reinhold = new KletterHamster();
  reinhold.init(paul.getReihe(),
                paul.getSpalte(),
                paul.getBlickrichtung(),
                paul.getAnzahlKoerner());
  
  reinhold.laufeZumBerg();
  do {
      reinhold.erklimmeEineStufe();
  } while (!reinhold.gipfelErreicht());
}

class KletterHamster extends Hamster {

  void laufeZumBerg() {
    while (this.vornFrei()) {
      this.vor();
    }
  }

  void erklimmeEineStufe() {
    this.linksUm();
    this.vor();
    this.rechtsUm();
    this.vor();
  }
  
  boolean gipfelErreicht() {
      return this.vornFrei();
  }

  void rechtsUm() {
    this.kehrt();
    this.linksUm();
  }

  void kehrt() {
    this.linksUm();
    this.linksUm();
  }
}}