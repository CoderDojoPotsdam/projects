import de.hamster.debugger.model.Territorium;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.debugger.model.Hamster;class OktalHamster extends DualHamster {
  // Konstruktor
  OktalHamster(int r, int s, int b, int k) {
    super(r, s, b, k);
  }
  
  // zeichnet eine 2 aus Koernern
  void zeichne2() {
    this.vorUndGib(3);
    this.rechtsUm();
    this.vorUndGib(2);
    this.rechtsUm();
    this.vorUndGib(2);
    this.linksUm();
    this.vorUndGib(2);
    this.linksUm(); 
    this.vorUndGib(2);
    this.kehrt();
    this.vor(2);
    this.rechtsUm();
    this.vor(4);
    this.linksUm();
    this.vor();
    this.kehrt();
  }
  
  // zeichnet eine 3 aus Koernern
  void zeichne3() {
    // siehe Aufgabe 2
  }

  // zeichnet eine 4 aus Koernern
  void zeichne4() {
    // siehe Aufgabe 2
  }
  
  // zeichnet eine 5 aus Koernern
  void zeichne5() {
    // siehe Aufgabe 2
  }
  
  // zeichnet eine 6 aus Koernern
  void zeichne6() {
    // siehe Aufgabe 2
  }
  
  // zeichnet eine 7 aus Koernern
  void zeichne7() {
    // siehe Aufgabe 2
  }
  
  // zeichnet die uebergebene Dezimalzahl als Zahl
  // zur Basis 8 aus Koernern
  void zeichne(int dezimalZahl) {
    this.setzeBlickrichtung(Hamster.OST);
    if (dezimalZahl < 8) {
      this.zeichneZiffer(dezimalZahl);
      this.vor(4);
    } else {
      this.zeichne(dezimalZahl / 8); // Rekursion!
      this.zeichneZiffer(dezimalZahl % 8);
      this.vor(4);
    }
  }
  
  // zeichnet die uebergebene Ziffer aus Koernern
  void zeichneZiffer(int ziffer) {
    super.zeichneZiffer(ziffer); // Aufruf der geerbten Methode
    if (ziffer == 2) {
      this.zeichne2();
    } else if (ziffer == 3) {
      this.zeichne3();
    } else if (ziffer == 4) {
      this.zeichne4();
    } else if (ziffer == 5) {
      this.zeichne5();
    } else if (ziffer == 6) {
      this.zeichne6();
    } else if (ziffer == 7) {
      this.zeichne7();
    }
  }
}
