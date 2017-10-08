import de.hamster.debugger.model.Territorium;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.debugger.model.Hamster;public class hamsterprogramm implements de.hamster.model.HamsterProgram {Hamster paul;

public void main() {
  paul = Hamster.getStandardHamster();
  ernteEineReiheUndLaufeZurueck();
  while(weitereReiheExistiert()) {
    begibDichInNaechsteReihe();
    ernteEineReiheUndLaufeZurueck();
  }
}

boolean weitereReiheExistiert() {
  paul.linksUm();
  if (paul.vornFrei()) {
    rechtsUm();
    return true;
  } else {
    rechtsUm();
    return false;
  }
}

void begibDichInNaechsteReihe() {
  paul.linksUm();
  paul.vor();
  paul.linksUm();
}

void ernteEineReiheUndLaufeZurueck() {
  ernteEineReihe();
  kehrt();
  laufeZurueck();
}

void ernteEineReihe() {
  sammle();
  while (paul.vornFrei()) {
    paul.vor();
    sammle();
  }
}

void laufeZurueck() {
  while (paul.vornFrei()) {
    paul.vor();
  }
}

void sammle() {
  while (paul.kornDa()) {
    paul.nimm();
  }
}

void rechtsUm() {
  kehrt();
  paul.linksUm();
}

void kehrt() {
  paul.linksUm();
  paul.linksUm();
}}