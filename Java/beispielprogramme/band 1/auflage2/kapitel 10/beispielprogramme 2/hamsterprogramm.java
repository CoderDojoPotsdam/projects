import de.hamster.debugger.model.Territorium;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;public class hamsterprogramm extends de.hamster.debugger.model.IHamster implements de.hamster.model.HamsterProgram {public void main()
{
    begibDichInEineEcke();

    // der Hamster kann leider (noch) nicht zaehlen; er 
    // fuehrt deshalb viermal dieselbe Anweisungssequenz aus
    gib(); laufeInDieNaechsteEcke(); linksUm();
    gib(); laufeInDieNaechsteEcke(); linksUm();
    gib(); laufeInDieNaechsteEcke(); linksUm();
    gib();
}

void begibDichInEineEcke()
{
    laufeZurNaechstenWand(); linksUm();
    laufeZurNaechstenWand(); linksUm();
}

void laufeZurNaechstenWand()
{
    while (vornFrei())
    {
      vor();
    }
}
 
void laufeInDieNaechsteEcke() { laufeZurNaechstenWand(); }
}