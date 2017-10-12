import de.hamster.debugger.model.Territorium;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.debugger.model.Hamster;public class hamsterprogramm implements de.hamster.model.HamsterProgram {public void main() {
  SoldatenHamster[] soldaten = 
    Bundeswehr.erzeugeSoldaten(Territorium.getAnzahlSpalten());
  Hamster general = Hamster.getStandardHamster();
  String antwort = null;
  do {
    antwort = 
      general.liesZeichenkette(
        "Welchen Befehl soll ich den Soldaten erteilen:\n" +
        "linksUm, rechtsUm, vor oder kehrt?");
  
    if (antwort.equals("linksUm")) {
      for (int s=0; s<soldaten.length; s++) {
        soldaten[s].linksUm();
      }
    } else if (antwort.equals("rechtsUm")) {
      for (int s=0; s<soldaten.length; s++) {
        soldaten[s].rechtsUm();
      }
    } else if (antwort.equals("vor")) {
      for (int s=0; s<soldaten.length; s++) {
        soldaten[s].vor();
      }
    } else if (antwort.equals("kehrt")) {
      for (int s=0; s<soldaten.length; s++) {
        soldaten[s].kehrt();
      }
    }
  } while (!antwort.equals("ende"));
}
}