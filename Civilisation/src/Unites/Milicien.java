package Unites;
import joueur.Joueur;
import Comportement.CombatEpee;



public class Milicien extends Personnage{
	 public Milicien(Joueur J){
		 
		 	super(J);
		 
		    this.attitudeCombative = new CombatEpee();
		    this.Attaque=8;
			this.PV=40;
			
			this.tempsProduction=1;
			this.coutNourriture=60;
			this.coutOr=20;
		  }


}
