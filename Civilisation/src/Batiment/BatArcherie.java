package Batiment;

import joueur.Joueur;
import civ.Case;

public class BatArcherie extends BatProdUnit
{
	//*************** Constructeur *******************
	public BatArcherie(int V[], Case M, Joueur J)
	{
		super("Archerie", 50, 15, 40, 1, true, V, 2, M);
		
		this.typesUnits.add(typeUnite.Archer);
		this.typesUnits.add(typeUnite.CavalierArcher);
		
		this.coutOr = 50;
		this.coutFer = 50;
		this.coutBois = 100;
		this.coutPierre = 150;
		J.setOr(J.getOr() - this.coutOr);
		J.setFer(J.getFer() - this.coutFer);
		J.setBois(J.getBois() - this.coutBois);
		J.setPierre(J.getPierre() - this.coutPierre);
		
		J.getBatiments().add(this);
		this.joueur = J;
	}
	
	//*************** Méthodes *******************
	public void newUnit(typeUnite u)
	{
		
	}
	
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