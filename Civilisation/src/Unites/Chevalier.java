package Unites;
import civ.Case;
import joueur.Joueur;
import Batiment.BatProdUnit.typeUnite;
import Comportement.Cheval;
import Comportement.CombatEpee;

public class Chevalier extends Personnage {
	public Chevalier(Joueur J){
		
		J.getPersonnages().add(this);
		this.joueur = J;
		
		this.setNOM("Chevalier");
		
		this.attitudeCombative= new CombatEpee();
		this.deplacer = new Cheval();
		this.Attaque=14;
		this.Defense=25;
		this.PVMax=60;
		this.PV=PVMax;
		
		this.tempsProduction=2;
		this.coutNourriture=60;
		this.coutOr=50;
		J.setOr(J.getOr() - this.coutOr);
		J.setNourriture(J.getNourriture() - this.coutNourriture);
		
		this.setT(typeUnite.Chevalier);
	}
	
	//*************** Méthodes *******************
	@Override public void destructionUnite(Joueur J)
	{
		if(this.getPV() > 0)
		{
			J.setOr(J.getOr() + this.coutOr/2);
			J.setNourriture(J.getNourriture() + this.coutNourriture/2);
		}
		
		J.getPersonnages().remove(this);
		J.setOs(100);
	}
}
