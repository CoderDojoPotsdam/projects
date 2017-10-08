import landschaft.Landschaft;

import de.hamster.debugger.model.Territorium;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.debugger.model.Hamster;public class hamsterprogramm implements de.hamster.model.HamsterProgram {public void main() {
    AllroundHamster paul = new AllroundHamster(0, 0, Hamster.OST, 0);
    Landschaft gebiet = Landschaft.getLandschaft();
    for (int r=0; r<gebiet.getAnzahlReihen(); r++) {
      for (int s=0; s<gebiet.getAnzahlSpalten(); s++) {
        paul.gotoKachel(r, s);
        paul.nimmAlle();
      }
    }
}
}