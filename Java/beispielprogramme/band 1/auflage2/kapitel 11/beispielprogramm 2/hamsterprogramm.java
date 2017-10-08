import de.hamster.debugger.model.Territorium;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;public class hamsterprogramm extends de.hamster.debugger.model.IHamster implements de.hamster.model.HamsterProgram {public void main()
{
    // finde die Mulde
    while (!rechtsFrei()) { vor(); }

    // begib dich in die Mulde
    rechtsUm(); vor(); linksUm();

    // friss die Koerner
    graseReiheAb();
    while (begibDichInNaechsteReiheVonOst())
    {
      graseReiheAb();
      if (begibDichInNaechsteReiheVonWest())
      {
        graseReiheAb();
      }
    }
}

void graseReiheAb()
{
    sammle();
    while (vornFrei())
    {
      vor();
      sammle();
    }
}

void sammle()
{
    while (kornDa()) { nimm(); }
}

// Achtung: Die Funktion produziert Seiteneffekte!
boolean begibDichInNaechsteReiheVonOst()
{
    kehrt();
    // finde naechste Nische
    while (vornFrei() && !linksFrei())
    {
      vor();
    }
    if (!linksFrei())
    {
      // Ende der Mulde erreicht
      return false;
    }
    else
    {
      // begib dich in naechste Reihe
      linksUm(); vor(); rechtsUm();
      return true;
    }
}

// Achtung: Die Funktion produziert Seiteneffekte!
boolean begibDichInNaechsteReiheVonWest()
{
    kehrt();
    // finde naechste Nische
    while (vornFrei() && !rechtsFrei())
    {
      vor();
    }
    if (!rechtsFrei())
    {
      // Ende der Mulde erreicht
      return false;
    }
    else
    {
      // begib dich in naechste Reihe
      rechtsUm(); vor(); linksUm();
      return true;
    }
}

boolean linksFrei()
{
    linksUm();
    if (vornFrei())
    {
      rechtsUm(); return true;
    }
    else
    {   
      rechtsUm(); return false;
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

void rechtsUm() { kehrt(); linksUm(); }

void kehrt() { linksUm(); linksUm(); }
}