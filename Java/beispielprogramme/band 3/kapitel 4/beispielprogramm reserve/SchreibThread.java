import de.hamster.debugger.model.Territorium;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.debugger.model.Hamster;class SchreibThread extends Thread {

  Hamster hamster;
  String ausgabe;

  SchreibThread(Hamster hamster, String zeichenkette) {
    this.hamster = hamster;
    this.ausgabe = zeichenkette;
    this.start();
  }

  public void run() {
    this.hamster.schreib(ausgabe);
  } 
	
}
