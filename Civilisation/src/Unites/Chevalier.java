package Unites;
import joueur.Joueur;
import Batiment.BatProdUnit.typeUnite;
import Comportement.Cheval;
import Comportement.CombatEpee;

public class Chevalier extends Personnage {
	public Chevalier(Joueur J){
		
		J.getPersonnages().add(this);
		this.joueur = J;
		
		this.attitudeCombative= new CombatEpee();
		this.deplacer = new Cheval();
		this.Attaque=14;
		this.Defense=25;
		this.PV=60;
		
		this.tempsProduction=2;
		this.coutNourriture=60;
		this.coutOr=50;
		J.setOr(J.getOr() - this.coutOr);
		J.setOr(J.getOr() - this.coutNourriture);
		
		this.t = typeUnite.Chevalier;
	}
}
