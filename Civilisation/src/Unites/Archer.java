package Unites;
import joueur.Joueur;
import Batiment.BatProdUnit.typeUnite;
import Comportement.CombatArc;
import civ.Case;

public class Archer extends Personnage {
	public Archer(Joueur J){
		
		J.getPersonnages().add(this);
		this.joueur = J;
		
		this.setNOM("Archer");
		
		this.attitudeCombative= new CombatArc();
		this.Attaque=8;
		this.PVMax=30;
		this.PV=PVMax;
		
		this.tempsProduction=1;
		this.coutOr=45;
		this.coutBois=25;
		J.setOr(J.getOr() - this.coutOr);
		J.setBois(J.getBois() - this.coutBois);
		
		this.setT(typeUnite.Archer);
	}
	
	//*************** Méthodes *******************
	@Override public void destructionUnite(Joueur J)
	{
		if(this.getPV() > 0)
		{
			J.setOr(J.getOr() + this.coutOr/2);
			J.setBois(J.getBois() + this.coutBois/2);
		}
		
		J.getPersonnages().remove(this);
		J.setOs(30);
	}
}
