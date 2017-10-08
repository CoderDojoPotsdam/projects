/*
 * der Hamster soll einzelne Koernerreihen abgrasen,
 * so lange noch weitere Reihen existieren; 
 * er unterscheidet dabei, ob er die Reihen von 
 * Osten oder von Westen aus abgrast
 */
import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;public class hamsterprogramm extends de.hamster.debugger.model.IHamster implements de.hamster.model.HamsterProgram {public void main() {
    ernteEineReiheNachOsten();
    while (weitereReiheLinksVomHamsterExistiert()) {
        begibDichLinksUmInNaechsteReihe();
        ernteEineReiheNachWesten();
        if (weitereReiheRechtsVomHamsterExistiert()) {
            begibDichRechtsUmInNaechsteReihe();
            ernteEineReiheNachOsten();
        } else {
            kehrt();
        }
    }
}

/*
 * der Hamster soll alle Koerner in einer Reihe einsammeln;
 * er laeuft dabei von Westen nach Osten
 */
void ernteEineReiheNachOsten() {
    ernteEineReihe();
}
 
/*
 * der Hamster soll alle Koerner in einer Reihe einsammeln;
 * er laeuft dabei von Osten nach Westen
 */
void ernteEineReiheNachWesten() {
    ernteEineReihe();
}
 
/*
 * der Hamster soll alle Koerner in einer Reihe einsammeln
 */
void ernteEineReihe() {
    sammle();
    while (vornFrei()) {
        vor(); 
        sammle();
    }
}
 
/*
 * der Hamster sammelt alle Koerner eines Feldes ein
 */
void sammle() {
    while (kornDa()) { 
        nimm(); 
    }
}

/*
 * Ueberpruefung, ob in noerdlicher Richtung (vom Hamster aus
 * gesehen links) eine weitere nicht mit Mauern besetzte
 * Reihe existiert
 */
boolean weitereReiheLinksVomHamsterExistiert() {
    return linksFrei();
}
 
/*
 * Ueberpruefung, ob in noerdlicher Richtung (vom Hamster aus
 * gesehen rechts) eine weitere nicht mit Mauern besetzte
 * Reihe existiert
 */
boolean weitereReiheRechtsVomHamsterExistiert() {
    return rechtsFrei();
}
 
/*
 * Ueberpruefung, ob sich links vom Hamster 
 * eine Mauer befindet
 */
boolean linksFrei() {
    linksUm();
    if (vornFrei()) {
        rechtsUm(); 
        return true;
    } else {
        rechtsUm(); 
        return false;
    }
}
 
/*
 * Ueberpruefung, ob sich rechts vom Hamster eine 
 * Mauer befindet
 */
boolean rechtsFrei() {
    rechtsUm();
    if (vornFrei()) {
        linksUm(); 
        return true;
    } else {
        linksUm(); 
        return false;
    }
}
 
/*
 * drehe dich um 90 Grad nach rechts
 */
void rechtsUm() { 
    kehrt(); 
    linksUm(); 
}
 
/*
 * drehe dich um 180 Grad
 */
void kehrt() { 
    linksUm(); 
    linksUm(); 
}

/*
 * der Hamster soll sich in die naechste Reihe in noerdlicher
 * Richtung begeben; vom Hamster aus gesehen, liegt diese Reihe
 * links von ihm
 */
void begibDichLinksUmInNaechsteReihe() {
    linksUm(); 
    vor(); 
    linksUm();
}
 
/*
 * der Hamster soll sich in die naechste Reihe in noerdlicher
 * Richtung begeben; vom Hamster aus gesehen, liegt diese Reihe
 * rechts von ihm
 */
void begibDichRechtsUmInNaechsteReihe() {
    rechtsUm(); 
    vor(); 
    rechtsUm();
}}