//package Serveur;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
*/

public class LancerServeur {
	// private static final Logger log = LogManager.getLogger(LancerServeur.class);

	public static void main(String[] args) throws RemoteException {

		//log.info("Demarrage du serveur interm?diaire");

		int port = 1099;
		// int port = 8080;
		try {
			port = Integer.parseInt(args[0]);
		} catch (Exception e) {

		}
		Distributeur d = new Distributeur();
		ServiceDistributeur serv = (ServiceDistributeur) UnicastRemoteObject.exportObject(d, 0);
		Registry reg = LocateRegistry.createRegistry(port);
		reg.rebind("Texte", serv);

	}
}
