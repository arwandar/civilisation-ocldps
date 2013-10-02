package Unites;
import Comportement.*;

public class Archer extends Personnage {
	public Archer(){
		this.attitudeCombative= new CombatArc();
		
	}
	public Archer(AttitudeCombative esprit, Soin soin, Deplacement dep, Construire cons) {
	    super(esprit, soin, dep, cons);
	  }
}
