
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Noeud {
	public static void main(String[] args) throws RemoteException, NotBoundException {
		int port = 1099;
		try {
			port = Integer.parseInt(args[1]);

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("__NOEUD EN LIGNE__");
		Traitement t = new Traitement();
		Registry reg = LocateRegistry.getRegistry(args[0], port);
		ServiceDistributeur dist = (ServiceDistributeur) reg.lookup("Texte");
		dist.enregistrerNoeuds((ServiceNoeud) UnicastRemoteObject.exportObject(t, 0));

	}
}
