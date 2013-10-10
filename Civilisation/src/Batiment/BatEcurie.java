package Batiment;

import joueur.Joueur;
import civ.Case;

public class BatEcurie extends BatProdUnit
{
	//*************** Constructeur *******************
	public BatEcurie(int V[], Case M, Joueur J)
	{
		super("Ecurie", 50, 15, 45, 1, true, V, 3, M, J);
		this.typesUnits.add(typeUnite.Chevalier);
		this.coutOr = 150;
		this.coutFer = 100;
		this.coutBois = 200;
		this.coutPierre = 300;
		J.setOr(J.getOr() - this.coutOr);
		J.setFer(J.getFer() - this.coutFer);
		J.setBois(J.getBois() - this.coutBois);
		J.setPierre(J.getPierre() - this.coutPierre);
	}
}