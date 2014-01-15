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
		
			this.coutOr = 200;
			this.coutFer = 150;
			this.coutBois = 300;
			this.coutPierre = 200;
			J.setOr(J.getOr() - this.coutOr);
			J.setFer(J.getFer() - this.coutFer);
			J.setBois(J.getBois() - this.coutBois);
			J.setPierre(J.getPierre() - this.coutPierre);
		
			J.getBatiments().add(this);
			this.joueur = J;
		}
	}
	
	//*************** Méthodes *******************
	public void destructionBatiment(Case M, Joueur J)
	{
		// Si on veut faire sortir les unités à la destruction du bâtiment, il faut le faire avant le remove(this)
		if(this.pv <= 0)
		{
			J.getBatiments().remove(this);
			M.setBatimentsurcase(false);// à remplacer par libérer case
		}
	}
}