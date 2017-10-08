package beispiel;

import de.hamster.debugger.model.Territorium;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.debugger.model.Hamster;public class Beispiel {
  private   int iPrivate;
            int iOhne;
  protected int iProtected;
  public    int iPublic;

  public Beispiel() {
    this.iPrivate = 0;
    this.iOhne = 1;
    this.iProtected = 2;
    this.iPublic = 3;
  }

  public Beispiel(Beispiel obj) {
    this.iPrivate = obj.iPrivate;
    this.iOhne = obj.iOhne;
    this.iProtected = obj.iProtected;
    this.iPublic = obj.iPublic;
  }
}