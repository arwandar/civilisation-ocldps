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
		}
}
