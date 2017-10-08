import de.hamster.debugger.model.Territorium;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;public class hamsterprogramm extends de.hamster.debugger.model.IHamster implements de.hamster.model.HamsterProgram {boolean genauEineMauerNebenan()
{
     boolean vorn_mauer = !vornFrei();
     linksUm();
     boolean links_mauer = !vornFrei();
     linksUm();
     boolean hinten_mauer = !vornFrei();
     linksUm();
     boolean rechts_mauer = !vornFrei();
     linksUm();  // zur Vermeidung von Seiteneffekten
     return
       vorn_mauer && !(hinten_mauer||rechts_mauer||links_mauer) ||
       links_mauer && !(hinten_mauer||rechts_mauer||vorn_mauer) ||
       hinten_mauer && !(links_mauer||rechts_mauer||vorn_mauer) ||
       rechts_mauer && !(hinten_mauer||links_mauer||vorn_mauer);
}

public void main()  // einfaches Testprogramm 
{ 
    if (genauEineMauerNebenan())  
      linksUm(); 
    else 
    {  
      linksUm(); linksUm();
    } 
} 
}