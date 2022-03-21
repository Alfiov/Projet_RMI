//package Serveur;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collections;

public class Distributeur implements ServiceDistributeur {
	private ArrayList<ServiceNoeud> des;


	public Distributeur() {
		this.des = new ArrayList<ServiceNoeud>();
	}

	public int distribuerFichier(String var1) throws RemoteException {
		ArrayList<String> parts = decouperTexte(var1);
		System.out.println("__DECOUPAGE EN "+parts.size()+" PARTIE(S)__");
		int somme =0;
		int i = 0;
		for(String t : parts)
		{
			if(i<this.des.size())
			{
				somme += this.des.get(i).traiter(t);
				i++;
			}
			else
			{
				i=0;
			}
		}
		return somme;
	}

	public void enregistrerNoeuds(ServiceNoeud var1) throws RemoteException {
		this.des.add(var1);
	}

	public ArrayList<String> decouperTexte(String t)
	{
		ArrayList<String> parts = new ArrayList<>();
		String[] aled = t.split("\n");
		Collections.addAll(parts, aled);

		return parts;
	}

}
