import java.rmi.Remote;
import java.rmi.RemoteException;

import de.hamster.debugger.model.Territorium;import de.hamster.debugger.model.Territory;import de.hamster.model.HamsterException;import de.hamster.model.HamsterInitialisierungsException;import de.hamster.model.HamsterNichtInitialisiertException;import de.hamster.model.KachelLeerException;import de.hamster.model.MauerDaException;import de.hamster.model.MaulLeerException;import de.hamster.model.MouthEmptyException;import de.hamster.model.WallInFrontException;import de.hamster.model.TileEmptyException;import de.hamster.debugger.model.Hamster;public interface RemoteHamster extends Remote {
    public void vor() throws RemoteException;
    public void linksUm() throws RemoteException;
    public void nimm() throws RemoteException;
    public void gib() throws RemoteException;
    
    public boolean vornFrei() throws RemoteException;
    public boolean maulLeer() throws RemoteException;
    public boolean kornDa() throws RemoteException;
    
    public void schreib(String zeichenkette) throws RemoteException;
    public String liesZeichenkette(String aufforderung) throws RemoteException;
    public int liesZahl(String aufforderung) throws RemoteException;
}
