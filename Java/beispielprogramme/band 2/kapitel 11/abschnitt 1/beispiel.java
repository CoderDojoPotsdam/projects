import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;public class beispiel implements de.hamster.model.HamsterProgram {class KindHamster1 extends Hamster {

    KindHamster1(int r, int s, int b, int k) {
        super(r, s, b, k);
    }

    void kehrt() {
        this.linksUm();
        this.linksUm();
    }
}

class KindHamster2 extends Hamster {

    KindHamster2(int r, int s, int b, int k) {
        super(r, s, b, k);
    }

    void sammle() {
        while (this.kornDa()) {
            this.nimm();
        }
    }
}

class EnkelHamster1 extends KindHamster1 {

    EnkelHamster1(int r, int s, int b, int k) {
        super(r, s, b, k);
    }

    void rechtsUm() {
        this.kehrt();
        this.linksUm();
    }
}

public void main() {
    /* 1 */   Hamster karin = 
                new Hamster(0, 0, Hamster.OST, 0);
    /* 2 */   Hamster paul = 
                new KindHamster1(1, 1, Hamster.OST, 0);
    /* 3 */   Hamster willi = 
                new KindHamster2(2, 2, Hamster.OST, 0);
    /* 4 */   Hamster otto = 
                new EnkelHamster1(3, 3, Hamster.OST, 0);
    /* 5 */   KindHamster1 josef = 
                new EnkelHamster1(5, 5, Hamster.OST, 0);
    /* 6 */   // KindHamster1 sepp = new Hamster(6, 6, Hamster.OST, 0); // Fehler
    /* 7 */   // KindHamster1 gisela = new KindHamster2(7, 7, Hamster.OST, 0); // Fehler
              // ...
}}