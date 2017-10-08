import de.hamster.debugger.model.Territorium;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.debugger.model.Hamster;class ZeichneZahlHamster extends Hamster {

    int abstand = 0; // Hilfsattribut

    ZeichneZahlHamster(int r, int s, int b, int k) {
      super(r, s, b, k);
    }

    // zeichnet die uebergebene Zahl mit Koernern ins Territorium
    void zeichne(int zahl) { 
      if (zahl < 0) return;
      ZeichneZifferHamster[] ziffernHamster = 
        erzeugeZifferHamster();
      this.abstand = 0;
      this.zeichne(zahl, ziffernHamster);
    }

    // erzeugt Array mit konkreten Hamstern
    ZeichneZifferHamster[] erzeugeZifferHamster() {
      int r = this.getReihe();
      int s = this.getSpalte();
      ZeichneZifferHamster[] ziffernHamster = 
        new ZeichneZifferHamster[10];
      // Einsatz der Polymorphie!
      ziffernHamster[0] = 
        new ZeichneNullHamster(r, s, Hamster.OST, 
                               this.getAnzahlKoerner());
      ziffernHamster[1] = 
        new ZeichneEinsHamster(r, s, Hamster.OST, 
                               this.getAnzahlKoerner());
      ziffernHamster[2] = 
        new ZeichneZweiHamster(r, s, Hamster.OST, 
                               this.getAnzahlKoerner());
      ziffernHamster[3] = 
        new ZeichneDreiHamster(r, s, Hamster.OST, 
                               this.getAnzahlKoerner());
      ziffernHamster[4] = 
        new ZeichneVierHamster(r, s, Hamster.OST, 
                               this.getAnzahlKoerner());
      ziffernHamster[5] = 
        new ZeichneFuenfHamster(r, s, Hamster.OST, 
                               this.getAnzahlKoerner());
      ziffernHamster[6] = 
        new ZeichneSechsHamster(r, s, Hamster.OST, 
                               this.getAnzahlKoerner());
      ziffernHamster[7] = 
        new ZeichneSiebenHamster(r, s, Hamster.OST, 
                               this.getAnzahlKoerner());
      ziffernHamster[8] = 
        new ZeichneAchtHamster(r, s, Hamster.OST, 
                               this.getAnzahlKoerner());
      ziffernHamster[9] = 
        new ZeichneNeunHamster(r, s, Hamster.OST, 
                               this.getAnzahlKoerner());
      return ziffernHamster;
    }

    // rekursive Hilfsmethode
    void zeichne(int zahl, ZeichneZifferHamster[] ziffernHamster) { 
      if (zahl > 9) {
        this.zeichne(zahl/10, ziffernHamster);
      } 
      int ziffer = zahl % 10;
      ziffernHamster[ziffer].vor(this.abstand);
      ziffernHamster[ziffer].zeichne();  // dynamisch gebunden!
      ziffernHamster[ziffer].kehrt();
      ziffernHamster[ziffer].vor(this.abstand);
      ziffernHamster[ziffer].kehrt();
      this.abstand = this.abstand + 4;
    }
}
