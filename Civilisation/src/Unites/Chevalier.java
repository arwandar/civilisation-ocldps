package Unites;
import Comportement.*;

public class Chevalier extends Personnage {
	public Chevalier(){
		this.attitudeCombative= new CombatEpee();
		this.deplacement = new Cheval();
		
	}
	public Chevalier(AttitudeCombative esprit, Soin soin, Deplacement dep, Construire cons) {
	    super(esprit, soin, dep, cons);
	  }
}
