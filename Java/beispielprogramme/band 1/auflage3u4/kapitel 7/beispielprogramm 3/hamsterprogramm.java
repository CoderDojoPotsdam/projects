import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;public class hamsterprogramm extends de.hamster.debugger.model.IHamster implements de.hamster.model.HamsterProgram {public void main() {

    // laufe zum Berg
    vor(); 

    // erklimme erste Stufe
    linksUm(); 
    vor(); 
    linksUm(); 
    linksUm(); 
    linksUm(); 
    vor();

    // erklimme zweite Stufe
    linksUm(); 
    vor(); 
    linksUm(); 
    linksUm(); 
    linksUm(); 
    vor();

    // erklimme dritte Stufe
    linksUm(); 
    vor(); 
    linksUm(); 
    linksUm(); 
    linksUm(); 
    vor();

    // erklimme Gipfel
    linksUm(); 
    vor(); 
    linksUm(); 
    linksUm(); 
    linksUm(); 
    vor();
}}