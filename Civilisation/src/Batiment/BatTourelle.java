package Batiment;

import joueur.Joueur;
import civ.Case;


public class BatTourelle extends Batiment
{
	//*************** Constructeur *******************
	public BatTourelle(int V[], Case M, Joueur J)
	{
		super("Tourelle", 200, 30, 75, 2, true, V, 3, M);
		this.coutOr = 100;
		this.coutFer = 50;
		this.coutBois = 300;
		this.coutPierre = 500;
		J.setOr(J.getOr() - this.coutOr);
		J.setFer(J.getFer() - this.coutFer);
		J.setBois(J.getBois() - this.coutBois);
		J.setPierre(J.getPierre() - this.coutPierre);
	}
}
