package Unites;
import Comportement.*;

public class Catapulte extends Personnage {
	public Catapulte(){
		this.attitudeCombative= new CombatSiege();
		
	}
	public Catapulte(AttitudeCombative esprit, Soin soin, Deplacement dep, Construire cons) {
	    super(esprit, soin, dep, cons);
	  }
}
