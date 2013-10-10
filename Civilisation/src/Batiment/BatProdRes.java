package Batiment;
import joueur.Joueur;
import civ.Case;

public class BatProdRes extends Batiment
{
	public enum typeRessource
	{
		or,
		fer,
		pierre,
		bois,
		nourriture;
	}
	
	//*************** Variables *******************
	private typeRessource typeres;
	private int prodRessources[] = {10,15,20,25,40};
	
	//*************** Constructeur *******************
	public BatProdRes(String name,int V[], typeRessource t, Case M)
	{	
		super(name, 50, 0, 20, 0, true, V, 1, M);
		this.setRESSOURCE(t);
	}
	
	//*************** Accesseurs *******************
	public typeRessource getRESSOURCE()
	{
		return this.typeres;
	}
	
	public int[] getPRODRESSOURCES()
	{
		return this.prodRessources;
	}
	
	//*************** Mutateurs *******************
	public void setRESSOURCE(typeRessource t)
	{
		this.typeres = t;
	}
	
	public void setPRODRESSOURCES(int t[])// toutes les ressources d'un coup
	{
		this.prodRessources = t;
	}
	
	public void setPRODRESSOURCES(int t, int i)// une ressource seulement
	{
		this.prodRessources[i] = t;
	}
	
	//*************** Méthodes *******************
	public void productionDeRessources(Joueur j)
	{
		switch(this.typeres)
		{
		case or: j.setOr(j.getOr() + this.prodRessources[0]);
			break;
		case fer: //
			break;
		case bois: j.setBois(j.getBois() + this.prodRessources[2]);
			break;
		case nourriture: j.setNourriture(j.getNourriture() + this.prodRessources[3]);
			break;
		default:
			break;
		}
	}
}
