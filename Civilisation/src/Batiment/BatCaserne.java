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