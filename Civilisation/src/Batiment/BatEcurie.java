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
		
		J.getBatiments().add(this);
		this.joueur = J;
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