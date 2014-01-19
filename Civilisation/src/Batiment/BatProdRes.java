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
		nourriture,
		os;
	}
	
	//*************** Variables *******************
	private typeRessource typeres;
	private int prodRessources[] = {20,30,40,50,100};
	
	//*************** Constructeur *******************
	public BatProdRes(int V[], typeRessource t, Case M, Joueur J)
	{	
		super("mine", 50, 0, 0.20, 0, true, V, 1, M);
		
		this.setRESSOURCE(t);
		
		this.coutOr = 20;
		this.coutFer = 5;
		this.coutBois = 10;
		this.coutPierre = 30;
		J.setOr(J.getOr() - this.coutOr);
		J.setFer(J.getFer() - this.coutFer);
		J.setBois(J.getBois() - this.coutBois);
		J.setPierre(J.getPierre() - this.coutPierre);
		
		this.setPortee(1);
		this.setIsUsed(false);
		
		J.getBatiments().add(this);
		this.joueur = J;
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
		if(j.CanPlayerProduce() == true)
		{
			switch(this.typeres)
			{
			case or: j.setOr(j.getOr() + this.prodRessources[0]);
				break;
			case fer: j.setFer(j.getFer() + this.prodRessources[1]);
				break;
			case pierre: j.setFer(j.getFer() + this.prodRessources[2]);
				break;
			case bois: j.setBois(j.getBois() + this.prodRessources[3]);
				break;
			case nourriture: j.setNourriture(j.getNourriture() + this.prodRessources[4]);
				break;
			default:System.out.println("Aucune ressource de ce type n'existe");
				break;
			}
		}
	}
	
	@Override public void destructionBatiment(Case M, Joueur J)
	{
		if(this.getPV() > 0)
		{
			J.setOr(J.getOr() + this.coutOr/2);
			J.setFer(J.getFer() + this.coutFer/2);
			J.setBois(J.getBois() + this.coutBois/2);
			J.setPierre(J.getPierre() + this.coutPierre/2);
		}
		
		J.getBatiments().remove(this);
		M.setBatimentsurcase(false);// à remplacer par libérer case
	}
}
