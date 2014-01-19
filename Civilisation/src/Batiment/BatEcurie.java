package Batiment;

import joueur.Joueur;
import civ.Case;

public class BatEcurie extends BatProdUnit
{
	//*************** Constructeur *******************
	public BatEcurie(int V[], Case M, Joueur J)
	{
		super("Ecurie", 50, 15, 0.45, 1, true, V, 3, M);
		
		this.typesUnits.add(typeUnite.Chevalier);
		
		this.coutOr = 150;
		this.coutFer = 100;
		this.coutBois = 200;
		this.coutPierre = 300;
		J.setOr(J.getOr() - this.coutOr);
		J.setFer(J.getFer() - this.coutFer);
		J.setBois(J.getBois() - this.coutBois);
		J.setPierre(J.getPierre() - this.coutPierre);
		
		this.setPortee(1);
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