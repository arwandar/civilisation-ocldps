package Batiment;

import joueur.Joueur;
import civ.Case;


public class BatMur extends Batiment
{
	//*************** Constructeur *******************
	public BatMur(int V[], Case M, Joueur J)
	{
		super("Mur", 200, 0, 75, 0, true, V, 2, M);
		
		this.coutOr = 10;
		this.coutFer = 5;
		this.coutBois = 30;
		this.coutPierre = 50;
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
