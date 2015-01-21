Legokettenfahrzeug
==================

![](legokettenfahrzeug.jpg)

Der Quelltext befindet sich in der Datei [Legokettenfahrzeug.ino](Legokettenfahrzeug.ino).


Man ruft in `void loop(){ ... }` die Funktion `fahre(int links, int rechts)` auf. 

Ein Programm, das zwei Sekunden vorwärts und eine Sekunde rückwärts fährt, sieht so aus: 

    void loop() {
      fahre(1000, 1000)   // vorwaerts
      delay(2000);        // fuer zwei Sekunden
    
      fahre(-1000, -1000) // rueckwaerts
      delay(1000);        // fuer eine Sekunde
    }

Der restliche Inhalt der [Legokettenfahrzeug.ino](Legokettenfahrzeug.ino)-Datei muss natürlich trotzdem da sein.

Wenn man lenken möchte, benutzt man verschiedene Stärken für links und rechts:

    fahre(1000, 0)

fährt links mehr.

    fahre(0, 500)

fährt auf halber Kraft rechts, mit null Kraft links.

    fahre(0, -1000)

fährt mit voller Kraft rechts rückwärts.

Die Kräfte kann man beliebig kombinieren. 

