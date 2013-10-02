package Unites;
import Comportement.*;

public class Chevalier extends Personnage {
	public Chevalier(){
		this.attitudeCombative= new CombatEpee();
		this.deplacement = new Cheval();
		this.Attaque=7;
		this.Defense=25;
		this.PV=60;
		
	}
	public Chevalier(AttitudeCombative esprit, Soin soin, Deplacement dep, Construire cons, int att, int def, int pv, int tProd, int cN, int cO, int cB, int cF) {
	    super(esprit, soin, dep, cons, att, def, pv, tProd, cN, cO, cB, cF);
	  }
}
