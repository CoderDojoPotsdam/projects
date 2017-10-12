import de.hamster.debugger.model.Territorium;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;public class hamsterprogramm extends de.hamster.debugger.model.IHamster implements de.hamster.model.HamsterProgram {public void main()
{
    int breite = bestimmeBreite();
    linksUm();
    int hoehe = bestimmeHoehe();
    kehrt();
    graseFeldAb(breite, hoehe);
}

// ermittelt die Breite des Feldes;
// Seiteneffekt: der Hamster steht anschliessend am Rand 
//               des Kornfeldes
int bestimmeBreite()
{
    int breite = 1;
    // zunaechst in die eine Richtung
    while (vornFrei() && vornKorn())
    {
      vor(); breite = breite + 1;
    }
    kehrt();
    int zurueck = breite;
    while (zurueck > 1)
    {
      vor(); zurueck = zurueck - 1;
    }
    // dann in die andere Richtung
    while (vornFrei() && vornKorn())
    {
      vor(); breite = breite + 1;
    }
    return breite;
}

// ermittelt die Hoehe des Feldes;
// Seiteneffekt: der Hamster steht anschliessend in 
//               einer Ecke des Kornfeldes
int bestimmeHoehe()
{
    return bestimmeBreite();
}

// grast das Kornfeld mit der uebergebenen Groesse ab
void graseFeldAb(int breite, int hoehe)
{
    while (breite > 0)
    {
      graseReiheAbUndZurueck(hoehe);
      breite = breite - 1;
      if (breite > 0)
      {
        rechtsUm(); vor(); rechtsUm();
      }
    }
}

void graseReiheAbUndZurueck(int schritte)
{
    int zurueck = schritte;
    // hin (mit Aufsammeln) ...
    sammle();
    while (schritte > 1)
    {
      vor(); sammle();
      schritte = schritte - 1;
    }
    // ... und zurueck
    kehrt();
    while (zurueck > 1)
    {
      vor(); zurueck = zurueck - 1;
    }
}

// sammle alle Koerner auf einer Kachel auf
void sammle() { while (kornDa()) nimm(); }

// ueberprueft, ob die Kachel vor dem Hamster ein Korn enthaelt
// (ohne Seiteneffekte)
boolean vornKorn()
{
    if (!vornFrei()) return false;
    vor();
    boolean da = kornDa();
    kehrt(); vor(); kehrt();
    return da;
}

void rechtsUm() { kehrt(); linksUm(); }

void kehrt() { linksUm(); linksUm(); }}