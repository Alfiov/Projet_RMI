import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServiceNoeud extends Remote {
     int traiter(String s) throws RemoteException;
}
