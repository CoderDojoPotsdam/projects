import de.hamster.debugger.model.Territorium;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.debugger.model.Hamster;public class Uhrzeit {

  java.util.Calendar calender;
  int aktuelleStunde, aktuelleMinute;
  UhrHamster hamster;

  public Uhrzeit() {
    this.calender = java.util.Calendar.getInstance();
    this.hamster = null;
  }

  public void anzeigen() {
    while (true) {
      new AnzeigeThread(this);
      // warte 60 Sekunden
      try {
        Thread.sleep(60000);
      } catch (Exception exc) {}
    }
  }
	
  void aktualisieren() {
    this.calender.setTime(new java.util.Date());
    this.aktuelleStunde = this.calender.get(java.util.Calendar.HOUR_OF_DAY);
    this.aktuelleMinute = this.calender.get(java.util.Calendar.MINUTE);
  }
}

class AnzeigeThread extends Thread {

  Uhrzeit uhrzeit;

  AnzeigeThread(Uhrzeit zeit) {
    this.uhrzeit = zeit;
    this.start();
  }

  public void run() {
    this.uhrzeit.aktualisieren();
    if (this.uhrzeit.hamster == null) {
      this.uhrzeit.hamster = new UhrHamster(this.uhrzeit.aktuelleStunde, this.uhrzeit.aktuelleMinute);
    } else {
      this.uhrzeit.hamster.maleUhrzeit(this.uhrzeit.aktuelleStunde, this.uhrzeit.aktuelleMinute);
    }
  }
}
