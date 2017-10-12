import de.hamster.debugger.model.Territorium;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;public class hamsterprogramm extends de.hamster.debugger.model.IHamster implements de.hamster.model.HamsterProgram {public void main()
{
    ernteEineReiheUndLaufeZurueck();
    rechtsUm();
    while (vornFrei())
    {
      vor(); 
      rechtsUm();
      ernteEineReiheUndLaufeZurueck();
      rechtsUm();
    }
}

void ernteEineReiheUndLaufeZurueck()
{
    ernteEineReihe();
    kehrt();
    laufeZurueck();
}

void ernteEineReihe()
{
    sammle();
    while (vornFrei())
    {
      vor();
      sammle();
    }
}

void laufeZurueck()
{
    while (vornFrei())
    {
      vor();
    }
}

void sammle()
{
    while (kornDa())
    {
      nimm();
    }
}

void rechtsUm() { kehrt(); linksUm(); }

void kehrt() { linksUm(); linksUm(); }
}