import de.hamster.debugger.model.Territorium;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;public class hamsterprogramm extends de.hamster.debugger.model.IHamster implements de.hamster.model.HamsterProgram {public void main()
{
    do {
      // ermittle Richtung, in die der Hamster sich wenden muss
      int richtung = ermittleDrehungen();
      if (richtung == -1) return;  
        // -1: auf keinem der Nachbarfelder
        // existiert ein Korn -> Aufgabe geloest

      // drehe dich entsprechend oft
      while (richtung > 0)
      {
        linksUm();
        richtung = richtung - 1;
      }

      vor();
      while (kornDa()) nimm();
    } while (true);  
      // Endlosschleife wird durch obiges return vermieden
}

// ermittelt die Richtung, in die der Hamster sich drehen muss;
// liefert die Anzahl an Linksdrehungen, die der Hamster 
// durchfuehren muss, um in die korrekte Richtung zu blicken;
// Korrekt ist die Richtung mit der benachbarten Kachel mit 
// den meisten Koernern (ohne Seiteneffekte);
// liefert -1 falls kein Nachbarfeld mehr Koerner enthaelt
int ermittleDrehungen()
{
    int drehungen = 0;
    int koerner_anzahl = koernerAnzahlVorn();
    int schleifenzaehler = 1;
    while (schleifenzaehler <= 3)
    {
      linksUm();
      int neue_koerner_anzahl = koernerAnzahlVorn();
      if (neue_koerner_anzahl > koerner_anzahl)
      {
        drehungen = schleifenzaehler;
        koerner_anzahl = neue_koerner_anzahl;
      }
      schleifenzaehler = schleifenzaehler + 1;
    }
    // zur Vermeidung von Seiteneffekten
    linksUm();
    if (koerner_anzahl == 0)
      return -1;  // keine Koerner mehr auf Nachbarfeldern
    return drehungen;
}

// liefert die Anzahl Koerner auf der Kachel vor dem Hamster
// (ohne Seiteneffekte)
int koernerAnzahlVorn()
{
    if (!vornFrei()) return 0;
    vor();
    int anzahl = koernerAnzahl();
    // zur Vermeidung von Seiteneffekten
    kehrt(); vor(); kehrt();
    return anzahl;
}

// liefert die Anzahl Koerner auf einer Kachel 
// (ohne Seiteneffekte)
int koernerAnzahl()
{
    int anzahl = 0;
    while (kornDa())
    {
      nimm();
      anzahl = anzahl + 1;
    }
    // zur Vermeidung von Seiteneffekten
    int schritte = anzahl;
    while (schritte > 0)
    {
      gib();
      schritte = schritte - 1;
    }
    return anzahl;
}

void kehrt()
{
    linksUm(); linksUm();
}}