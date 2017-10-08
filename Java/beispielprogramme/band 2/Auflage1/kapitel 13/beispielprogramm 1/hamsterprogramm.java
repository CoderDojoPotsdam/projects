import de.hamster.debugger.model.Territorium;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.debugger.model.Hamster;public class hamsterprogramm implements de.hamster.model.HamsterProgram {public void main() {
  AllroundHamster willi = 
    new AllroundHamster(Hamster.getStandardHamster()); 
    
  try {
    int groesse = willi.liesZahl("Groesse des Stapels?");
    Stapel haufen = new Stapel(groesse);
    
    // zunaechst irrt Willi durchs Territorium
    while (!willi.maulLeer()) {
      int reihe = 
        Zufall.naechsteZahl(Territorium.getAnzahlReihen()-1);
      int spalte = 
        Zufall.naechsteZahl(Territorium.getAnzahlSpalten()-1);
      willi.gotoKachel(reihe, spalte);
      willi.gib();
      haufen.drauflegen(new Position(reihe, spalte));
    }
    
    AllroundHamster james = new AllroundHamster(willi);
    
    // James laeuft zurueck und sammelt die Koerner wieder ein
    while (true) {
      Object objekt = haufen.herunternehmen();
      Position naechsteKachel = (Position)objekt; 
      james.gotoKachel(naechsteKachel.getReihe(), 
                       naechsteKachel.getSpalte());
      james.nimm();
    }
  } catch (StapelVollException vollExc) {
    willi.schreib("Fehler: Auf den Stapel passen nur " +
                  vollExc.getMaxGroesse() + " Werte!");
  } catch (StapelLeerException leerExc) {
    // kein Fehler; dient nur zum Abbrechen der while-true-Schleife
  }
}
}