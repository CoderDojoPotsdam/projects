import de.hamster.debugger.model.Territorium;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;public class hamsterprogramm2 extends de.hamster.debugger.model.IHamster implements de.hamster.model.HamsterProgram {public void main()
{
    if (kornDa()) // der Hamster steht bereits auf einem Kornfeld
    {
      // nehme erstes Korn
      nimm();
    } 
    else 
    {
      // suche und nehme erstes Korn
      vor(); vor(); nimm();
      linksUm();
    }
    // suche und nehme zweites Korn
    vor(); vor(); nimm();
}
}