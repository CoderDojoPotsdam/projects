import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;public class hamsterprogramm extends de.hamster.debugger.model.IHamster implements de.hamster.model.HamsterProgram {boolean genauEineMauerNebenan() {
     boolean vornMauer = !vornFrei();
     linksUm();
     boolean linksMauer = !vornFrei();
     linksUm();
     boolean hintenMauer = !vornFrei();
     linksUm();
     boolean rechtsMauer = !vornFrei();
     linksUm();  // zur Vermeidung von Seiteneffekten
     return
         vornMauer && 
             !(hintenMauer || rechtsMauer || linksMauer) 
         ||
         linksMauer && 
             !(hintenMauer || rechtsMauer || vornMauer) 
         ||
         hintenMauer && 
             !(linksMauer || rechtsMauer || vornMauer) 
         ||
         rechtsMauer && 
             !(hintenMauer || linksMauer || vornMauer);
}

// einfaches Testprogramm 
public void main()  { 
    if (genauEineMauerNebenan()) {
        linksUm(); 
    } else {  
        linksUm(); 
        linksUm();
    } 
} }