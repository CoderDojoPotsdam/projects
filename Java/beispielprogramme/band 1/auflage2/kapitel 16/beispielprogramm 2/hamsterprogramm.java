import de.hamster.debugger.model.Territorium;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;public class hamsterprogramm extends de.hamster.debugger.model.IHamster implements de.hamster.model.HamsterProgram {public void main()
{
    int radius = 1;     // lokale Variable; speichert
                        // die Groesse des aktuellen Radius
    while (!kornDa())
    {
      testeEinenKreis(radius); 
        // radius wird als Parameter uebergeben
      radius = radius + 1;        
        // nach jeder Runde wird der Radius ein Feld groesser
    }
    nimm();
}
 
void testeEinenKreis(int radius)
{
    int richtungen = 0;  
    while (!kornDa() && (richtungen < 4)) // ein Kreis besteht aus
                                          // vier Richtungen
    {
      testeEineRichtung(radius);
      richtungen = richtungen + 1;
    }
}
    
void testeEineRichtung(int radius)
{
    int schritte = 0;
    while (!kornDa() && (schritte < radius) && vornFrei())
    {
      vor();
      schritte = schritte + 1;
    }
      // die Ueberpruefung einer Richtung besteht aus der 
      // Ueberpruefung von so vielen Feldern, wie der Radius 
      // des Kreises aktuell betraegt
    if (!kornDa()) 
    {
      linksUm();
    }
}}