import de.hamster.debugger.model.Territorium;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.debugger.model.Hamster;public class hamsterprogramm implements de.hamster.model.HamsterProgram {public void main() {
  Zwillinge beide = new Zwillinge(0, 0, Hamster.OST, 0);

  // zur naechsten Mauer rennen und Koerner einsammeln
  while (beide.vornFrei()) {
    beide.vor();
    while (beide.kornDa()) {
      beide.nimm();
    }
  }

  // umdrehen, zuruecklaufen und dabei Koerner ablegen
  beide.linksUm(); 
  beide.linksUm();
  beide.gib();
  while (!beide.maulLeer() && beide.vornFrei()) {
    beide.vor();
    beide.gib();
  }
}}