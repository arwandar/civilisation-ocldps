package Batiment;

import joueur.Joueur;
import civ.Case;

public class BatAtelierDeSiege extends BatProdUnit
{
	
	//*************** Constructeur *******************
	public BatAtelierDeSiege(int V[], Case M, Joueur J)
	{
		super("atelier de si�ge", 75, 15, 0.40, 1, true, V, 3, M);
		
		this.typesUnits.add(typeUnite.Catapulte);
		
		this.coutOr = 200;
		this.coutFer = 150;
		this.coutBois = 300;
		this.coutPierre = 450;
		J.setOr(J.getOr() - this.coutOr);
		J.setFer(J.getFer() - this.coutFer);
		J.setBois(J.getBois() - this.coutBois);
		J.setPierre(J.getPierre() - this.coutPierre);
		
		this.setPortee(5);
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