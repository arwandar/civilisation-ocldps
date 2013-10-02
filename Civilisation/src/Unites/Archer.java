package Unites;
import Comportement.*;

public class Archer extends Personnage {
	public Archer(){
		this.attitudeCombative= new CombatArc();
		this.Attaque=4;
		this.PV=30;
		
		this.tempsProduction=1;
		this.coutOr=45;
		this.coutBois=25;
	}
	public Archer(AttitudeCombative esprit, Soin soin, Deplacement dep, Construire cons, int att, int def, int pv, int tProd, int cN, int cO, int cB, int cF) {
	    super(esprit, soin, dep, cons, att, def, pv, tProd, cN, cO, cB, cF);
	  }
}
