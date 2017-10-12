import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;public class BspProgramm1 implements de.hamster.model.HamsterProgram {public void main() {
  // neuer normaler DrehHamster
  DrehHamster willi = new DrehHamster(1, 2, Hamster.OST, 3);
  while (willi.vornFrei()) {
    willi.vor();
  }
  willi.rechtsUm();

  // Standard-Hamster als DrehHamster
  DrehHamster paul = DrehHamster.getStandardHamsterAlsDrehHamster();
  while (paul.vornFrei()) {
    paul.vor();
  }
  paul.rechtsUm();
}}