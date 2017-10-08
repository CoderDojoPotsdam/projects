import de.hamster.debugger.model.Territorium;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;public class hamsterprogramm extends de.hamster.debugger.model.IHamster implements de.hamster.model.HamsterProgram {public void main()
{
    gib(); // markiere Ausgangsposition
    vor();
    while (!kornDa()) // irgendwann kehrt der Hamster hierher zurueck
    {
      while (vornFrei() && !rechtsFrei() && !kornDa())
      {
        vor();
      }
      if (!kornDa()) // Ausgangsposition erreicht
      {
        if (rechtsFrei())
        {
          rechtsUm();
          vor();
        }
        else // vorne und rechts stehen Mauern
        {
          linksUm();
        }
      }
    }
}

boolean rechtsFrei()
{
    rechtsUm();
    if (vornFrei())
    {
      linksUm(); return true;
    }
    else
    {   
      linksUm(); return false;
    }
}  

void rechtsUm() { linksUm(); linksUm(); linksUm(); }}