package Unites;
import Comportement.*;



public class Milicien extends Personnage{
	 public Milicien(){
		    this.attitudeCombative = new CombatEpee();
		    this.Attaque=4;
			this.PV=40;
			
			this.tempsProduction=1;
			this.coutNourriture=60;
			this.coutOr=20;
		  }
	  public Milicien(AttitudeCombative esprit, Soin soin, Deplacement dep, Construire cons, int att, int def, int pv, int tProd, int cN, int cO, int cB, int cF, int posH, int posV, int portee) {
		    super(esprit, soin, dep, cons, att, def, pv, tProd, cN, cO, cB, cF, posH, posV, portee);
	  }

}
