package Batiment;

import joueur.Joueur;
import civ.Case;


public class BatTourelle extends Batiment
{
	//*************** Constructeur *******************
	public BatTourelle(int V[], Case M, Joueur J)
	{
		super("Tourelle", 200, 30, 0.75, 2, true, V, 3, M);
		
		this.coutOr = 100;
		this.coutFer = 50;
		this.coutBois = 300;
		this.coutPierre = 500;
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
