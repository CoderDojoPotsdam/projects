import de.hamster.debugger.model.Territorium;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.debugger.model.Hamster;class MogelHamster extends SpielHamster {
  MogelHamster(int r, int s, Wuerfel w) {
    super(r, s, w);
    // tauscht heimlich den korrekten gegen einen manipulierten
    // Wuerfel aus
    this.wuerfel = new ManipulierterWuerfel();
  }
}
