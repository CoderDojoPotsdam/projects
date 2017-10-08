// Hilfsklasse zum Speichern der eigentlichen Werte
import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;class SpeicherElement {
    int wert; // der gespeicherte Wert

    SpeicherElement naechstes; // Referenz zum naechsten Element

    SpeicherElement(int wert) {
        this.wert = wert;
        this.naechstes = null;
    }

    int getWert() {
        return this.wert;
    }

    SpeicherElement getNaechstes() {
        return this.naechstes;
    }

    void setNaechstes(SpeicherElement elem) {
        this.naechstes = elem;
    }
}

class Speicher {

    SpeicherElement erstes; // Referenz zum ersten Element

    int anzahl; // Anzahl an gespeicherten Werten

    Speicher() {
        this.erstes = null;
        this.anzahl = 0;
    }

    // fuegt einen uebergebenen Wert hinten an den Speicher an
    void hinzufuegen(int wert) {
        SpeicherElement neuesElement = new SpeicherElement(wert);
        this.anzahl = this.anzahl + 1;
        if (this.erstes == null) {
            this.erstes = neuesElement;
        } else {
            SpeicherElement elem = this.erstes;
            while (elem.getNaechstes() != null) {
                elem = elem.getNaechstes();
            }
            elem.setNaechstes(neuesElement);
        }
    }

    // entfernt den uebergebenen Wert aus dem Speicher;
    // kommt er mehrfach im Speicher vor, werden alle
    // Vorkommen entfernt
    void entfernen(int wert) {
        while (this.erstes != null
                && this.erstes.getWert() == wert) {
            this.erstes = this.erstes.getNaechstes();
            // erstes ist damit aus dem Speicher entfernt
        }
        if (this.erstes == null)
            return;

        SpeicherElement vorheriges = this.erstes;
        SpeicherElement merker = vorheriges.getNaechstes();
        while (merker != null) {
            if (merker.getWert() == wert) {
                vorheriges.setNaechstes(merker.getNaechstes());
                // Element ist damit aus dem Speicher entfernt
            } else {
                vorheriges = merker;
            }
            merker = merker.getNaechstes();
        }
    }

    // ueberprueft, ob der uebergebene Wert im Speicher
    // gespeichert ist
    boolean istEnthalten(int wert) {
        SpeicherElement elem = this.erstes;
        while (elem != null) {
            if (elem.getWert() == wert) {
                return true;
            }
            elem = elem.getNaechstes();
        }
        return false;
    }

    // liefert die Anzahl an gespeicherten Werten
    int getAnzahl() {
        return this.anzahl;
    }

    // die naechsten drei Funktionen liefern im Zusammenspiel der
    // Reihe nach die gespeicherten Werte

    SpeicherElement merker = null;

    void beginnDurchlauf() {
        this.merker = this.erstes;
    }

    boolean endeErreicht() {
        return this.merker == null;
    }

    int liefereNaechstenWert() {
        int wert = this.merker.getWert();
        this.merker = this.merker.getNaechstes();
        return wert;
    }
}