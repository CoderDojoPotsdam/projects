import de.hamster.debugger.model.Territorium;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.debugger.model.Hamster;public class EinUndAusgabe implements de.hamster.model.HamsterProgram {class Zahl {
    int zahl = 4711;
}

class AusgabeHamster extends Hamster {

    Zahl zahlObjekt;

    AusgabeHamster(Zahl zahl) {
        super(0, 0, Hamster.OST, 0);
        this.zahlObjekt = zahl;
    }

    public void run() {
        this.schreib("" + zahlObjekt.zahl);
    }
}

class EingabeHamster extends Hamster {

    Zahl zahlObjekt;

    EingabeHamster(Zahl zahl) {
        super(0, 0, Hamster.OST, 0);
        this.zahlObjekt = zahl;
    }

    public void run() {
        zahlObjekt.zahl = this.liesZahl("Zahl eingeben: ");
    }
}

public void main() {
    Zahl gemeinsameZahl = new Zahl();
    Hamster heidi = new AusgabeHamster(gemeinsameZahl);
    Hamster maria = new EingabeHamster(gemeinsameZahl);
    heidi.start();
    maria.start();
}}