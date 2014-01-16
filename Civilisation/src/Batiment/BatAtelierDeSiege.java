package Batiment;

import joueur.Joueur;
import civ.Case;

public class BatAtelierDeSiege extends BatProdUnit
{
	
	//*************** Constructeur *******************
	public BatAtelierDeSiege(int V[], Case M, Joueur J)
	{
		super("atelier de siège", 75, 15, 0.40, 1, true, V, 3, M);
		
		this.typesUnits.add(typeUnite.Catapulte);
		
		this.coutOr = 200;
		this.coutFer = 150;
		this.coutBois = 300;
		this.coutPierre = 450;
		J.setOr(J.getOr() - this.coutOr);
		J.setFer(J.getFer() - this.coutFer);
		J.setBois(J.getBois() - this.coutBois);
		J.setPierre(J.getPierre() - this.coutPierre);
		
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