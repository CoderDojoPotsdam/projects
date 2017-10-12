import de.hamster.debugger.model.Territorium;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;public class hamsterprogramm extends de.hamster.debugger.model.IHamster implements de.hamster.model.HamsterProgram {public void main()
{
    int stufen_anzahl = zaehleStufen();

    // nimm genuegend Koerner ins Maul
    while ((stufen_anzahl > 0) && kornDa())
    {
      nimm();
      stufen_anzahl = stufen_anzahl - 1;
    }

    erklimmeBerg();
}

// ermittle die Hoehe des Berges (ohne Seiteneffekte)
int zaehleStufen()
{
    // erklimme die einzelnen Stufen und vermerke die Anzahl
    int anzahl = 0;
    while (!gipfelErreicht())
    {
      erklimmeStufe();
      anzahl = anzahl + 1;
    }
    // zur Vermeidung von Seiteneffekten gehts nun wieder hinunter
    kehrt();
    int schritte = anzahl;
    while (schritte > 0)
    {
      klettereStufeHinunter();
      schritte = schritte - 1;
    }
    kehrt();
    return anzahl;
}

boolean gipfelErreicht()
{
    return vornFrei();
}

void erklimmeStufe()
{
    linksUm(); vor(); rechtsUm(); vor();
}

void klettereStufeHinunter()
{
    vor(); linksUm(); vor(); rechtsUm();
}

void erklimmeBerg()
{
    while (!gipfelErreicht())
    {
      erklimmeStufe();
      if (!maulLeer()) gib();
    }
}

void rechtsUm() { kehrt(); linksUm(); }

void kehrt() { linksUm(); linksUm(); }}