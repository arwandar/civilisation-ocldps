package Batiment;

import joueur.Joueur;
import civ.Case;

public class BatTourDesMages extends BatProdUnit
{	
	//*************** Constructeur *******************
	public BatTourDesMages(int V[], Case M, Joueur J)
	{
		super("Tour des mages", 50, 15, 0.40, 1, true, V, 2, M);
		
		this.typesUnits.add(typeUnite.Magicien);
		this.typesUnits.add(typeUnite.Healer);
		
		this.coutOr = 75;
		this.coutFer = 50;
		this.coutBois = 150;
		this.coutPierre = 150;
		J.setOr(J.getOr() - this.coutOr);
		J.setFer(J.getFer() - this.coutFer);
		J.setBois(J.getBois() - this.coutBois);
		J.setPierre(J.getPierre() - this.coutPierre);
		
		this.setPortee(4);
		this.setIsUsed(false);
		
		J.getBatiments().add(this);
		this.joueur = J;
	}
	
	//*************** M�thodes *******************
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
		M.setBatimentsurcase(false);// � remplacer par lib�rer case
	}
}