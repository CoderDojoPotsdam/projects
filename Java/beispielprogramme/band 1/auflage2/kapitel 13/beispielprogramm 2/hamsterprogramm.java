import de.hamster.debugger.model.Territorium;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;public class hamsterprogramm extends de.hamster.debugger.model.IHamster implements de.hamster.model.HamsterProgram {boolean entwederLinksOderRechtsFrei()
{
    /*  Wahrheitstafel fuer "entweder oder"-Aussage

        P Q   entweder-oder   !(P&&Q) && (P||Q)
       -----------------------------------------
        T T        F                 F
        T F        T                 T
        F T        T                 T
        F F        F                 F
    */

    linksUm();
    boolean p = vornFrei();
    kehrt();
    boolean q = vornFrei();
    linksUm();
    return !(p&&q) && (p||q);
}

void kehrt()
{
    linksUm(); linksUm();
}

public void main() // einfaches Testprogramm 
{ 
    if (entwederLinksOderRechtsFrei()) 
      linksUm(); 
    else 
      kehrt(); 
} 
}