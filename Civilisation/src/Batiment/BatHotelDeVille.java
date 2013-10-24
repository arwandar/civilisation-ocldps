package Batiment;

import joueur.Joueur;
import civ.Case;

public class BatHotelDeVille extends BatProdUnit
{
	//*************** Constructeur *******************
	public BatHotelDeVille(int V[], Case M, Joueur J)
	{
		super("Hotel de ville", 100, 10, 50, 1, true, V, 5, M);
		
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