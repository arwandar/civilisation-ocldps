package Unites;
import Comportement.*;

public class Peon extends Personnage {
	public Peon(){
		this.construire = new Constructeur();
		this.PV=25;
		
		this.tempsProduction=1;
		this.coutNourriture=50;
	}
	public Peon(AttitudeCombative esprit, Soin soin, Deplacement dep, Construire cons, int att, int def, int pv, int tProd, int cN, int cO, int cB, int cF) {
	    super(esprit, soin, dep, cons, att, def, pv, tProd, cN, cO, cB, cF);
	  }
}