import de.hamster.debugger.model.Territorium;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;public class hamsterprogramm extends de.hamster.debugger.model.IHamster implements de.hamster.model.HamsterProgram {public void main()
{
    int schritte = 0;  // zum Abspeichern der gelaufenen Schritte

    // laufe bis zur Wand
    while (vornFrei())
    {
      vor();
      schritte = schritte + 1;  // die Schritte werden vermerkt
    }

    // kehre um
    linksUm(); linksUm();

    // laufe zurueck:
    // die Schleife wird so oft durchlaufen, wie der
    // Hamster Schritte bis zur Wand benoetigt hat
    while (schritte > 0)  
    {                     
      vor();
      schritte = schritte - 1;
    }
}}