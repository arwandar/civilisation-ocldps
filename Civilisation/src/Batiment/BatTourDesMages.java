package Batiment;

import joueur.Joueur;
import civ.Case;

public class BatTourDesMages extends BatProdUnit
{	
	//*************** Constructeur *******************
	public BatTourDesMages(int V[], Case M, Joueur J)
	{
		super("Tour des mages", 50, 15, 40, 1, true, V, 2, M);
		
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