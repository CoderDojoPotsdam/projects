import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;public class Arrays {

    // ersetzt alle Elemente des Arrays durch obj
    public static <T> void replace(Array<? super T> array, T obj) {
        for (int i = 0; i < array.size(); i++) {
            array.set(i, obj);
        }
    }

    // fuegt alle angegebenen Elemente dem Array hinzu
    public static <T> void addAll(Array<? super T> array,
            T... elements) {
        for (T element : elements) {
            array.add(element);
        }
    }
}