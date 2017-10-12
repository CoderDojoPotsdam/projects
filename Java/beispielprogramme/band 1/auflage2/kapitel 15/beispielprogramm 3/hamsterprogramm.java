import de.hamster.debugger.model.Territorium;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;public class hamsterprogramm extends de.hamster.debugger.model.IHamster implements de.hamster.model.HamsterProgram {public void main()
{
    begibDichInEineEcke();

    // Bestimmung von Breite und Laenge des Feldes
    int breite = bestimmeLaenge();
    linksUm();
    int hoehe = bestimmeLaenge();
    rechtsUm();

    // Berechnung des Umfangs des Feldes
    int umfang;
    if (breite == 1)
      umfang = hoehe;
    else if (hoehe == 1)
      umfang = breite;
    else
      umfang = 2*breite + 2*(hoehe-2);

    // Aktion
    if (bestimmeKoernerImMaul() >= umfang)
    {
      legeKoernerAmRandAb();
    }
}

// begib dich in eine Ecke des Raumes
void begibDichInEineEcke()
{
    // zum naechsten Rand
    while (vornFrei()) vor();
    linksUm();
    // in die naechste Ecke
    while (vornFrei()) vor();
    linksUm();
}

// bestimmt die Anzahl an freien Feldern vor dem Hamster
// (ohne Seiteneffekte)
int bestimmeLaenge()
{
    int laenge = 1;
    while (vornFrei())
    {
      vor();
      laenge = laenge + 1;
    }
    // und zurueck (zur Vermeidung von Seiteneffekten)
    int zurueck = laenge;
    kehrt();
    while (zurueck > 1) 
    {
      vor();
      zurueck = zurueck - 1;
    }
    kehrt();
    return laenge;
}

// bestimmt die Anzahl an Koernern, die der Hamster im Maul hat
// (ohne Seiteneffekte)
int bestimmeKoernerImMaul()
{
    int anzahl = 0;
    while (!maulLeer())
    {
      gib();
      anzahl = anzahl + 1;
    }
    // zur Vermeidung von Seiteneffekten: 
    //   Koerner wieder aufsammeln
    int koerner = anzahl;
    while (koerner > 0)
    {
      nimm();
      koerner = koerner - 1;
    }
    return anzahl;
}

// lege an allen Randkacheln des Raumes (es existieren
// maximal 4 Waende) je ein Korn ab
void legeKoernerAmRandAb()
{
    int richtungen = 0;
    while (richtungen < 4) {
      while (vornFrei())
      {
        vor();
        if (!kornDa()) gib();
      }
      linksUm();
      richtungen = richtungen + 1;
    }
}

void rechtsUm() { linksUm(); kehrt(); }

void kehrt() { linksUm(); linksUm(); }}