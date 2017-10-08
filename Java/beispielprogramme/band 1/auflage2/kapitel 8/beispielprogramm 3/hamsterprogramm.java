import de.hamster.debugger.model.Territorium;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;public class hamsterprogramm extends de.hamster.debugger.model.IHamster implements de.hamster.model.HamsterProgram {public void main() 
{
    laufeZumBerg();
    erklimmeErsteStufe();
    erklimmeZweiteStufe();
    erklimmeDritteStufe();
    erklimmeGipfel();
}

void laufeZumBerg() 
{
    vor();
}

void erklimmeErsteStufe() { erklimmeStufe(); }

void erklimmeZweiteStufe() { erklimmeStufe(); }

void erklimmeDritteStufe() { erklimmeStufe(); }

void erklimmeGipfel() { erklimmeStufe(); }

void erklimmeStufe() 
{
    linksUm(); vor();
    linksUm(); linksUm(); linksUm(); vor();
}
}