package Batiment;

import joueur.Joueur;
import civ.Case;

public class BatHotelDeVille extends BatProdUnit
{
	//*************** Constructeur *******************
	public BatHotelDeVille(int V[], Case M, Joueur J)
	{
		super("Hotel de ville", 100, 10, 0.50, 1, true, V, 5, M);
		
		if(this.isConstructible == true)
		{
			this.typesUnits.add(typeUnite.Peon);
			this.typesUnits.add(typeUnite.SuperMouton);
		
			this.coutOr = 200;
			this.coutFer = 150;
			this.coutBois = 300;
			this.coutPierre = 200;
			J.setOr(J.getOr() - this.coutOr);
			J.setFer(J.getFer() - this.coutFer);
			J.setBois(J.getBois() - this.coutBois);
			J.setPierre(J.getPierre() - this.coutPierre);
			
			this.setPortee(1);
			this.setIsUsed(false);
		
			J.getBatiments().add(this);
			this.joueur = J;
		}
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