package Unites;
import Comportement.*;

public class Transporteur extends Personnage {
	public Transporteur(){
		this.deplacement = new Bateau();
		this.Defense=15;
		this.PV=100;
		
	}
	public Transporteur(AttitudeCombative esprit, Soin soin, Deplacement dep, Construire cons, int att, int def, int pv, int tProd, int cN, int cO, int cB, int cF) {
	    super(esprit, soin, dep, cons, att, def, pv, tProd, cN, cO, cB, cF);
	  }
}
