import de.hamster.debugger.model.Territorium;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.debugger.model.Hamster;class AllroundHamster extends Hamster {

  // initialisiert einen neuen AllroundHamster mit den
  // uebergebenen Werten
  AllroundHamster(int r, int s, int b, int k) {
    super(r, s, b, k);
  }
  
  // initialisiert einen neuen AllroundHamster mit den
  // Attributwerten eines bereits existierenden Hamsters
  AllroundHamster(Hamster existierenderHamster) {
    super(existierenderHamster);
  }
  
  // der Hamster dreht sich um 180 Grad
  void kehrt() {
    this.linksUm();
    this.linksUm();
  }
  
  // der Hamster dreht sich nach rechts
  void rechtsUm() {
    this.kehrt();
    this.linksUm();
  }

  // der Hamster laeuft "anzahl" Schritte, maximal jedoch
  // bis zur naechsten Mauer;
  // geliefert wird die tatsaechliche Anzahl gelaufener
  // Schritte
  int vor(int anzahl) {
    int schritte = 0;
    while (this.vornFrei() && anzahl > 0) {
      this.vor();
      schritte = schritte + 1;
      anzahl = anzahl - 1;
    }
    return schritte;
  }

  // der Hamster legt "anzahl" Koerner ab, maximal jedoch 
  // so viele, wie er im Maul hat;
  // geliefert wird die tatsaechliche Anzahl abgelegter
  // Koerner
  int gib(int anzahl) {
    int abgelegteKoerner = 0;
    while (!this.maulLeer() && anzahl > 0) {
      this.gib();
      abgelegteKoerner = abgelegteKoerner + 1;
      anzahl = anzahl - 1;
    }
    return abgelegteKoerner;
  }

  // der Hamster frisst "anzahl" Koerner, maximal jedoch
  // so viele, wie auf der aktuellen Kachel liegen;
  // geliefert wird die tatsaechliche Anzahl gefressener
  // Koerner
  int nimm(int anzahl) {
    int gefresseneKoerner = 0;
    while (this.kornDa() && anzahl > 0) {
      this.nimm();
      gefresseneKoerner = gefresseneKoerner + 1;
      anzahl = anzahl - 1;
    }
    return gefresseneKoerner;
  }

  // der Hamster legt alle Koerner, die er im Maul hat,
  // auf der aktuellen Kachel ab;
  // geliefert wird die Anzahl abgelegter Koerner
  int gibAlle() {
    int abgelegteKoerner = 0;
    while (!this.maulLeer()) {
      this.gib();
      abgelegteKoerner = abgelegteKoerner + 1;
    }
    return abgelegteKoerner;
  }

  // der Hamster frisst alle Koerner auf der aktuellen Kachel;
  // geliefert wird die Anzahl gefressener Koerner
  int nimmAlle() {
    int gefresseneKoerner = 0;
    while (this.kornDa()) {
      this.nimm();
      gefresseneKoerner = gefresseneKoerner + 1;
    }
    return gefresseneKoerner;
  }

  // der Hamster laeuft bis zur naechsten Mauer;
  // geliefert wird die Anzahl ausgefuehrter Schritte
  int laufeZurWand() {
    int schritte = 0;
    while (this.vornFrei()) {
      this.vor();
      schritte = schritte + 1;
    }
    return schritte;
  }
  
  // der Hamster testet, ob links von ihm die Kachel frei ist
  boolean linksFrei() {
    this.linksUm();
    boolean frei = this.vornFrei();
    this.rechtsUm();
    return frei;
  }

  // der Hamster testet, ob rechts von ihm die Kachel frei ist
  boolean rechtsFrei() {
    this.rechtsUm();
    boolean frei = this.vornFrei();
    this.linksUm();
    return frei;
  }

  // der Hamster testet, ob hinter ihm die Kachel frei ist
  boolean hintenFrei() {
    this.kehrt();
    boolean frei = this.vornFrei();
    this.kehrt();
    return frei;
  }

  // der Hamster dreht sich so lange um, bis er in die
  // uebergebene Blickrichtung schaut
  void setzeBlickrichtung(int richtung) {
    while (this.getBlickrichtung() != richtung) {
      this.linksUm();
    }
  }
  
  // der Hamster laeuft zur Kachel (reihe/spalte);
  // Voraussetzung: die Kachel existiert und
  // es befinden sich keine Mauern
  // im Territorium bzw. auf dem gewaehlten Weg
  void gotoKachel(int reihe, int spalte) {
    // zunaechst begibt sich der Hamster in die entsprechende
    // Reihe
    if (reihe > this.getReihe()) {
      this.setzeBlickrichtung(Hamster.SUED);
    } else {
      this.setzeBlickrichtung(Hamster.NORD);
    }
    while (reihe != this.getReihe()) {
      this.vor();
    }

    // nun begibt sich der Hamster in die entsprechende
    // Spalte
    if (spalte > this.getSpalte()) {
      this.setzeBlickrichtung(Hamster.OST);
    } else {
      this.setzeBlickrichtung(Hamster.WEST);
    }
    while (spalte != this.getSpalte()) {
      this.vor();
    }
  }
}
