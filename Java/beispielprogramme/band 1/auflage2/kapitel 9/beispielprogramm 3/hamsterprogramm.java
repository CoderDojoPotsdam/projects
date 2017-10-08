  import de.hamster.debugger.model.Territorium;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;public class hamsterprogramm extends de.hamster.debugger.model.IHamster implements de.hamster.model.HamsterProgram {public void main()
  {
    ueberpruefeEineReihe();
    linksUm(); vor(); linksUm();
    ueberpruefeEineReihe();
    rechtsUm(); vor(); rechtsUm();
    ueberpruefeEineReihe();
    linksUm(); vor(); linksUm();
    ueberpruefeEineReihe();
    rechtsUm(); vor(); rechtsUm();
    ueberpruefeEineReihe();
  }

  void ueberpruefeEineReihe()
  {
    evtlFressen(); vor();
    evtlFressen(); vor();
    evtlFressen(); vor();
    evtlFressen(); vor();
    evtlFressen(); 
  }

  void evtlFressen()
  {
    // erstmal ein Korn fressen
    nimm();
    // falls es das einzige Korn war, muss es wieder abgelegt werden
    if (!kornDa())
    {
      gib();
    }
  }

  void rechtsUm() { linksUm(); linksUm(); linksUm(); }
}