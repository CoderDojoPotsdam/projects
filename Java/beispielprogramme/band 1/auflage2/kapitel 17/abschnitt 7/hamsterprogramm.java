import de.hamster.debugger.model.Territorium;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;public class hamsterprogramm extends de.hamster.debugger.model.IHamster implements de.hamster.model.HamsterProgram {public void main()
{
    sucheGangAb();
}

boolean gefunden = false;
  
void sucheGangAb()
{
    if (kornDa()) // Problem geloest
    {
      nimm();
      gefunden = true;
    }

    // Suche nach Abzweigungen
  
    if (!gefunden && linksFrei()) 
    { // links vorhandenen Gang absuchen
      linksUm();
      vor();
      sucheGangAb();
      vor();
      linksUm();
    }
  
    if (!gefunden && rechtsFrei()) 
    { // rechts vorhandenen Gang absuchen
      rechtsUm();
      vor();
      sucheGangAb();
      vor();
      rechtsUm();
    }
  
    if (!gefunden && vornFrei())
    { // restlichen Gang absuchen
      vor();
      sucheGangAb();
      vor();  // zuruecklaufen
    }
    else
    {
      kehrt();
    }
}
  
boolean linksFrei()
{
    linksUm();
    boolean frei = vornFrei();
    rechtsUm();
    return frei;
}
  
boolean rechtsFrei()
{
    rechtsUm();
    boolean frei = vornFrei();
    linksUm();
    return frei;
}
  
void rechtsUm() { linksUm(); kehrt(); }
  
void kehrt() { linksUm(); linksUm(); }}