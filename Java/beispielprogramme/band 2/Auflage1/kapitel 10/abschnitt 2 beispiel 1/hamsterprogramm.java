import de.hamster.debugger.model.Territorium;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.debugger.model.Hamster;public class hamsterprogramm implements de.hamster.model.HamsterProgram {public void main() {
    Hamster paul = new Hamster(3, 4, Hamster.OST, 3);
    paul.schreib("Ich habe " + 
                 paul.getAnzahlKoerner() + 
                 " Koerner im Maul!");
}}