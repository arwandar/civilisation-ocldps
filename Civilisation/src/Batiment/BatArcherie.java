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
}