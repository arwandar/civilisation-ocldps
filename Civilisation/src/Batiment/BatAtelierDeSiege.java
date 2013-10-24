package Batiment;

import joueur.Joueur;
import civ.Case;

public class BatAtelierDeSiege extends BatProdUnit
{
	
	//*************** Constructeur *******************
	public BatAtelierDeSiege(int V[], Case M, Joueur J)
	{
		super("atelier de siège", 75, 15, 40, 1, true, V, 3, M);
		
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
}