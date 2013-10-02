package Unites;
import Comportement.*;

public class CavalierArcher extends Personnage {
	public CavalierArcher(){
		this.attitudeCombative= new CombatArc();
		this.deplacement = new Cheval();
		
	}
	public CavalierArcher(AttitudeCombative esprit, Soin soin, Deplacement dep, Construire cons) {
	    super(esprit, soin, dep, cons);
	  }
}
