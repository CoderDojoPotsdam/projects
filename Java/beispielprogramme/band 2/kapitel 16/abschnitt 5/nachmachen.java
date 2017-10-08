import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;public class nachmachen implements de.hamster.model.HamsterProgram {public void main() {
    URLNachmachHamster paul = new URLNachmachHamster(
            Hamster.getStandardHamster(),
            "http://www-is.informatik.uni-oldenburg.de/~dibo/hamster/band2/weg.txt");
    paul.macheNach();
}}