import de.hamster.debugger.model.Territorium;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;public class hamsterprogramm1 extends de.hamster.debugger.model.IHamster implements de.hamster.model.HamsterProgram {public void main()
{
    boolean gerade_anzahl = true; // 0 Koerner eingesammelt
    gerade_anzahl = sammle();
    while (vornFrei())
    {
      vor();
      boolean gesammelt = sammle();
      gerade_anzahl = 
        (gerade_anzahl && gesammelt) || 
        (!gerade_anzahl && !gesammelt);
        // gerade Zahl + gerade Zahl = gerade Zahl
        // ungerade Zahl + ungerade Zahl = gerade Zahl
        // alle anderen Faelle ergeben eine ungerade Zahl
    }
    if (gerade_anzahl)
    {
      while (!maulLeer())
      {
        gib();
      }
    }
}

// sammle alle Koerner auf aktuellem Feld auf; falls gerade 
// Anzahl an Koernern eingesammelt wurde, liefere true;
// ansonsten liefere false
boolean sammle()
{
    boolean gerade_anzahl = true;  // 0 Koerner eingesammelt
    while (kornDa())
    {
      nimm();
      gerade_anzahl = !gerade_anzahl;  
        // auf jede gerade folgt eine ungerade Zahl und umgekehrt
    }
    return gerade_anzahl;
}}