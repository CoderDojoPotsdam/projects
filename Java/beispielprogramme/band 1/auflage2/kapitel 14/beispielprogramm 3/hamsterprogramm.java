import de.hamster.debugger.model.Territorium;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;public class hamsterprogramm extends de.hamster.debugger.model.IHamster implements de.hamster.model.HamsterProgram {int radius = 1;  // speichert die Groesse des aktuellen Radius

public void main()
{
    while (!kornDa())
    {
      testeEinenKreis();
      radius = radius + 1;  // nach jeder Runde wird der
                            // Radius ein Feld groesser
    }
    nimm();
}

void testeEinenKreis()
{
    int richtungen = 0;
    while (!kornDa() && (richtungen < 4)) // ein Kreis besteht 
                                          // aus vier Richtungen
    {
      testeEineRichtung();
      richtungen = richtungen + 1;
    }
}

void testeEineRichtung()
{
    int schritte = 0;
    while (!kornDa() && (schritte < radius) && vornFrei())
    {
      vor();
      schritte = schritte + 1;
    }
      // die Ueberpruefung einer Richtung besteht aus der 
      // Ueberpruefung von so vielen Feldern, wie der Radius 
      // des Kreises aktuell gross ist; die zusaetzliche 
      // Konjunktion mit vornFrei() ist notwendig, wenn das 
      // Feld nicht quadratisch ist
    if (!kornDa()) 
    {
      linksUm();
    }
}
}