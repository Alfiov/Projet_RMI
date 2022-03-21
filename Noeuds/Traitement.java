import java.rmi.RemoteException;
import java.rmi.server.RemoteServer;
import java.rmi.server.ServerNotActiveException;

public class Traitement implements ServiceNoeud{

    public int traiter(String s) throws RemoteException
    {
        String host = "";
        try{
            host = RemoteServer.getClientHost();
        }catch(ServerNotActiveException e) { }

      System.out.println("__TRAITEMENT DE "+host+"__");
     return s.split(" ").length;
    }
}
