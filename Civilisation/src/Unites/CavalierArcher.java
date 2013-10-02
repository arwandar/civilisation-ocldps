package Unites;
import Comportement.*;

public class CavalierArcher extends Personnage {
	public CavalierArcher(){
		this.attitudeCombative= new CombatArc();
		this.deplacement = new Cheval();
		this.Attaque=6;
		this.Defense=20;
		this.PV=50;
		
	}
	public CavalierArcher(AttitudeCombative esprit, Soin soin, Deplacement dep, Construire cons, int att, int def, int pv, int tProd, int cN, int cO, int cB, int cF) {
	    super(esprit, soin, dep, cons, att, def, pv, tProd, cN, cO, cB, cF);
	  }
}
