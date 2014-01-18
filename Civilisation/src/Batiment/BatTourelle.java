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
		// Si on veut faire sortir les unités à la destruction du bâtiment, il faut le faire avant le remove(this)
		if(this.pv <= 0)
		{
			J.getBatiments().remove(this);
			M.setBatimentsurcase(false);// à remplacer par libérer case
		}
	}
}
