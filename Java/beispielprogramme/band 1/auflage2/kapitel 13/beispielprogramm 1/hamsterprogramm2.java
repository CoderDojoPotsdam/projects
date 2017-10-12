  // globale Variable
import de.hamster.debugger.model.Territorium;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;public class hamsterprogramm2 extends de.hamster.debugger.model.IHamster implements de.hamster.model.HamsterProgram {boolean gerade_anzahl = true; // 0 Koerner eingesammelt

public void main()  
{
    sammle();
    while (vornFrei())
    {
      vor();
      sammle();
    }
    if (gerade_anzahl)  // Zugriff auf globale Variable
    {
      while (!maulLeer())
      {  
        gib();   
      }
    } 
}   
    
// sammle alle Koerner auf aktuellem Feld auf
void sammle()
{
    while (kornDa())
    {
      nimm();
      gerade_anzahl = !gerade_anzahl;  
        // auf jede gerade folgt eine ungerade Zahl und umgekehrt
    }
}
}