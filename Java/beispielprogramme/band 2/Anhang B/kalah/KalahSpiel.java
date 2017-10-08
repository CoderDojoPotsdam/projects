/*
Windows:
  CLASSPATH: Programme\beispielprogramme\band 2\Anhang B
Linux, Solaris:
  CLASSPATH: Programme/beispielprogramme/band 2/Anhang B
*/
package kalah;

import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;public class KalahSpiel {

    SchiedsrichterHamster schiedsrichter;

    // Konstruktor
    public KalahSpiel(SchiedsrichterHamster schiedsrichter) {
        this.schiedsrichter = schiedsrichter;

    }

    // Durchfuehrung eines Spiels
    public void spielen() {
        // Spielvorbereitung
        this.schiedsrichter.initialisiereSpiel();

        // es wird gemaess der Spielregeln gezogen;
        // nach jedem Spielzug kontrolliert der Schiedsrichter
        Spieler aktuellerSpieler = this.schiedsrichter
                .werIstAmZug();
        while (true) {
            Spielzug zug;
            try {
                zug = aktuellerSpieler.naechsterSpielzug();
            } catch (Exception exc) {
                // wenn waehrend der Ausfuehrung der Methode ein
                // Fehler auftritt, hat der Spieler verloren
                this.schiedsrichter
                        .schreib("Spieler "
                                + aktuellerSpieler
                                        .liefereSpielerTyp()
                                + " hat die folgende Exception erzeugt\n"
                                + " und damit verloren: "
                                + exc.toString());
                return; // Spielende
            }

            if (!this.schiedsrichter.istSpielzugOk(
                    aktuellerSpieler, zug)) {
                this.schiedsrichter.schreib("Spieler "
                        + aktuellerSpieler.liefereSpielerTyp()
                        + " hat sich nicht an die\n"
                        + "Spielregeln gehalten und damit\n"
                        + "verloren!");
                return; // Spielende
            }

            if (this.schiedsrichter.istSpielBeendet()) {
                // die verbliebenen Koerner muessen noch in die
                // Kalahs gepackt werden
                Spieler spielerA = this.schiedsrichter
                        .getSpielerA();
                spielerA.sammleResteUndBringSieZumKalah();
                if (!this.schiedsrichter
                        .istEndzustandVonSpielerAOk()) {
                    this.schiedsrichter.schreib("Spieler A"
                            + " hat sich nicht an die\n"
                            + "Spielregeln gehalten und damit\n"
                            + "verloren!");
                    return; // Spielende
                }

                Spieler spielerB = this.schiedsrichter
                        .getSpielerB();
                spielerB.sammleResteUndBringSieZumKalah();
                if (!this.schiedsrichter
                        .istEndzustandVonSpielerBOk()) {
                    this.schiedsrichter.schreib("Spieler B"
                            + " hat sich nicht an die\n"
                            + "Spielregeln gehalten und damit\n"
                            + "verloren!");
                    return; // Spielende
                }

                // Siegerehrung
                Spieler sieger = this.schiedsrichter
                        .liefereSieger();
                if (sieger == null) {
                    this.schiedsrichter
                            .schreib("Unentschieden!");
                    // zur Belohnung duerfen die Hamster noch die
                    // Koerner in ihren Kalahs fressen
                    aktuellerSpieler.spielBeenden(false);
                    Spieler gegner = this.schiedsrichter
                            .liefereGegner(aktuellerSpieler);
                    gegner.spielBeenden(false);
                } else {
                    int punkteA = this.schiedsrichter
                            .getPunkteA();
                    int punkteB = this.schiedsrichter
                            .getPunkteB();
                    this.schiedsrichter.schreib("Endstand: "
                            + punkteA + " : " + punkteB + "\n"
                            + "Spieler "
                            + sieger.liefereSpielerTyp()
                            + " hat gewonnen!");
                    // zur Belohnung duerfen die Hamster noch die
                    // Koerner in ihren Kalahs fressen
                    sieger.spielBeenden(true);
                    Spieler gegner = this.schiedsrichter
                            .liefereGegner(sieger);
                    gegner.spielBeenden(false);
                }

                return; // Spielende
            }

            // naechste Runde
            aktuellerSpieler = schiedsrichter.werIstAmZug();
        }
    }

}