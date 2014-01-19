package Batiment;

import joueur.Joueur;
import civ.Case;

public class BatPort extends BatProdUnit
{	
	//*************** Constructeur *******************
	public BatPort(int V[], Case M, Joueur J)// il faudrait pouvoir construire le port QUE si une des 4 cases adjacente est maritime.
	{
		super("Port", 50, 15, 0.40, 1, true, V, 3, M);
		
		this.typesUnits.add(typeUnite.Galere);
		this.typesUnits.add(typeUnite.Transporteur);
		
		this.coutOr = 75;
		this.coutFer = 50;
		this.coutBois = 300;
		this.coutPierre = 100;
		J.setOr(J.getOr() - this.coutOr);
		J.setFer(J.getFer() - this.coutFer);
		J.setBois(J.getBois() - this.coutBois);
		J.setPierre(J.getPierre() - this.coutPierre);
		
		this.setPortee(5);
		this.setIsUsed(false);
		
		J.getBatiments().add(this);
		this.joueur = J;
	}
	
	//*************** Méthodes *******************
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