package spiel;

import de.hamster.debugger.model.Territorium;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.debugger.model.Hamster;public interface Spieler {
  // Ausfuehren eines Spielzuges; es wird genau dann true geliefert,
  // wenn der Spieler nach dem Spielzug gewonnen hat
  public abstract boolean spielzug();
}
