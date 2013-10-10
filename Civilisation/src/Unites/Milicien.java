package Unites;
import Comportement.*;



public class Milicien extends Personnage{
	 public Milicien(){
		    this.attitudeCombative = new CombatEpee();
		    this.Attaque=8;
			this.PV=40;
			
			this.tempsProduction=1;
			this.coutNourriture=60;
			this.coutOr=20;
		  }


}
