import de.hamster.debugger.model.Territorium;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;public class hamsterprogramm1 extends de.hamster.debugger.model.IHamster implements de.hamster.model.HamsterProgram {public void main() 
{
    // nehme erstes Korn
    vor(); vor(); nimm();

    // nehme zweites Korn
    linksUm(); vor(); vor(); nimm();
}
}