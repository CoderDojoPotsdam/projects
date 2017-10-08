import de.hamster.debugger.model.Territorium;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.debugger.model.Hamster;class Sortieren {
  
  // Sortieren mit Bubblesort-Algorithmus
  static void bubbleSort(Vergleichbar[] objekte) {
    boolean getauscht = false;
    do {
      getauscht = false;
      for (int i=1; i<objekte.length; i++) {
        if (objekte[i-1].groesser(objekte[i])) { // dyn. gebunden
          Vergleichbar ablage = objekte[i-1];
          objekte[i-1] = objekte[i];
          objekte[i] = ablage;
          getauscht = true;
        }
      }
    } while (getauscht);
  }
  
  // Sortieren mit Quicksort-Algorithmus
  static void quickSort(Vergleichbar[] objekte) {
    Sortieren.quickSort(objekte, 0, objekte.length-1);
  }

  // Hilfsmethode
  static void quickSort(Vergleichbar[] objekte, 
                        int vonIndex, int bisIndex) {
    int i = vonIndex;
    int j = bisIndex;
    Vergleichbar mittlererWert = objekte[(vonIndex+bisIndex)/2];

    //  Aufteilung
    while (i<=j) {    
      while (objekte[i].kleiner(mittlererWert)) { // dyn. gebunden
        i++;
      }
      while (objekte[j].groesser(mittlererWert)) { // dyn. gebunden
        j--;
      }
      if (i <= j) { // tauschen
        Vergleichbar ablage = objekte[i];
        objekte[i] = objekte[j];
        objekte[j] = ablage;
        i++; 
        j--;
      }
    }

    // rekursiver Aufruf
    if (vonIndex < j) Sortieren.quickSort(objekte, vonIndex, j);
    if (i < bisIndex) Sortieren.quickSort(objekte, i, bisIndex);
  }
}