package Unites;
import joueur.Joueur;
import Batiment.BatProdUnit.typeUnite;
import Comportement.CombatEpee;



public class Milicien extends Personnage{
	 public Milicien(Joueur J){
		 
		 J.getPersonnages().add(this);
			this.joueur = J;
		 
		    this.attitudeCombative = new CombatEpee();
		    this.Attaque=8;
			this.PV=40;
			
			this.tempsProduction=1;
			this.coutNourriture=60;
			this.coutOr=20;
			J.setOr(J.getOr() - this.coutOr);
			J.setOr(J.getOr() - this.coutNourriture);
			
			this.t = typeUnite.Milicien;
		  }


}
