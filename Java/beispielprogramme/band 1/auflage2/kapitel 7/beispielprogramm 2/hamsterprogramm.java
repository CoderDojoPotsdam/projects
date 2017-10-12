import de.hamster.debugger.model.Territorium;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;public class hamsterprogramm extends de.hamster.debugger.model.IHamster implements de.hamster.model.HamsterProgram {public void main() 
{
    // begib dich an den Rand
    vor(); linksUm();
    // laufe in die rechte untere Ecke
    vor(); vor(); vor(); vor(); gib(); linksUm();
    // laufe in die rechte obere Ecke
    vor(); vor(); vor(); gib(); linksUm();
    // laufe in die linke obere Ecke
    vor(); vor(); vor(); vor(); vor(); gib(); linksUm();
    // laufe in die linke untere Ecke
    vor(); vor(); vor(); gib(); linksUm();
    // begib dich in deine Ausgangsposition zurueck
    vor(); linksUm(); vor(); linksUm(); linksUm();
}
}