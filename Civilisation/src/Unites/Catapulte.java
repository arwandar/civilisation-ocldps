package Unites;
import Comportement.*;

public class Catapulte extends Personnage {
	public Catapulte(){
		this.attitudeCombative= new CombatSiege();
		this.Attaque=40;
		this.Defense=20;
		this.PV=50;
		
	}
	public Catapulte(AttitudeCombative esprit, Soin soin, Deplacement dep, Construire cons, int att, int def, int pv, int tProd, int cN, int cO, int cB, int cF) {
	    super(esprit, soin, dep, cons, att, def, pv, tProd, cN, cO, cB, cF);
	}
}
