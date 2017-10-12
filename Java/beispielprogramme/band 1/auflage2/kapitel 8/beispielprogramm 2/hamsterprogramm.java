import de.hamster.debugger.model.Territorium;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;public class hamsterprogramm extends de.hamster.debugger.model.IHamster implements de.hamster.model.HamsterProgram {public void main()
{
    bearbeiteEineReihe();
    // begib dich zur naechsten vollstaendigen Reihe
    linksUm(); vor(); gibUndVor(); linksUm();
    bearbeiteEineReihe();
    // bearbeite das Feld unter dir
    linksUm(); vor(); gib(); kehrt(); vor(); 
    // begib dich zur naechsten vollstaendigen Reihe
    vor(); gibUndVor(); rechtsUm();
    bearbeiteEineReihe();
    // bearbeite letztes Feld
    rechtsUm(); vor(); gib();
}

void bearbeiteEineReihe()
{
    gibUndVor(); gibUndVor(); gibUndVor(); gibUndVor();
    gibUndVor(); gibUndVor(); gibUndVor(); gibUndVor();
    gib();
}

void gibUndVor()
{
    gib(); vor();
}

void kehrt() 
{
    linksUm(); linksUm();
}

void rechtsUm() 
{
    kehrt(); linksUm();
}
}