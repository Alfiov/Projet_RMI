
import java.io.*;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {

	public static void main(String args[]) throws RemoteException {

		String serveur = "localhost";
		int port = 1099;
		String fichier = "";
		try {
			serveur = args[1];
			port = Integer.parseInt(args[2]);
		}catch (Exception ignored)
		{}
		try {
			fichier = args[0];

		}catch (Exception e)
		{
			System.out.println("Mauvais usage");
			return;
		}
		try {

			Registry reg = LocateRegistry.getRegistry(serveur, port);
			String[] list = reg.list();
			ServiceDistributeur compteur = (ServiceDistributeur) reg.lookup("Texte");

			File doc = new File(fichier);

			BufferedReader obj = new BufferedReader(new FileReader(doc));

			String strng;
			String res = "";
			while ((strng = obj.readLine()) != null) {
				res += strng +"\n";
			}
			System.out.println("Il y a "+compteur.distribuerFichier(res)+" mots");




		} catch (NotBoundException | IOException ex) {
			ex.printStackTrace();
		}

	}
}
