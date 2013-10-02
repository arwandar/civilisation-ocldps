package Unites;
import Comportement.*;


public class Magicien extends Personnage {
	public Magicien(){
		this.attitudeCombative= new CombatMagie();
		this.Attaque=7;
		this.PV=30;
		
	}
	public Magicien(AttitudeCombative esprit, Soin soin, Deplacement dep, Construire cons, int att, int def, int pv, int tProd, int cN, int cO, int cB, int cF) {
	    super(esprit, soin, dep, cons, att, def, pv, tProd, cN, cO, cB, cF);
	  }
}
