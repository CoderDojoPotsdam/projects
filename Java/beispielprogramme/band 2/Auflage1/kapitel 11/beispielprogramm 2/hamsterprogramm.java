import de.hamster.debugger.model.Territorium;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.debugger.model.Hamster;public class hamsterprogramm implements de.hamster.model.HamsterProgram {public void main() {
  SchiedsrichterHamster markus = new SchiedsrichterHamster(0, 0);
  
  // der Schiedsrichter erzeugt zwei kontrollierte Wuerfel
  Wuerfel wuerfel1 = markus.liefereWuerfel();
  Wuerfel wuerfel2 = markus.liefereWuerfel();
  
  // die SpielHamster werden erzeugt und ihnen die kontrollierten
  // Wuerfel uebergeben
  SpielHamster paul = new SpielHamster(1, 0, wuerfel1);
  SpielHamster willi = new MogelHamster(2, 0, wuerfel2);

  boolean siegerPaul = false;
  boolean siegerWilli = false;
  Wuerfel spielWuerfel;
  while (!siegerPaul && !siegerWilli) {
    // Die SpielHamster uebergeben dem Schiedsrichter die
    // Wuerfel. Dieser wuerfelt fuer sie, damit ja nicht
    // gemogelt werden kann
    spielWuerfel = paul.gibWuerfel();
    int zahlPaul = markus.wuerfeln(spielWuerfel);
    spielWuerfel = willi.gibWuerfel();
    int zahlWilli = markus.wuerfeln(spielWuerfel);
    
    // der SpielHamster mit dem hoeheren Wurf darf vorruecken
    if (zahlPaul > zahlWilli) {
      siegerPaul = paul.vor(zahlPaul);
    } else if (zahlWilli > zahlPaul) {
      siegerWilli = willi.vor(zahlWilli);
    }
  }
  if (siegerPaul) {
    paul.freuen();
  } 
  if (siegerWilli) {
    willi.freuen();
  }
}
}