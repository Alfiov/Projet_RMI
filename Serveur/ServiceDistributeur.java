//package Serveur;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServiceDistributeur extends Remote {
	int distribuerFichier(String var1) throws RemoteException;

	void enregistrerNoeuds(ServiceNoeud var1) throws RemoteException;

}