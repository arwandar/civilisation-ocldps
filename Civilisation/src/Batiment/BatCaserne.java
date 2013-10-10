package Batiment;

import joueur.Joueur;
import civ.Case;

public class BatCaserne extends BatProdUnit
{
	//*************** Constructeur *******************
	public BatCaserne(int V[], Case M, Joueur J)
	{
		super("Caserne", 50, 15, 40, 1, true, V, 2, M, J);
		this.typesUnits.add(typeUnite.Milicien);
		this.coutOr = 50;
		this.coutFer = 35;
		this.coutBois = 75;
		this.coutPierre = 110;
		J.setOr(J.getOr() - this.coutOr);
		J.setFer(J.getFer() - this.coutFer);
		J.setBois(J.getBois() - this.coutBois);
		J.setPierre(J.getPierre() - this.coutPierre);
	}
}