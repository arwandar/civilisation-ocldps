package Batiment;

import joueur.Joueur;
import civ.Case;

public class BatCaserne extends BatProdUnit
{
	//*************** Constructeur *******************
	public BatCaserne(int V[], Case M, Joueur J)
	{
		super("Caserne", 50, 15, 0.40, 1, true, V, 2, M);
		
		this.typesUnits.add(typeUnite.Milicien);
		
		this.coutOr = 50;
		this.coutFer = 35;
		this.coutBois = 75;
		this.coutPierre = 110;
		J.setOr(J.getOr() - this.coutOr);
		J.setFer(J.getFer() - this.coutFer);
		J.setBois(J.getBois() - this.coutBois);
		J.setPierre(J.getPierre() - this.coutPierre);
		
		this.setPortee(1);
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