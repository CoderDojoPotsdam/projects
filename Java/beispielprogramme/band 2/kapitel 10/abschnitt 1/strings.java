import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;public class strings implements de.hamster.model.HamsterProgram {public void main() {
    String str1 = "Hallo Paul!";
    String str2 = "Hallo Willi!";

    boolean b1 = str1.equals(str2); // liefert false

    int vergleich = str1.compareTo(str2); // vergleich < 0

    boolean b2 = 
        str1.startsWith(new String("Hallo")); // liefert true
    // oder kurz: boolean b2 = str1.startsWith("Hallo");
    
    boolean b3 = str2.endsWith("!"); // liefert true

    String str3 = str1.concat(" Wie geht es dir?");
    // str3 repraesentiert "Hallo Paul! Wie geht es dir?"

    String str4 = str1.substring(0, 5);
    // str4 repraesentiert "Hallo"

    int laenge = str4.length(); // liefert 5
    int indexF = str3.indexOf(" "); // liefert 5
    int indexL = str3.lastIndexOf(" "); // liefert 23

    String str5 = String.valueOf(b1); // repraesentiert "false"
    String str6 = 
        String.valueOf(indexF - indexL); // repraesentiert "-18"
}
}