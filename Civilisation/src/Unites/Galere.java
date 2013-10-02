package Unites;
import Comportement.*;

public class Galere extends Personnage {
	public Galere(){
		this.attitudeCombative= new CombatArc();
		this.deplacement = new Bateau();
		this.Attaque=6;
		this.Defense=20;
		this.PV=120;
		
		this.tempsProduction=3;
		this.coutOr=30;
		this.coutBois=90;
	}
	public Galere(AttitudeCombative esprit, Soin soin, Deplacement dep, Construire cons, int att, int def, int pv, int tProd, int cN, int cO, int cB, int cF) {
	    super(esprit, soin, dep, cons, att, def, pv, tProd, cN, cO, cB, cF);
	  }
}
